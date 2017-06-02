import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;


public class Signed{
	
	/**
	 *函数名：getM1
	 *功能：将h0中的字母转换为响应的数字
	 *调用：
	 *被调用：
	 *修改记录：
	 * @param h0
	 * @return m1
	 */
	public String getM1(String h0){
		String m1 = null;
		//将h0中的字母转换为响应的数字
		for(int i = 0;i < h0.length();i++){
			char c = h0.charAt(i);
			if(c >= 'a' && c <= 'z'){
				char temp =(char) (c - 49);
				h0 = h0.replace(c, temp);
			}
		}
		System.out.println("m1:"+h0);
		m1 = h0;
		return m1;
	}
	
	/**
	 *函数名：getM1_8
	 *功能：获取m1的前八位数字m
	 *调用：
	 *被调用：
	 *修改记录：
	 * @param m1
	 * @return
	 */
	public String getM1_8(String m1){
		String m = String.valueOf(m1.charAt(0));
		
		for(int i = 1;i < 8;i++){
			char c = m1.charAt(i);
			m = m + c;
		}
		System.out.println("m1前八位m："+m);
		return m;
	}
	
	
	
	
	public static void main(String[] args){
		//获取信息摘要
		
		 MD5 getMD5 = new MD5();
		 Signed signed = new Signed();
		 RSA rsa = new RSA();
		 
		 String m0 = "yushihui";		//需要签名的信息
		 String h0 = getMD5.GetMD5Code(m0);
		 
		 System.out.println("h0："+h0);
		 
		 String m1 = signed.getM1(h0);
		 String mt = signed.getM1_8(m1);
		 long m = Long.parseLong(mt);
		 
		 long b = rsa.getB();		//公钥b作为解密
		 long a = rsa.getD();		//私钥a作为加密
		 
		 long a1 = 17;
		 
		 //签名过程
		 long c = rsa.encrypt(a,m);
		 //C1伪造
		 long c1 = rsa.encrypt(a1, m);
		 
		 long mp = rsa.decipher(b, c);
		 
		 long mp1 = rsa.decipher(b, c1);
		 
		 if(m != mp){
			 System.out.println("(m2,m)不相等！");
		 }
		 else {
			 System.out.println("(m2,m)相等！");
		}
		 
		 if(m != mp1){
			 System.out.println("(m2,m1)不相等！");
		 }
		 else {
			 System.out.println("(m2,m1)相等！");
		}
		 
	}
}
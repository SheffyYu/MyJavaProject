import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;


public class Signed{
	
	/**
	 *��������getM1
	 *���ܣ���h0�е���ĸת��Ϊ��Ӧ������
	 *���ã�
	 *�����ã�
	 *�޸ļ�¼��
	 * @param h0
	 * @return m1
	 */
	public String getM1(String h0){
		String m1 = null;
		//��h0�е���ĸת��Ϊ��Ӧ������
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
	 *��������getM1_8
	 *���ܣ���ȡm1��ǰ��λ����m
	 *���ã�
	 *�����ã�
	 *�޸ļ�¼��
	 * @param m1
	 * @return
	 */
	public String getM1_8(String m1){
		String m = String.valueOf(m1.charAt(0));
		
		for(int i = 1;i < 8;i++){
			char c = m1.charAt(i);
			m = m + c;
		}
		System.out.println("m1ǰ��λm��"+m);
		return m;
	}
	
	
	
	
	public static void main(String[] args){
		//��ȡ��ϢժҪ
		
		 MD5 getMD5 = new MD5();
		 Signed signed = new Signed();
		 RSA rsa = new RSA();
		 
		 String m0 = "yushihui";		//��Ҫǩ������Ϣ
		 String h0 = getMD5.GetMD5Code(m0);
		 
		 System.out.println("h0��"+h0);
		 
		 String m1 = signed.getM1(h0);
		 String mt = signed.getM1_8(m1);
		 long m = Long.parseLong(mt);
		 
		 long b = rsa.getB();		//��Կb��Ϊ����
		 long a = rsa.getD();		//˽Կa��Ϊ����
		 
		 long a1 = 17;
		 
		 //ǩ������
		 long c = rsa.encrypt(a,m);
		 //C1α��
		 long c1 = rsa.encrypt(a1, m);
		 
		 long mp = rsa.decipher(b, c);
		 
		 long mp1 = rsa.decipher(b, c1);
		 
		 if(m != mp){
			 System.out.println("(m2,m)����ȣ�");
		 }
		 else {
			 System.out.println("(m2,m)��ȣ�");
		}
		 
		 if(m != mp1){
			 System.out.println("(m2,m1)����ȣ�");
		 }
		 else {
			 System.out.println("(m2,m1)��ȣ�");
		}
		 
	}
}
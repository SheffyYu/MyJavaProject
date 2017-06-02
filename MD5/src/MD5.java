import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
/*
 * MD5 算法
*/
public class MD5 {
    
    // 全局数组
    private final static String[] strDigits = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

    public MD5() {
    }

    // 返回形式为数字跟字符串
    private static String byteToArrayString(byte bByte) {
        int iRet = bByte;
        // System.out.println("iRet="+iRet);
        if (iRet < 0) {
            iRet += 256;
        }
        int iD1 = iRet / 16;
        int iD2 = iRet % 16;
        return strDigits[iD1] + strDigits[iD2];
    }

    // 返回形式只为数字
    private static String byteToNum(byte bByte) {
        int iRet = bByte;
        System.out.println("iRet1=" + iRet);
        if (iRet < 0) {
            iRet += 256;
        }
        return String.valueOf(iRet);
    }

    // 转换字节数组为16进制字串
    private static String byteToString(byte[] bByte) {
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < bByte.length; i++) {
            sBuffer.append(byteToArrayString(bByte[i]));
        }
        return sBuffer.toString();
    }

    public static String GetMD5Code(String strObj) {
        String resultString = null;
        try {
            resultString = new String(strObj);
            MessageDigest md = MessageDigest.getInstance("MD5");
            // md.digest() 该函数返回值为存放哈希值结果的byte数组
            resultString = byteToString(md.digest(strObj.getBytes()));
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return resultString;
    }
    
    /**
     *函数名：proximity
     *功能：计算两个字符串的相似度
     *调用：
     *被调用：MD5 main
     *修改记录：
     */
    public double proximity(String s0,String s1){
    	double count = 0;		//相同的个数
    	double prox = 0; 		//相似度
    	for(int i = 0;i < s0.length();i++){
    		char c0 = s0.charAt(i);
    		char c1 = s1.charAt(i);    		
    		//同一个位置上相同则count+1
    		if(c0 == c1){
    			count++;
    		}
    	}
    	//计算相似度
    	prox =(count / (double)s0.length()) * 100;
    	
    	return prox;
    	
    }

    public static void main(String[] args) {
        MD5 getMD5 = new MD5();
        
        //初始化字符串
        String m0 = "00000111112222233333444445555566666777778888899999";
        String m1 = "00100111112222233333444445555566666777778888899999";
        String m2 = "00000121112222233333444445555566666777778888899999";
        String m3 = "00000111112322233333444445555566666777778888899999";
        String m4 = "00000111112222234333444445555566666777778888899999";
        String m5 = "00000111112222233333454445555566666777778888899999";
        String m6 = "00000111112222233333444445655566666777778888899999";
        String m7 = "00000111112222233333444445555567666777778888899999";
        String m8 = "000001111122222333334444455555666667877778888899999";
        String m9 = "00000111112222233333444445555566666777778988899999";
        String m10 = "00000111112222233333444445555566666777778888890999";
        
        //输出MD5加密后的字符串
        System.out.println(getMD5.GetMD5Code(m0));
        System.out.println(getMD5.GetMD5Code(m1));
        System.out.println(getMD5.GetMD5Code(m2));
        System.out.println(getMD5.GetMD5Code(m3));
        System.out.println(getMD5.GetMD5Code(m4));
        System.out.println(getMD5.GetMD5Code(m5));
        System.out.println(getMD5.GetMD5Code(m6));
        System.out.println(getMD5.GetMD5Code(m7));
        System.out.println(getMD5.GetMD5Code(m8));
        System.out.println(getMD5.GetMD5Code(m9));
        System.out.println(getMD5.GetMD5Code(m10));
        
        //获取MD5加密后的字符串
        String H0 = getMD5.GetMD5Code(m0);
        String H1 = getMD5.GetMD5Code(m1);
        String H2 = getMD5.GetMD5Code(m2);
        String H3 = getMD5.GetMD5Code(m3);
        String H4 = getMD5.GetMD5Code(m4);
        String H5 = getMD5.GetMD5Code(m5);
        String H6 = getMD5.GetMD5Code(m6);
        String H7 = getMD5.GetMD5Code(m7);
        String H8 = getMD5.GetMD5Code(m8);
        String H9 = getMD5.GetMD5Code(m9);
        String H10 = getMD5.GetMD5Code(m10);
        
        //输出相似度
        System.out.println(getMD5.proximity(H0, H1) + "%");
        System.out.println(getMD5.proximity(H0, H2) + "%");
        System.out.println(getMD5.proximity(H0, H3) + "%");
        System.out.println(getMD5.proximity(H0, H4) + "%");
        System.out.println(getMD5.proximity(H0, H5) + "%");
        System.out.println(getMD5.proximity(H0, H6) + "%");
        System.out.println(getMD5.proximity(H0, H7) + "%");
        System.out.println(getMD5.proximity(H0, H8) + "%");
        System.out.println(getMD5.proximity(H0, H9) + "%");
        System.out.println(getMD5.proximity(H0, H10) + "%");
    }
}
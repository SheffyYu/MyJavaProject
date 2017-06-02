import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
/*
 * MD5 �㷨
*/
public class MD5 {
    
    // ȫ������
    private final static String[] strDigits = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

    public MD5() {
    }

    // ������ʽΪ���ָ��ַ���
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

    // ������ʽֻΪ����
    private static String byteToNum(byte bByte) {
        int iRet = bByte;
        System.out.println("iRet1=" + iRet);
        if (iRet < 0) {
            iRet += 256;
        }
        return String.valueOf(iRet);
    }

    // ת���ֽ�����Ϊ16�����ִ�
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
            // md.digest() �ú�������ֵΪ��Ź�ϣֵ�����byte����
            resultString = byteToString(md.digest(strObj.getBytes()));
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return resultString;
    }
    
    /**
     *��������proximity
     *���ܣ����������ַ��������ƶ�
     *���ã�
     *�����ã�MD5 main
     *�޸ļ�¼��
     */
    public double proximity(String s0,String s1){
    	double count = 0;		//��ͬ�ĸ���
    	double prox = 0; 		//���ƶ�
    	for(int i = 0;i < s0.length();i++){
    		char c0 = s0.charAt(i);
    		char c1 = s1.charAt(i);    		
    		//ͬһ��λ������ͬ��count+1
    		if(c0 == c1){
    			count++;
    		}
    	}
    	//�������ƶ�
    	prox =(count / (double)s0.length()) * 100;
    	
    	return prox;
    	
    }

    public static void main(String[] args) {
        MD5 getMD5 = new MD5();
        
        //��ʼ���ַ���
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
        
        //���MD5���ܺ���ַ���
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
        
        //��ȡMD5���ܺ���ַ���
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
        
        //������ƶ�
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
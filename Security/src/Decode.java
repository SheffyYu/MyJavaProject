/**
 * File Name��password.java
 * Description:�������ģ����Ի�ȡ����
 *  @author Sheffy
 * @date 2016��9��24��
 */
import java.util.*;

/**
 *Class Name: Method
 *Description:ʹ����ٷ���ȡ���� 
 * @author Sheffy
 * @date 2016��9��24�� {time}
 *Problems:
 */
class Method{
	String ciphertext = "CHOAZSZWIMZASVILLZYBNLLTZNMWIATHZGILDMZDNLOAROIILYMPOCGNMZSIASUADNYTHZIUTSTNADOAGPZRFIRMN"
                      + "ACZHZSOASPORZDMNAYWHIWNTCHZDTHZGNMZTIAZVZRGOVZUPNADKZZPFOGHTOAG"
                      + "CINCHLNAGPOAGHNSBZCIMZTHZFORSTTIWOAVILLZYBNLLGILDBITHNSNCINCHNADPLNYZR"
                      + "BNCKOALISNAGZLZSILYMPOCSSHZNADHZRTZNMMNTZSHZLPZDCHOANSCIIPTHZORFORSTILYMPOCSGILDSOACZTHZACHOAZSZWIMZASVILLZYBNLLTZNMHNSBZZASZZANSNFLNGBZNRZRNMIAGNLLCHOAZSZSPIRTSTZNMSFIROTSTZANCOTYNADFOGHTOAGSPOROT";

	/**
	 *��������countFreq()
	 *���ܣ�ͳ��ÿ����ĸ���ֵ�Ƶ��
	 *���ã���
	 *�����ã�Class Decode main
	 *�޸ļ�¼��2016/9/29  ����ע��
	 */
	public void countFreq(){
		//��ʼ��count����
		int[] count = new int[26];
		for(int i=0;i<26;i++){
			count[i]=0;
		}
		
		//ͳ��ciphertext�ַ�������ĸƵ��
		for(int i = 0;i < ciphertext.length(); i++){
			char c = ciphertext.charAt(i);
			//A��ASCII��Ϊ65
			int temp = 0;
			temp = (int)c-65;
		    count[temp] = count[temp]+1;	
		}
		//���26����ĸƵ�ʵ�ͳ�ƽ��
		for(int i=0;i<26;i++){
		  System.out.println(count[i]);
		}
		
	}
	

	/**
	 *��������changePassW
	 *���ܣ���ĸ����,��a��b����
	 *���ã�
	 *�����ã�decode
	 *�޸ļ�¼��
	 */
	public void changePassW(char a,char b){
		//��a�滻��&
		String newString = null;
		for(int i = 0;i < ciphertext.length();i++){
			char c = ciphertext.charAt(i);
			if(c == a){
				newString = ciphertext.replace(c, '&');
			}
		}
		
		//��b�滻��a
		for(int i = 0;i < ciphertext.length();i++){
			char c = ciphertext.charAt(i);
			if(c == b){
				newString = newString.replace(c, a);
			}
		}
		
		//�ٽ�&�滻��b
		for(int i = 0;i < ciphertext.length();i++){
			char c = ciphertext.charAt(i);
			if(c == a){
				//��ԭ�ַ�������
				ciphertext = newString.replace('&', b);
			}
		}
	}
	
	/**
	 *��������decode
	 *���ܣ���� A<->N,Z<->E,I<->O
	 *���ã�changePassW
	 *�����ã�Decode main
	 *�޸ļ�¼��
	 */
	public void decode() {
		//A<->N
		changePassW('A', 'N');

		//Z<->E
		changePassW('Z', 'E');

		//I<->O
		changePassW('I', 'O');
		
		System.out.print(ciphertext);
	}
	
}

/**
 *Class Name: Decode
 *Description: ����
 * @author Sheffy
 * @date 2016��9��29�� {time}
 *Problems:
 */
public class Decode{
	public static void main(String[] args){
		Method method = new Method();
		method.countFreq();
		method.decode();
	}
}
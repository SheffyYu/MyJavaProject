/**
 * File Name：password.java
 * Description:给出密文，尝试获取明文
 *  @author Sheffy
 * @date 2016年9月24日
 */
import java.util.*;

/**
 *Class Name: Method
 *Description:使用穷举法获取明文 
 * @author Sheffy
 * @date 2016年9月24日 {time}
 *Problems:
 */
class Method{
	String ciphertext = "CHOAZSZWIMZASVILLZYBNLLTZNMWIATHZGILDMZDNLOAROIILYMPOCGNMZSIASUADNYTHZIUTSTNADOAGPZRFIRMN"
                      + "ACZHZSOASPORZDMNAYWHIWNTCHZDTHZGNMZTIAZVZRGOVZUPNADKZZPFOGHTOAG"
                      + "CINCHLNAGPOAGHNSBZCIMZTHZFORSTTIWOAVILLZYBNLLGILDBITHNSNCINCHNADPLNYZR"
                      + "BNCKOALISNAGZLZSILYMPOCSSHZNADHZRTZNMMNTZSHZLPZDCHOANSCIIPTHZORFORSTILYMPOCSGILDSOACZTHZACHOAZSZWIMZASVILLZYBNLLTZNMHNSBZZASZZANSNFLNGBZNRZRNMIAGNLLCHOAZSZSPIRTSTZNMSFIROTSTZANCOTYNADFOGHTOAGSPOROT";

	/**
	 *函数名：countFreq()
	 *功能：统计每个字母出现的频率
	 *调用：无
	 *被调用：Class Decode main
	 *修改记录：2016/9/29  完善注释
	 */
	public void countFreq(){
		//初始化count数组
		int[] count = new int[26];
		for(int i=0;i<26;i++){
			count[i]=0;
		}
		
		//统计ciphertext字符串的字母频率
		for(int i = 0;i < ciphertext.length(); i++){
			char c = ciphertext.charAt(i);
			//A的ASCII码为65
			int temp = 0;
			temp = (int)c-65;
		    count[temp] = count[temp]+1;	
		}
		//输出26个字母频率的统计结果
		for(int i=0;i<26;i++){
		  System.out.println(count[i]);
		}
		
	}
	

	/**
	 *函数名：changePassW
	 *功能：字母代换,将a与b交换
	 *调用：
	 *被调用：decode
	 *修改记录：
	 */
	public void changePassW(char a,char b){
		//将a替换成&
		String newString = null;
		for(int i = 0;i < ciphertext.length();i++){
			char c = ciphertext.charAt(i);
			if(c == a){
				newString = ciphertext.replace(c, '&');
			}
		}
		
		//将b替换成a
		for(int i = 0;i < ciphertext.length();i++){
			char c = ciphertext.charAt(i);
			if(c == b){
				newString = newString.replace(c, a);
			}
		}
		
		//再将&替换成b
		for(int i = 0;i < ciphertext.length();i++){
			char c = ciphertext.charAt(i);
			if(c == a){
				//将原字符串更新
				ciphertext = newString.replace('&', b);
			}
		}
	}
	
	/**
	 *函数名：decode
	 *功能：完成 A<->N,Z<->E,I<->O
	 *调用：changePassW
	 *被调用：Decode main
	 *修改记录：
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
 *Description: 解码
 * @author Sheffy
 * @date 2016年9月29日 {time}
 *Problems:
 */
public class Decode{
	public static void main(String[] args){
		Method method = new Method();
		method.countFreq();
		method.decode();
	}
}
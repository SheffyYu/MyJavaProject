import java.util.regex.*;
public class abstractDemo{
	public static void main(String[] args){
		String text1="<html><body><a href='http://www.baidu.com'>�ٶ�</a>,<a href='http://www.163.com' target='_bank'>����</a></body></html>";
		//����html�ж�Ӧ�������ַ���
		Pattern pattern=Pattern.compile("href=\'(.+?)\'");
		Matcher matcher=pattern.matcher(text1);
		while(matcher.find()){
			System.out.println(matcher.group(1).replaceAll("href=|>",""));
		}
	}
}

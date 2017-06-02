import java.util.regex.*;
public class abstractDemo{
	public static void main(String[] args){
		String text1="<html><body><a href='http://www.baidu.com'>百度</a>,<a href='http://www.163.com' target='_bank'>网易</a></body></html>";
		//查找html中对应条件的字符串
		Pattern pattern=Pattern.compile("href=\'(.+?)\'");
		Matcher matcher=pattern.matcher(text1);
		while(matcher.find()){
			System.out.println(matcher.group(1).replaceAll("href=|>",""));
		}
	}
}

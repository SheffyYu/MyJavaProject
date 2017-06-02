//输出管理员类
class Conservator{
String name;
String password;

//输入赋值
void init(String newName,String newPw){
name=newName;
password=newPw;
}

//输出管理员类
void show(){                                                     
System.out.println("用户名："+name+",密码："+password);
}
} 

public class ConserDemo{
public static void main(String[] args){
Conservator myConser1= new Conservator();
Conservator myConser2= new Conservator();

myConser1.init("admin1","111111");
myConser1.show();

myConser2.init("admin2","222222");
myConser2.show();
}
}
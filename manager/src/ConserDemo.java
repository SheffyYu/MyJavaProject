//�������Ա��
class Conservator{
String name;
String password;

//���븳ֵ
void init(String newName,String newPw){
name=newName;
password=newPw;
}

//�������Ա��
void show(){                                                     
System.out.println("�û�����"+name+",���룺"+password);
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
import java.util.*;

 class Area{
	private double area;
	private double length;
	private double width;
	private double radius;
	Scanner scan=new Scanner(System.in);
	
	void menu(){
		System.out.println("��������ͼ�ε������");
		System.out.println("1��������");
		System.out.println("2��Բ��");
		System.out.println("3��������");
		System.out.printf("��ѡ��");
	}
	
	//���㳤���ε����
	void oblongArea(){
	area=length*width;
	System.out.println("�ó����ε����Ϊ��"+area);
	}
	
	//����Բ�ε����
	void circularArea(){
	area=3.14*radius*radius;
	System.out.println("��Բ�ε����Ϊ��"+area);
	}
//���������ε����
void deltaArea(){
area=length*width/2;
System.out.println("�������ε����Ϊ��"+area);
}
//���볤���ε���Ϣ
void initOb(){
System.out.println("�����볤���ε���ϸ��Ϣ");
System.out.printf("��Ϊ��");
Scanner scan1=new Scanner(System.in);
length=scan1.nextDouble();
System.out.printf("��Ϊ��");
Scanner scan2=new Scanner(System.in);
width=scan2.nextDouble();
}

//����Բ����Ϣ
void initCir(){
System.out.println("������Բ����ϸ��Ϣ");
System.out.printf("�뾶Ϊ��");
//scan = new Scanner(System.in);
 radius=scan.nextDouble();
}

//���������ε���Ϣ
void initDel(){
System.out.println("�����������ε���ϸ��Ϣ");
System.out.printf("��Ϊ��");
Scanner scan1=new Scanner(System.in);
length=scan1.nextDouble();
System.out.printf("��Ϊ��");
Scanner scan2=new Scanner(System.in);
width=scan2.nextDouble();
}
}


public class areaDemo{
public static void main(String args[]){
Area getArea= new Area();
getArea. menu();
Scanner scan=new Scanner(System.in);
int num=scan.nextInt();
switch(num){
case 1:
getArea.initOb();
getArea.oblongArea();
break;
case 2:
getArea.initCir();
getArea.circularArea();
break;
case 3:
getArea.initDel();
getArea.deltaArea();
break;
}
}
}
//����������Ľ�����ѭ��������˵���ֱ������ĳһ
//�ض����ַ�������ֹͣ


















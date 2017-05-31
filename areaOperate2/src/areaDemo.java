import java.util.*;

 class Area{
	private double area;
	private double length;
	private double width;
	private double radius;
	Scanner scan=new Scanner(System.in);
	
	void menu(){
		System.out.println("计算下列图形的面积：");
		System.out.println("1、长方形");
		System.out.println("2、圆形");
		System.out.println("3、三角形");
		System.out.printf("请选择：");
	}
	
	//计算长方形的面积
	void oblongArea(){
	area=length*width;
	System.out.println("该长方形的面积为："+area);
	}
	
	//计算圆形的面积
	void circularArea(){
	area=3.14*radius*radius;
	System.out.println("该圆形的面积为："+area);
	}
//计算三角形的面积
void deltaArea(){
area=length*width/2;
System.out.println("该三角形的面积为："+area);
}
//输入长方形的信息
void initOb(){
System.out.println("请输入长方形的详细信息");
System.out.printf("长为：");
Scanner scan1=new Scanner(System.in);
length=scan1.nextDouble();
System.out.printf("宽为：");
Scanner scan2=new Scanner(System.in);
width=scan2.nextDouble();
}

//输入圆的信息
void initCir(){
System.out.println("请输入圆的详细信息");
System.out.printf("半径为：");
//scan = new Scanner(System.in);
 radius=scan.nextDouble();
}

//输入三角形的信息
void initDel(){
System.out.println("请输入三角形的详细信息");
System.out.printf("底为：");
Scanner scan1=new Scanner(System.in);
length=scan1.nextDouble();
System.out.printf("高为：");
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
//本程序仍需改进，如循环输出主菜单，直到键入某一
//特定的字符串将其停止


















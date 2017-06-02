/**
 *Tile: SchoolRoll
 *Description: 学籍管理系统 
 * @author Sheffy
 * @date 2017年3月31日 {time}
 *Problems:
 */
package management_of_school_roll;

import java.util.Scanner;

/**
 *Class Name: SchoolRoll
 *Description: 
 * @author Sheffy
 * @date 2017年3月31日 {time}
 */
public class SchoolRoll {
	public static void main(String args[]){
		int num = 0;
		String str="";
		Scanner scan = new Scanner(System.in);
		
		while(num != 9999){
			if(num > 5){
				System.out.print("输入错误！请重新输入：");
				num = scan.nextInt();
			}
			else{
				//学籍管理系统界面
				System.out.println("---------------学籍信息管理系统---------------");
				System.out.println("1、添加学生信息");
				System.out.println("2、删除学生信息");
				System.out.println("3、修改学生信息");
				System.out.println("4、查询学生信息");
				System.out.println("5、打印学生列表");
				System.out.println("0、退出");
				System.out.print("请输入操作：");
				
				//获取操作
				num = scan.nextInt();
				
				//五个功能
				switch(num){
				case 0:                //退出
					System.exit(0);         
					break;
				case 1:                //添加学生信息
					
					break;
				case 2:                //删除学生信息
					
					break;
				case 3:                //修改学生信息
					
					break;
				case 4:                //查询学生信息
					
					break;
				case 5:                //打印学生列表
					
					break;
				}
			}
		}
		
		
		
	}
}


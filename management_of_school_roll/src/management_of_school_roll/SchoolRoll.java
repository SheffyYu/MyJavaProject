/**
 *Tile: SchoolRoll
 *Description: ѧ������ϵͳ 
 * @author Sheffy
 * @date 2017��3��31�� {time}
 *Problems:
 */
package management_of_school_roll;

import java.util.Scanner;

/**
 *Class Name: SchoolRoll
 *Description: 
 * @author Sheffy
 * @date 2017��3��31�� {time}
 */
public class SchoolRoll {
	public static void main(String args[]){
		int num = 0;
		String str="";
		Scanner scan = new Scanner(System.in);
		
		while(num != 9999){
			if(num > 5){
				System.out.print("����������������룺");
				num = scan.nextInt();
			}
			else{
				//ѧ������ϵͳ����
				System.out.println("---------------ѧ����Ϣ����ϵͳ---------------");
				System.out.println("1�����ѧ����Ϣ");
				System.out.println("2��ɾ��ѧ����Ϣ");
				System.out.println("3���޸�ѧ����Ϣ");
				System.out.println("4����ѯѧ����Ϣ");
				System.out.println("5����ӡѧ���б�");
				System.out.println("0���˳�");
				System.out.print("�����������");
				
				//��ȡ����
				num = scan.nextInt();
				
				//�������
				switch(num){
				case 0:                //�˳�
					System.exit(0);         
					break;
				case 1:                //���ѧ����Ϣ
					
					break;
				case 2:                //ɾ��ѧ����Ϣ
					
					break;
				case 3:                //�޸�ѧ����Ϣ
					
					break;
				case 4:                //��ѯѧ����Ϣ
					
					break;
				case 5:                //��ӡѧ���б�
					
					break;
				}
			}
		}
		
		
		
	}
}


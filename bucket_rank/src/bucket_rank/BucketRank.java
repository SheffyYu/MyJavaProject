/**
 *Tile: BucketRank
 *Description: ����һ���ǳ���������㷨��
 *             Ͱ�����1956��Ϳ�ʼ��ʹ�ã�
 *             ���㷨�Ļ���˼������E.J.Issac  R.C.Singleton�������
 *             ��ʵ�Ⲣ����������Ͱ�����㷨
 * @author Sheffy
 * @date 2017��3��15�� {time}
 *Problems:
 */
package bucket_rank;

import java.util.Scanner;

/**
 *Class Name: BucketRank1
 *Description: ����Ͱ�����Ͱ����
 * @author Sheffy
 * @date 2017��3��15�� {time}
 *Problems:�������ظ�����ֵ--�ѽ������ʹ��ʱ�临�Ӷ�����
 */
class BucketRank1{
	Scanner scanner=new Scanner(System.in);
	/**
	 * @param n
	 * @param max
	 */
	public BucketRank1(int n,int max){
		//max+1��ԭ���ǽ�0���������У���0����max
		int arr[];
		arr=new int[max+1];
		
		//��ʼ������
		for(int i=0;i<=max;i++){
			arr[i]=0;
		}
		
		//��������
		System.out.println("������һ�����ݣ�");
		for(int j=0;j<n;j++){
			arr[scanner.nextInt()]++;
		}
		
		//����
		//��С������
		System.out.println("��С�����ţ�");
		for(int k=0;k<=max;k++){
			if(arr[k]!=0){
				for(int m=0;m<arr[k];m++){
					System.out.print(k+"   ");
				}
			}
		}
		
		System.out.print("\n");
		//�Ӵ�С��
		System.out.println("�Ӵ�С�ţ�");
		for(int k=max;k>=0;k--){
			if(arr[k]!=0){
				for(int m=0;m<arr[k];m++){
					System.out.print(k+"   ");
				}
			}
		}
	}
}

/**
 *Class Name: BucketRank
 *Description: �����򵥵������㷨--Ͱ����1��
 * @author Sheffy
 * @date 2017��3��15�� {time}
 */
public class BucketRank {
	
	public static Scanner scanner;
	public static BucketRank1 bk;
	
	public static void main(String arg[]){
		//nΪ�������ĸ���
		int n=0;
		//maxΪ����������������ӽ�������ķ�Χ
		int max=0;
		scanner=new Scanner(System.in);
		
		//�������ֵĸ���
		System.out.print("�������ֵĸ�����");
		n=scanner.nextInt();
		System.out.print("\n");
		
		//������������ߴ��� �ķ�Χ
		System.out.print("��������������ߴ��µķ�Χ��");
		max=scanner.nextInt();
		System.out.print("\n");
		
		//����Ͱ����
		bk=new BucketRank1(n, max);
	}
}

/**
 * Ͱ�����ʱ�临�Ӷ�ΪO(m+n)
 * 
 */

/**
 *Tile: SelectionRank
 *Description: ����һ��N������Ҫȷ�����е�k������ߣ���֮Ϊѡ������
 * @author Sheffy
 * @date 2017��3��16�� {time}
 *Problems:
 */
package selection_rank;

import java.util.Scanner;

import javax.print.attribute.standard.MediaSize.Other;
import javax.swing.JInternalFrame;

/**
 *Class Name: SelectionRank
 *Description: ð���������һ���㷨
 * @author Sheffy
 * @date 2017��3��16�� {time}
 */
public class SelectionRank {
	
	public static Scanner scanner;
	
	/**
	 *��������Bubble
	 *���ܣ�ð������
	 *���ã�
	 *�����ã�
	 *�޸ļ�¼��
	 * @param k n
	 * @return arr[k-1]
	 */
	public int Bubble(int k,int n){
		int temp=0;
		int arr[];
		arr=new int[n];
		
		for(int i=0;i<n;i++){
			arr[i]=scanner.nextInt();
		}
		
		for(int j=n-1;j>0;j--){
			for(int m=0;m<j;m++){
				if(arr[m]<arr[m+1]){
					temp=arr[m];
					arr[m]=arr[m+1];
					arr[m+1]=temp;
				}
			}
		}
		
		return arr[k-1];
	}
	
	/**
	 *��������OtherRank
	 *���ܣ����㷨���Ƚ�ǰk��Ԫ�ض������鲢���Եݼ���˳�򣩶����������
	 *   ��ʣ�µ�Ԫ����������룬����Ԫ���ڱ�����ʱ�������С�������� �ĵ�k��Ԫ�أ������֮��
	 *   ����ͽ��������ȷ��λ���ϣ�ͬʱ��������е�һ��Ԫ�ؼ������飬���㷨��ֹʱ��λ�ڵ�k��λ���ϵ�Ԫ����Ϊ�𰸷���
	 *���ã�
	 *�����ã�
	 *�޸ļ�¼������˳�����ͬ���ֵ�����
	 * @param k n
	 * @return arr[k-1]
	 */
	public int OtherRank(int k,int n){
		int num=0;
		int temp=0;
		int arr[];
		arr=new int[k];
		scanner=new Scanner(System.in);
		
		//����k�������������������,�������ð������
		for(int i=0;i<k;i++){
			arr[i]=scanner.nextInt();
		}
		
		for(int j=k-1;j>0;j--){
			for(int m=0;m<j;m++){
				if(arr[m]<arr[m+1]){
					temp=arr[m];
					arr[m]=arr[m+1];
					arr[m+1]=temp;
				}
			}
		}
		
		//�������Ԫ��
		for(int i=k;i<n;i++){
			num=scanner.nextInt();
			
			//�����С�������� �ĵ�k��Ԫ�أ������֮��
			//����ͽ��������ȷ��λ���ϣ�ͬʱ��������е�һ��Ԫ�ؼ�������
			if(num>arr[k-1]){
				//����ȵ�һ��������ֱ�ӽ�������
				if(num>arr[0]){
					for(int m=k-1;m>0;m--){
						arr[m]=arr[m-1];
					}
					arr[0]=num;
				}
				//���򣬲�������
				else{
					for(int j=k-1;j>0;j--){
						if((num >= arr[j]) && (num <= arr[j-1])){
							for(int m=k-1;m>j;m--){
								arr[m]=arr[m-1];
							}
							arr[j]=num;
							break;
						}//if
					}//for
				}//else
			}//if
		}//for

		return arr[k-1];
	}
	
	
public static void main(String arg[]){
	SelectionRank sr=new SelectionRank();
		int k=0;
		int n=0;
		scanner=new Scanner(System.in);
		
		System.out.print("���м�������");
		n=scanner.nextInt();
		
		System.out.print("Ҫȷ���ĵڼ�������ߣ�");
		k=scanner.nextInt();
		
		System.out.println("�������ݣ�");
		
		//System.out.println(sr.OtherRank(k,n));
		System.out.println(sr.Bubble(k, n));
	}
}


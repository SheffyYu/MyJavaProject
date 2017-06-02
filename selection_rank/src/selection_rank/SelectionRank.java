/**
 *Tile: SelectionRank
 *Description: 设有一组N个数而要确定其中第k个最大者，称之为选择问题
 * @author Sheffy
 * @date 2017年3月16日 {time}
 *Problems:
 */
package selection_rank;

import java.util.Scanner;

import javax.print.attribute.standard.MediaSize.Other;
import javax.swing.JInternalFrame;

/**
 *Class Name: SelectionRank
 *Description: 冒泡排序和另一个算法
 * @author Sheffy
 * @date 2017年3月16日 {time}
 */
public class SelectionRank {
	
	public static Scanner scanner;
	
	/**
	 *函数名：Bubble
	 *功能：冒泡排序
	 *调用：
	 *被调用：
	 *修改记录：
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
	 *函数名：OtherRank
	 *功能：此算法是先将前k个元素读入数组并（以递减的顺序）对其进行排序，
	 *   将剩下的元素再逐个读入，当新元素在被读到时，如果它小于数组中 的第k个元素，则忽略之，
	 *   否则就将其放在正确的位置上，同时将数组的中的一个元素挤出数组，当算法终止时，位于第k个位置上的元素作为答案返回
	 *调用：
	 *被调用：
	 *修改记录：解决了出现相同数字的问题
	 * @param k n
	 * @return arr[k-1]
	 */
	public int OtherRank(int k,int n){
		int num=0;
		int temp=0;
		int arr[];
		arr=new int[k];
		scanner=new Scanner(System.in);
		
		//读入k个数，并对其进行排序,这里采用冒泡排序
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
		
		//逐个输入元素
		for(int i=k;i<n;i++){
			num=scanner.nextInt();
			
			//如果它小于数组中 的第k个元素，则忽略之，
			//否则就将其放在正确的位置上，同时将数组的中的一个元素挤出数组
			if(num>arr[k-1]){
				//如果比第一个数大，则直接进行排序
				if(num>arr[0]){
					for(int m=k-1;m>0;m--){
						arr[m]=arr[m-1];
					}
					arr[0]=num;
				}
				//否则，插入排序
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
		
		System.out.print("共有几个数？");
		n=scanner.nextInt();
		
		System.out.print("要确定的第几个最大者？");
		k=scanner.nextInt();
		
		System.out.println("输入数据：");
		
		//System.out.println(sr.OtherRank(k,n));
		System.out.println(sr.Bubble(k, n));
	}
}


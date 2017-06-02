/**
 *Tile: BucketRank
 *Description: 这是一个非常快的排序算法。
 *             桶排序从1956年就开始被使用，
 *             该算法的基本思想是由E.J.Issac  R.C.Singleton提出来。
 *             其实这并不是真正的桶排序算法
 * @author Sheffy
 * @date 2017年3月15日 {time}
 *Problems:
 */
package bucket_rank;

import java.util.Scanner;

/**
 *Class Name: BucketRank1
 *Description: 不是桶排序的桶排序
 * @author Sheffy
 * @date 2017年3月15日 {time}
 *Problems:忽略了重复的数值--已解决，但使得时间复杂度增加
 */
class BucketRank1{
	Scanner scanner=new Scanner(System.in);
	/**
	 * @param n
	 * @param max
	 */
	public BucketRank1(int n,int max){
		//max+1的原因是将0算入排序中，即0——max
		int arr[];
		arr=new int[max+1];
		
		//初始化数组
		for(int i=0;i<=max;i++){
			arr[i]=0;
		}
		
		//输入数据
		System.out.println("请输入一组数据：");
		for(int j=0;j<n;j++){
			arr[scanner.nextInt()]++;
		}
		
		//排序
		//从小到大排
		System.out.println("从小到大排：");
		for(int k=0;k<=max;k++){
			if(arr[k]!=0){
				for(int m=0;m<arr[k];m++){
					System.out.print(k+"   ");
				}
			}
		}
		
		System.out.print("\n");
		//从大到小排
		System.out.println("从大到小排：");
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
 *Description: 最快最简单的排序算法--桶排序（1）
 * @author Sheffy
 * @date 2017年3月15日 {time}
 */
public class BucketRank {
	
	public static Scanner scanner;
	public static BucketRank1 bk;
	
	public static void main(String arg[]){
		//n为输入数的个数
		int n=0;
		//max为输入的最大数或者最接近最大数的范围
		int max=0;
		scanner=new Scanner(System.in);
		
		//输入数字的个数
		System.out.print("输入数字的个数：");
		n=scanner.nextInt();
		System.out.print("\n");
		
		//输入最大数或者大致 的范围
		System.out.print("请输入最大数或者大致的范围：");
		max=scanner.nextInt();
		System.out.print("\n");
		
		//进行桶排序
		bk=new BucketRank1(n, max);
	}
}

/**
 * 桶排序的时间复杂度为O(m+n)
 * 
 */

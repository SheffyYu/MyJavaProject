/**
 *Tile: Subsequence
 *Description: 最大子序列和问题，采用四种方法求解
 * @author Sheffy
 * @date 2017年3月26日 {time}
 *Problems:经过运行，发现分治法使用的时间比其他三种方法要长很多，但理论上分治法的时间复杂度比穷举法要小很多
 */
package sequence;

import java.util.Scanner;

import org.omg.CORBA.PUBLIC_MEMBER;


/**
 *Class Name: Subsequence
 *Description: 最大子序列和问题，采用四种方法求解
 * @author Sheffy
 * @date 2017年3月26日 {time}
 */
public class Subsequence {
	
	/**
	 *函数名：maxSubSum1
	 *功能：使用原始的穷举法求最大子序列和问题
	 *调用：
	 *被调用：main
	 *修改记录：
	 * @param a
	 * @return
	 */
	public static int maxSubSum1(int[] a){
		int maxSum=0;
		
		for(int i=0;i<a.length;i++){
			//计算每个与i相关的子序列 i,i+(i+1),...i+...+a.length
			for(int j=i;j<a.length;j++){
				int thisSum=0;
				//计算i+...j
				for(int k=i;k<=j;k++){
					thisSum+=a[k];
				}//for
				//更新最大值
				if(thisSum>maxSum){
					maxSum=thisSum;
				}//if
			}//for
		}//for
		
		return maxSum;
	}
	
	/** 
	 *函数名：maxSubSum2
	 *功能：使用改进的穷举法计算最大子序列和，减少了重复计算前几个数 
	 *调用：
	 *被调用：main
	 *修改记录：
	 * @param a
	 * @return
	 */
	public static int maxSubSum2(int[] a){
		int maxSum=0;
		
		for(int i=0;i<a.length;i++){
			//减少了重复计算
			int thisSum=0;
			for(int j=i;j<a.length;j++){
				
				thisSum+=a[j];
				
				//更新最大值
				if(thisSum>maxSum){
					maxSum=thisSum;
				}//if
			}//for
		}//for
		
		return maxSum;
	}
	
	/**
	 *函数名：maxSubSum3
	 *功能：分治法求最大子序列和
	 *调用：maxSumRec
	 *被调用：main
	 *修改记录：
	 * @param a
	 * @return
	 */
	public static int  maxSubSum3(int[] a) {
		return maxSumRec(a, 0, a.length-1);
	}
	
	/**
	 *函数名：maxSumRec
	 *功能：采用“分治法”求最大子序列和问题，在左，右两个部分中，分别找到其中的最大值，然后计算中部的最大值，比较，得到最大子序列和
	 *调用：max3
	 *被调用：maxSubSum3
	 *修改记录：
	 * @param a
	 * @return
	 */
	public static int maxSumRec(int[] a,int left,int right) {
		
		//基准情况
		//只有一个数的时候
		if(left==right){
			if(a[left]>0){
				return a[left];
			}
	        else {       //负数的最大子序列和为0
			    return 0;
	        }
		}
		
		//中间位置
		int center=(left+right)/2;
		//左边最大
		int maxLeftSum=maxSumRec(a, left, center);
		//右边最大
		int maxRightSum=maxSumRec(a, center+1, right);
		
		//求中间部分的最大值
		//求左边部分加上最后一个元素的最大值
		int maxLeftBorderSum=0;
		int leftBorderSum=0;
		for(int i=center;i>=left;i--){
			leftBorderSum+=a[i];
			if(leftBorderSum>maxLeftBorderSum){
				maxLeftBorderSum=leftBorderSum;
			}//if
		}//for
		
		//求右边部分加上最左边的元素的最大值
		int maxRightBorderSum=0;
		int rightBorderSum=0;
		for(int j=center+1;j<=right;j++){
			rightBorderSum+=a[j];
			if(rightBorderSum>maxRightBorderSum){
				maxRightBorderSum=rightBorderSum;
			}//if
		}//for
		
		return max3(maxLeftSum, maxLeftSum, maxRightBorderSum+maxLeftBorderSum);
	}
	
	/**
	 *函数名：max3
	 *功能：比较三个数，求三个数的最大值
	 *调用：
	 *被调用：maxSumRec
	 *修改记录：
	 * @param left
	 * @param center
	 * @param right
	 * @return
	 */
	public static int max3(int left,int center,int right){
		int max=left;
		if(max<center){
			max=center;
		}
		if(max<right){
			max=right;
		}
			
		return max;
	}
	
	/**
	 *函数名：maxSubSum4
	 *功能：简单而有效的求最大子序列和算法,这种算法属于联机算法
	 *调用：
	 *被调用：main
	 *修改记录：
	 * @param a
	 * @return
	 */
	public static int maxSubSum4(int[] a){
		int maxSum=0;
		int thisSum=0;
		
		for(int i=0;i<a.length;i++){
			
			thisSum+=a[i];
			//更新最大值
			if(thisSum>maxSum)
				maxSum=thisSum;
			//如果所有和相加小于0，那么这个子序列只会使子序列和变小，因此置0
			else if(thisSum<0)
				thisSum=0;
		}
		
		return maxSum;
	}
	
	public static void main(String arg[]) {
		int a[];
		int n=0;
		
		System.out.print("请输入数组长度：");
		Scanner scanner=new Scanner(System.in);
		n=scanner.nextInt();
		a=new int[n];
		
		System.out.println("请输入序列：");
		//初始化数组
		for(int i=0;i<n;i++){
			a[i]=scanner.nextInt();
		}
		
		//打印结果
		System.out.println(maxSubSum1(a));
		System.out.println(maxSubSum2(a));
		System.out.println(maxSubSum3(a));
		System.out.println(maxSubSum4(a));
		
		//比较运行的时间
		double startTime1 = System.currentTimeMillis();
		int result;
		for(int i=0;i<1000;i++){
			result=maxSubSum1(a);
		}
		double endTime1 = System.currentTimeMillis();
		double time1 = (endTime1 - startTime1);
		System.out.println(time1);
		
		double startTime2 = System.currentTimeMillis();
		int result2;
		for(int i=0;i<1000;i++){
			result2=maxSubSum2(a);
		}
		double endTime2 = System.currentTimeMillis();
		double time2 = (endTime2 - startTime2);
		System.out.println(time2);
		
		double startTime3 = System.currentTimeMillis();
		int result3;
		for(int i=0;i<1000;i++){
			result3=maxSumRec(a, 0, a.length-1);
		}
		double endTime3 = System.currentTimeMillis();
		double time3 = (endTime3 - startTime3);
		System.out.println(time3);
		
		double startTime4 = System.currentTimeMillis();
		int result4;
		for(int i=0;i<1000;i++){
			result4=maxSubSum4(a);
		}
		double endTime4 = System.currentTimeMillis();
		double time4 = (endTime4 - startTime4);
		System.out.println(time4);
		
	}
	
}


/**
 *Tile: Subsequence
 *Description: ��������к����⣬�������ַ������
 * @author Sheffy
 * @date 2017��3��26�� {time}
 *Problems:�������У����ַ��η�ʹ�õ�ʱ����������ַ���Ҫ���ܶ࣬�������Ϸ��η���ʱ�临�Ӷȱ���ٷ�ҪС�ܶ�
 */
package sequence;

import java.util.Scanner;

import org.omg.CORBA.PUBLIC_MEMBER;


/**
 *Class Name: Subsequence
 *Description: ��������к����⣬�������ַ������
 * @author Sheffy
 * @date 2017��3��26�� {time}
 */
public class Subsequence {
	
	/**
	 *��������maxSubSum1
	 *���ܣ�ʹ��ԭʼ����ٷ�����������к�����
	 *���ã�
	 *�����ã�main
	 *�޸ļ�¼��
	 * @param a
	 * @return
	 */
	public static int maxSubSum1(int[] a){
		int maxSum=0;
		
		for(int i=0;i<a.length;i++){
			//����ÿ����i��ص������� i,i+(i+1),...i+...+a.length
			for(int j=i;j<a.length;j++){
				int thisSum=0;
				//����i+...j
				for(int k=i;k<=j;k++){
					thisSum+=a[k];
				}//for
				//�������ֵ
				if(thisSum>maxSum){
					maxSum=thisSum;
				}//if
			}//for
		}//for
		
		return maxSum;
	}
	
	/** 
	 *��������maxSubSum2
	 *���ܣ�ʹ�øĽ�����ٷ�������������кͣ��������ظ�����ǰ������ 
	 *���ã�
	 *�����ã�main
	 *�޸ļ�¼��
	 * @param a
	 * @return
	 */
	public static int maxSubSum2(int[] a){
		int maxSum=0;
		
		for(int i=0;i<a.length;i++){
			//�������ظ�����
			int thisSum=0;
			for(int j=i;j<a.length;j++){
				
				thisSum+=a[j];
				
				//�������ֵ
				if(thisSum>maxSum){
					maxSum=thisSum;
				}//if
			}//for
		}//for
		
		return maxSum;
	}
	
	/**
	 *��������maxSubSum3
	 *���ܣ����η�����������к�
	 *���ã�maxSumRec
	 *�����ã�main
	 *�޸ļ�¼��
	 * @param a
	 * @return
	 */
	public static int  maxSubSum3(int[] a) {
		return maxSumRec(a, 0, a.length-1);
	}
	
	/**
	 *��������maxSumRec
	 *���ܣ����á����η�������������к����⣬���������������У��ֱ��ҵ����е����ֵ��Ȼ������в������ֵ���Ƚϣ��õ���������к�
	 *���ã�max3
	 *�����ã�maxSubSum3
	 *�޸ļ�¼��
	 * @param a
	 * @return
	 */
	public static int maxSumRec(int[] a,int left,int right) {
		
		//��׼���
		//ֻ��һ������ʱ��
		if(left==right){
			if(a[left]>0){
				return a[left];
			}
	        else {       //��������������к�Ϊ0
			    return 0;
	        }
		}
		
		//�м�λ��
		int center=(left+right)/2;
		//������
		int maxLeftSum=maxSumRec(a, left, center);
		//�ұ����
		int maxRightSum=maxSumRec(a, center+1, right);
		
		//���м䲿�ֵ����ֵ
		//����߲��ּ������һ��Ԫ�ص����ֵ
		int maxLeftBorderSum=0;
		int leftBorderSum=0;
		for(int i=center;i>=left;i--){
			leftBorderSum+=a[i];
			if(leftBorderSum>maxLeftBorderSum){
				maxLeftBorderSum=leftBorderSum;
			}//if
		}//for
		
		//���ұ߲��ּ�������ߵ�Ԫ�ص����ֵ
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
	 *��������max3
	 *���ܣ��Ƚ����������������������ֵ
	 *���ã�
	 *�����ã�maxSumRec
	 *�޸ļ�¼��
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
	 *��������maxSubSum4
	 *���ܣ��򵥶���Ч������������к��㷨,�����㷨���������㷨
	 *���ã�
	 *�����ã�main
	 *�޸ļ�¼��
	 * @param a
	 * @return
	 */
	public static int maxSubSum4(int[] a){
		int maxSum=0;
		int thisSum=0;
		
		for(int i=0;i<a.length;i++){
			
			thisSum+=a[i];
			//�������ֵ
			if(thisSum>maxSum)
				maxSum=thisSum;
			//������к����С��0����ô���������ֻ��ʹ�����кͱ�С�������0
			else if(thisSum<0)
				thisSum=0;
		}
		
		return maxSum;
	}
	
	public static void main(String arg[]) {
		int a[];
		int n=0;
		
		System.out.print("���������鳤�ȣ�");
		Scanner scanner=new Scanner(System.in);
		n=scanner.nextInt();
		a=new int[n];
		
		System.out.println("���������У�");
		//��ʼ������
		for(int i=0;i<n;i++){
			a[i]=scanner.nextInt();
		}
		
		//��ӡ���
		System.out.println(maxSubSum1(a));
		System.out.println(maxSubSum2(a));
		System.out.println(maxSubSum3(a));
		System.out.println(maxSubSum4(a));
		
		//�Ƚ����е�ʱ��
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


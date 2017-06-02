import java.util.*;
import java.math.*;
/**
 *Class Name: RSA
 *Description: ʵ��RSA�㷨�ļ��������
 * @author Sheffy
 * @date 2016��10��23�� {time}
 *Problems:1��������ģ�������
 *         2��
 *�޸ļ�¼��2016.10.23--�������޸�Ϊ����̨����         
 *       2016.10.25--���󲿷ֺ����޸�Ϊ�ɶ������õ�ģ��
 */
public class RSA{
	//n=p*q
	//bΪ��Կ,dΪ˽Կ
	//mΪ����
	//cΪ����
	//p,qΪ��������ȵ�������n=p*q
	private long n;
	private long b,d;
//	private long m;
//	private long c;
	private long p,q;
	private long x,y;
	private int count;
	
	//��Կ(n,b)= (4294967297, 7)
	RSA(){
		n = Long.parseLong("4294967297");
		b = 7;
		p = 1;
		q = 1;
	}
	
	/**
	 *��������getB
	 *���ܣ���ȡ��Կb
	 *���ã�
	 *�����ã�
	 *�޸ļ�¼��
	 * @return
	 */
	public long getB(){
		return b;
	}
	
	/**
	 *��������getM
	 *���ܣ���ȡ����
	 *���ã���
	 *�����ã�
	 *�޸ļ�¼��
	 */
	public long setM(){
		System.out.println("Please input m:");
		Scanner scan = new Scanner(System.in);
		long m = scan.nextLong();
		return m;
		
	}
	
	/**
	 *��������encrypt
	 *���ܣ�ʵ�ּ���
	 *���ã�
	 *�����ã�main
	 *�޸ļ�¼����ȡ����
	 */
	public long encrypt(long b,long m){
		double c0 = powerC(m, b);
		long c = (long)c0;
		//System.out.print("����Ϊ��");
		//System.out.println(c);
		return c;
	}
	
	/**
	 *��������decipher
	 *���ܣ�ʵ�ֽ���
	 *���ã�getD
	 *�����ã�main
	 *�޸ļ�¼����ȡ����
	 */
	public long decipher(long D,long C){
	   D = getD();
//	    long result = 1;  
//        while (d > 0) {  
//            if ((d & 1) == 1){
//            	 long temp = result;
//            	 result = (result * c) % n; 
//            	if(result == 0){
//            		result = temp;
//            		break;
//            	}
//            }
//
//           // System.out.println(result);
//            c = (c * c) % n;  
//            d >>= 1;  
//        }  
	   long m;
        m = powerC(C, D);
      //  System.out.print("���ܺ������Ϊ��");
	   // System.out.println(m);
	    return m;
	}
	
	/**
	 *��������powerC
	 *���ܣ�������ģ����c^d mod n
	 *���ã�
	 *�����ã�
	 *�޸ļ�¼��
	 * @param C
	 * @param D
	 * @return
	 */
	public long powerC(long C,long D){
		 long result = 1;  
	        while (D> 0) {  
	            if ((D & 1) == 1){
	            	 long temp = result;
	            	 result = (result * C) % n; 
	            }

	          //  System.out.println(result);
	            C = (C * C) % n;  
	            D >>= 1;  
	        }  
			return result;
	}
	
	/**
	 *��������getD
	 *���ܣ���ȡ˽Կd
	 *���ã�getFiN  linearEquation
	 *�����ã�decipher
	 *�޸ļ�¼��2016.10.23    ��˽Կ����
	 */
	public long getD(){
		long fiN = getFiN();
		linearEquation(b, fiN);
//		System.out.print("x = ");
//		System.out.println(x);
//		System.out.print("y = ");
//		System.out.println(y);
		d = x;
		return d;
	}
	
	/**
	 *��������exgcd
	 *���ܣ���չŷ����õݹ��㷨
	 *���ã�exgcd
	 *�����ã�
	 *�޸ļ�¼��
	 * @param a
	 * @param b
	 * @return
	 */
	public long exgcd(long a,long b){
		if(b == 0){
			x = 1;
			y = 0;
			return a;
		}
		long r = exgcd(b, a % b);
		long t = x;
		x = y;
		y = t - a / b * y;
		return r;
	}
	
	/**
	 *��������linearEquation
	 *���ܣ�����չŷ������㷨�ⲻ������ ax+by=c
	 *���ã�exgcd
	 *�����ã�getD
	 *�޸ļ�¼��
	 * @param a
	 * @param b
	 * @return
	 */
	public boolean linearEquation(long a,long b){
		long gcd = exgcd(a, b);
		if( 1 % gcd != 0){
			return false;
		}
		long k = 1 / gcd;
		x *= k;
		y *= k;

		return true;
		
	}
	
	/**
	 *��������getFiN
	 *���ܣ�����Fi(n)
	 *���ã�
	 *�����ã�getD
	 *�޸ļ�¼��
	 * @return
	 */
	public long getFiN(){
		solvePQ();
		long fiN;
		fiN = (p - 1) * (q - 1);
//		System.out.print("fiN = ");
//		System.out.println(fiN);
		return fiN;
	}
	
	/**
	 *��������solvePQ
	 *���ܣ���ȡ����������� ������
	 *���ã�getPrime getMaxOdd
	 *�����ã�main
	 *�޸ļ�¼��
	 */
	public void solvePQ(){
		long[] prime = isPrime();
		
		for(int i = 0;i < count;i++){
			for(int j = 0;j < count;j++){
				if(isN(prime[i], prime[j])){
					p = prime[i];
					q = prime[j];
				}
			}
		}
		
//			System.out.println(p);
//			System.out.println(q);
		
	}
	
	/**
	 *��������isPrime
	 *���ܣ��ж��Ƿ�Ϊ����,������n����������prime��
	 *���ã�
	 *�����ã�solvePQ
	 *�޸ļ�¼��
	 */
	public long[] isPrime(){
		long num = n;
	    count = 0;
		//�������
		long[] prime = new long[225];
		
		//�ֽ�������
		for(int i = 2;i <= num;i++){
			if(num % i == 0){
				prime[count] = i;
//				System.out.println(i);
				count ++;
				num /= i;
				i--;
			}//if
		}//for	
		return prime;
	}
	
	/**
	 *��������isN
	 *���ܣ��ж�x*y�Ƿ����n
	 *���ã�
	 *�����ã�solvePQ
	 *�޸ļ�¼��
	 * @param x
	 * @param y
	 * @return 
	 */
	public boolean isN(long x,long y){
		if(x * y == n)
			return true;
		else {
			return false;
		}
	}
	
}//class RSA
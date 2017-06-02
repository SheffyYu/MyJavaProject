import java.util.*;
import java.math.*;
/**
 *Class Name: RSA
 *Description: ʵ��RSA�㷨�ļ��������
 * @author Sheffy
 * @date 2016��10��14�� {time}
 *Problems:1��������ģ�������
 *�޸ļ�¼��2016.10.23--�������޸�Ϊ����̨����         
 */
public class RSA{
	//n=p*q
	//bΪ��Կ,dΪ˽Կ
	//m1��m2Ϊ����
	//c1,c2Ϊ����
	//p,qΪ��������ȵ�������n=p*q
	private long n;
	private long b,d;
	private long m1,m2;
	private long c1,c2;
	private long p,q;
	private long x,y;
	private int count;
	
	//��Կ(n,b)= (4294967297, 7)
	RSA(){
		n = 4294967297l;
		b = 7;
		p = 1;
		q = 1;
		m1 = 12;
		c2 = 2;
	}

	/**
	 *��������setM1
	 *���ܣ���������
	 *���ã�
	 *�����ã�
	 *�޸ļ�¼��
	 * @param m
	 */
	public void setM1(long m){
		m1 = m;
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
	 *��������encrypt
	 *���ܣ�ʵ�ּ���
	 *���ã�
	 *�����ã�main
	 *�޸ļ�¼��
	 */
	public void encrypt(){
		c1 = pcmodn(m1, b);
		
		System.out.print("����Ϊ��");
		System.out.println(c1);
	}
	
	/**
	 *��������decipher
	 *���ܣ�ʵ�ֽ���
	 *���ã�getD
	 *�����ã�main
	 *�޸ļ�¼��
	 */
	public void decipher(){
	    d = getD(); 
	  //  System.out.println(d);
        m2 = pcmodn(c2, d);

        System.out.print("���ܺ������Ϊ��");
	    System.out.println(m2);
	}
	
	/**
	 *��������powerC
	 *���ܣ�������ģ����
	 *���ã�
	 *�����ã�
	 *�޸ļ�¼��
	 * @param C
	 * @param D
	 * @return
	 */
	public long pcmodn(long c,long d){
		long result = 1;  
        while (d > 0) {  
            if ((d & 1) == 1){
            	result = (long)((result % n) * (c % n)) % n; 
            	 System.out.println(result);
            	// result %= n;
            }
            c = (c * c) % n;  
            d >>= 1;  
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
		System.out.print("x = ");
		System.out.println(x);
		System.out.print("y = ");
		System.out.println(y);
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
		long fiN;
		fiN = (p - 1) * (q - 1);
		System.out.print("fiN = ");
		System.out.println(fiN);
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
		
			System.out.println(p);
			System.out.println(q);
		
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
	
	
	public static void main(String args[]){
		RSA rsa = new RSA();

		double startTime1 = System.currentTimeMillis();
		for(int i = 0;i < 100;i++){
			rsa.encrypt();
		}
		double endTime1 = System.currentTimeMillis();
		double time1 = (endTime1 - startTime1);

		double startTime2 = System.currentTimeMillis();
		rsa.solvePQ();
		rsa.decipher();
		double endTime2 = System.currentTimeMillis();
		double time2 = (endTime2 - startTime2);
		
		System.out.println("����ʹ�õ�ʱ��Ϊ��" + time1 + "����");
		System.out.println("����ʹ�õ�ʱ��Ϊ��" + time2 + "����");
		System.out.print("���ܣ����� = " + (time2 * 100) / time1);
	}
	
}//class RSA
import java.util.*;
import java.math.*;
/**
 *Class Name: RSA
 *Description: 实现RSA算法的加密与解密
 * @author Sheffy
 * @date 2016年10月14日 {time}
 *Problems:1、大数幂模运算溢出
 *修改记录：2016.10.23--将明文修改为控制台输入         
 */
public class RSA{
	//n=p*q
	//b为公钥,d为私钥
	//m1，m2为明文
	//c1,c2为密文
	//p,q为两个不相等的质数，n=p*q
	private long n;
	private long b,d;
	private long m1,m2;
	private long c1,c2;
	private long p,q;
	private long x,y;
	private int count;
	
	//公钥(n,b)= (4294967297, 7)
	RSA(){
		n = 4294967297l;
		b = 7;
		p = 1;
		q = 1;
		m1 = 12;
		c2 = 2;
	}

	/**
	 *函数名：setM1
	 *功能：输入明文
	 *调用：
	 *被调用：
	 *修改记录：
	 * @param m
	 */
	public void setM1(long m){
		m1 = m;
	}
	
	/**
	 *函数名：getB
	 *功能：获取公钥b
	 *调用：
	 *被调用：
	 *修改记录：
	 * @return
	 */
	public long getB(){
		return b;
	}
	
	/**
	 *函数名：encrypt
	 *功能：实现加密
	 *调用：
	 *被调用：main
	 *修改记录：
	 */
	public void encrypt(){
		c1 = pcmodn(m1, b);
		
		System.out.print("密文为：");
		System.out.println(c1);
	}
	
	/**
	 *函数名：decipher
	 *功能：实现解密
	 *调用：getD
	 *被调用：main
	 *修改记录：
	 */
	public void decipher(){
	    d = getD(); 
	  //  System.out.println(d);
        m2 = pcmodn(c2, d);

        System.out.print("解密后的明文为：");
	    System.out.println(m2);
	}
	
	/**
	 *函数名：powerC
	 *功能：大数幂模运算
	 *调用：
	 *被调用：
	 *修改记录：
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
	 *函数名：getD
	 *功能：获取私钥d
	 *调用：getFiN  linearEquation
	 *被调用：decipher
	 *修改记录：2016.10.23    将私钥返回
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
	 *函数名：exgcd
	 *功能：扩展欧几里得递归算法
	 *调用：exgcd
	 *被调用：
	 *修改记录：
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
	 *函数名：linearEquation
	 *功能：用扩展欧几里得算法解不定方程 ax+by=c
	 *调用：exgcd
	 *被调用：getD
	 *修改记录：
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
	 *函数名：getFiN
	 *功能：计算Fi(n)
	 *调用：
	 *被调用：getD
	 *修改记录：
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
	 *函数名：solvePQ
	 *功能：获取两个互不相等 的质数
	 *调用：getPrime getMaxOdd
	 *被调用：main
	 *修改记录：
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
	 *函数名：isPrime
	 *功能：判断是否为质数,将所有n的质数存在prime中
	 *调用：
	 *被调用：solvePQ
	 *修改记录：
	 */
	public long[] isPrime(){
		long num = n;
	    count = 0;
		//存放质数
		long[] prime = new long[225];
		
		//分解质因子
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
	 *函数名：isN
	 *功能：判断x*y是否等于n
	 *调用：
	 *被调用：solvePQ
	 *修改记录：
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
		
		System.out.println("加密使用的时间为：" + time1 + "毫秒");
		System.out.println("解密使用的时间为：" + time2 + "毫秒");
		System.out.print("解密：加密 = " + (time2 * 100) / time1);
	}
	
}//class RSA
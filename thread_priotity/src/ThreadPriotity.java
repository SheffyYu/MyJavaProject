import java.lang.*;
import java.util.*;

/**
 *Class Name: ThreadPriotity
 *Description: 线程练习之线程优先级
 * @author Sheffy
 * @date 2017年3月6日 {time}
 *Problems:为什么main thread 始终都是最后才进行 的？
 */
public class ThreadPriotity{
	public static void main(String args[])throws Exception{
		Runnable1 runnable1=new Runnable1();
		Runnable2 runnable2=new Runnable2();
		Runnable3 runnable3=new Runnable3();
		
		Thread t1=new Thread(runnable1);
		Thread t2=new Thread(runnable2);
		Thread t3=new Thread(runnable3);
		
		t1.setPriority(Thread.NORM_PRIORITY+2);
		t2.setPriority(Thread.NORM_PRIORITY-2);
		
		t1.start();
		t2.start();
		t3.start();
		
		t1.sleep(1000);
		t2.sleep(1000);
		t3.sleep(2000);
		
		for(int i=0;i<10;i++){
			System.out.println("main thread:"+i);
		}
		
		System.out.println("t1的优先级为："+t1.getPriority());
	}
}

/**
 *Class Name: Runnable1
 *Description: 
 * @author Sheffy
 * @date 2017年3月6日 {time}
 *Problems:
 */
class Runnable1 implements Runnable{
	public void run() {
		for(int i=0;i<10;i++){
			System.out.println("thread 1:"+i);
		}
	}
}

/**
 *Class Name: Runnable2
 *Description: 
 * @author Sheffy
 * @date 2017年3月6日 {time}
 *Problems:
 */
class Runnable2 implements Runnable{
	public void run() {
		for(int i=0;i<10;i++){
			System.out.println("thread 2:"+i);
		}
	}
}

/**
 *Class Name: Runnable3
 *Description: 
 * @author Sheffy
 * @date 2017年3月6日 {time}
 *Problems:
 */
class Runnable3 implements Runnable{
	public void run() {
		for(int i=0;i<10;i++){
			System.out.println("thread 3:"+i);
		}
	}
}
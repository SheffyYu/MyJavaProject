import java.lang.*;

public class thread{
    public static void main(String args[]){
        Runner1 r1 = new Runner1();//这里new了一个线程类的对象出来
        //r1.run();//这个称为方法调用，方法调用的执行是等run()方法执行完之后才会继续执行main()方法
        Thread t = new Thread(r1);//要启动一个新的线程就必须new一个Thread对象出来
        //这里使用的是Thread(Runnable target) 这构造方法
        t.start();//启动新开辟的线程，新线程执行的是run()方法，新线程与主线程会一起并行执行
        for(int i=0;i<10;i++){
            System.out.println("maintheod："+i);
        }
    }
}
/*定义一个类用来实现Runnable接口，实现Runnable接口就表示这个类是一个线程类*/
class Runner1 implements Runnable{
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println("Runner1："+i);
        }
    }
}
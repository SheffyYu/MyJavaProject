import java.lang.*;

public class thread{
    public static void main(String args[]){
        Runner1 r1 = new Runner1();//����new��һ���߳���Ķ������
        //r1.run();//�����Ϊ�������ã��������õ�ִ���ǵ�run()����ִ����֮��Ż����ִ��main()����
        Thread t = new Thread(r1);//Ҫ����һ���µ��߳̾ͱ���newһ��Thread�������
        //����ʹ�õ���Thread(Runnable target) �⹹�췽��
        t.start();//�����¿��ٵ��̣߳����߳�ִ�е���run()���������߳������̻߳�һ����ִ��
        for(int i=0;i<10;i++){
            System.out.println("maintheod��"+i);
        }
    }
}
/*����һ��������ʵ��Runnable�ӿڣ�ʵ��Runnable�ӿھͱ�ʾ�������һ���߳���*/
class Runner1 implements Runnable{
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println("Runner1��"+i);
        }
    }
}
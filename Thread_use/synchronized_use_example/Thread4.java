package Thread_use.synchronized_use_example;

/**
 * Created by Administrator on 2015/12/21.
 *  �ġ�����������ͬ����������ͬ������顣Ҳ����˵����һ���̷߳���object��һ��synchronized(this)ͬ�������ʱ��
 *  ���ͻ�������object�Ķ�������
 *  ����������̶߳Ը�object��������ͬ�����벿�ֵķ��ʶ�����ʱ������
 **/
public class Thread4{

    public synchronized void m4t1() {
        int i = 5;
        while (i-- > 0) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {}
        }
    }

    public synchronized void m4t2() {
        int i = 5;
        while (i-- > 0) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {}
        }
    }

    public static void main(String[] args) {

        Thread4 myt4 = new Thread4();

        Thread t1 = new Thread() {
            public void run() {
                myt4.m4t1();
            }
        };t1.setName("t1");

        Thread t2 = new Thread(  new Runnable() {
            public void run() {
                myt4.m4t2();
            }
        },"t2");

        t1.start();
        t2.start();
    }
}

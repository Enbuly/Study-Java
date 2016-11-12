package Thread_use.synchronized_use_example;

/**
 * Created by Administrator on 2015/12/21.
 * ��������ؼ����ǣ���һ���̷߳���object��һ��synchronized(this)ͬ�������ʱ��
 * �����̶߳�object����������synchronized(this)ͬ�������ķ��ʽ���������
 */
public class Thread3{

    public void m4t1(){
        synchronized(this) {
            int i = 5;
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {}
            }
        }
    }

    public void m4t2() {
        synchronized(this) {
            int i = 5;
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {}
            }
        }
    }

    public static void main(String[] args) {

        Thread3 myt3 = new Thread3();

        Thread t1 = new Thread(){
            public void run() {
                myt3.m4t1();
            }
        };t1.setName("t1");

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                myt3.m4t2();
            }
        },"t2");

        t1.start();
        t2.start();
    }
}

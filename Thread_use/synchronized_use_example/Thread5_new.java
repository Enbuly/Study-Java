package Thread_use.synchronized_use_example;

/**
 * Created by Administrator on 2015/12/21.
 * �����߳�t1��t2������ͬһ��Inner����������������صĲ���,����Ϊt1�Ȼ���˶�Inner�Ķ�������
 * ����t2��Inner.m4t2()�ķ���Ҳ����������Ϊm4t2()��Inner�е�һ��ͬ��������
 */
public class Thread5_new {
    class Inner {
        private void m4t1() {
            int i = 5;
            while(i-- > 0) {
                System.out.println(Thread.currentThread().getName() + " : Inner.m4t1()=" + i);
                try {
                    Thread.sleep(500);
                } catch(InterruptedException ie) {
                    //do something;
                }
            }
        }
        private synchronized void m4t2() {
            int i = 5;
            while(i-- > 0) {
                System.out.println(Thread.currentThread().getName() + " : Inner.m4t2()=" + i);
                try {
                    Thread.sleep(500);
                } catch(InterruptedException ie) {
                    //do something;
                }
            }
        }
    }

    private void m4t1(Inner inner) {
        //ʹ�ö���������ö������������߳�ֻ��ִ���������ķ�synchronized������������ö��������߳����ɽ���ִ��
        synchronized (inner){
            inner.m4t1();
        }
    }

    private void m4t2(Inner inner) {
        inner.m4t2();
    }

    public static void main(String[] args) {

        Thread5_new myt5 = new Thread5_new();
        Inner inner = myt5.new Inner();

        Thread t1 = new Thread( new Runnable() {
            public void run() {
                myt5.m4t1(inner);
            }
        },"t1");

        Thread t2 = new Thread( new Runnable() {
            public void run() {
                myt5.m4t2(inner);
            }
        },"t2");

        t1.start();
        t2.start();
    }
}

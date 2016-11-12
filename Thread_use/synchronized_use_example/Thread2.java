package Thread_use.synchronized_use_example;
/**
 Created by Administrator on 2015/12/21.
 �ڶ����ࡣsynchronizedΪJava���ԵĹؼ��֣�������������һ����������һ��������ʱ��
 �ܹ���֤��ͬһʱ�����ֻ��һ���߳�ִ�иöδ��롣
 ����Ȼ������һ���̷߳���object��һ��synchronized(this)ͬ�������ʱ��
 ��һ���߳���Ȼ���Է��ʸ�object�еķ�synchronized(this)ͬ������顣**/
public class Thread2{

    public void m4t1(){
        synchronized (this){
            int i=5;
            while(i-->0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
                try{
                    Thread.sleep(1000);//sleep��ռ��CPU˯��
                }catch(InterruptedException ie) {
                    //do something
                }
            }
        }
    }

    public void m4t2(){
        int i=5;
        while(i-->0){
            System.out.println(Thread.currentThread().getName() + ":" + i);
            try{
                Thread.sleep(1000);
            } catch(InterruptedException ie){
                //do something
            }
        }
    }

    public static void main(String[] args){

        Thread2 zzy = new Thread2();

        Thread t1 = new Thread() {
            public void run() {
                zzy.m4t1();
            }
        };t1.setName("T1");

        Thread t3 = new Thread() {
            public void run() {
                zzy.m4t1();
            }
        };t3.setName("T3");

        Thread t2 = new Thread(  new Runnable() {
            public void run() {
                zzy.m4t2();
            }
        },"T2");

//        Thread t4=new Thread(new Runnable() {
//            @Override
//            public void run() {
//                zzy.m4t2();
//            }
//        });t4.setName("T4");
        Thread t4=new Thread(){
            public void run() {
                zzy.m4t2();
            }
        };t4.setName("T4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

package Thread_use.synchronized_use_example;
/**
 Created by Administrator on 2015/12/21.
 ��һ���ࡣsynchronizedΪJava���ԵĹؼ��֣�������������һ����������һ��������ʱ��
 �ܹ���֤��ͬһʱ�����ֻ��һ���߳�ִ�иöδ��롣
 һ�������������̷߳���ͬһ������object�е����synchronized(this)ͬ�������ʱ��
 һ��ʱ����ֻ����һ���̵߳õ�ִ�С���һ���̱߳���ȴ���ǰ�߳�ִ�������������Ժ����ִ�иô���顣
**/
public class Thread1 implements Runnable {
    public void run(){
        synchronized(this){
            for(int i=0;i<15;i++){
                System.out.println(Thread.currentThread().getName() + " synchronized loop " + i);
            }
        }
    }
    public static void main(String[]args){
        Thread1 t1=new Thread1();
        Thread ta=new Thread(t1);
        ta.setName("A");
        Thread tb=new Thread(t1,"B");
        ta.start();
        tb.start();
    }
}

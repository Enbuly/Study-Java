package Thread_use.ReentrantLock;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 Created by Administrator on 2016/1/29.
 lockInterruptibly()�����Ƚ����⣬��ͨ���������ȥ��ȡ��ʱ��
 ����߳����ڵȴ���ȡ����������߳��ܹ���Ӧ�жϣ����ж��̵߳ĵȴ�״̬��
 Ҳ��ʹ˵���������߳�ͬʱͨ��lock.lockInterruptibly()���ȡĳ����ʱ��
 ������ʱ�߳�A��ȡ�����������߳�Bֻ���ڵȴ���
 ��ô���߳�B����threadB.interrupt()�����ܹ��ж��߳�B�ĵȴ����̡�
--------------------------------------------------------------------------
 ����lockInterruptibly()���������׳����쳣��
 ����lock.lockInterruptibly()�������try���л����ڵ���lockInterruptibly()�ķ����������׳�InterruptedException��
 */
public class Test3 {
    private Lock lock = new ReentrantLock();

    public void insert() throws InterruptedException{
        //ע�⣬�����Ҫ��ȷ�жϵȴ������̣߳����뽫��ȡ���������棬Ȼ��InterruptedException�׳�
        lock.lockInterruptibly();
        try {
            System.out.println(Thread.currentThread().getName() + " get the lock");
            Thread.sleep(8000);
        }
        finally {
            System.out.println(Thread.currentThread().getName()+" execute finally");
            lock.unlock();
            System.out.println(Thread.currentThread().getName()+" unlock the lock.");
        }
    }

    public static void main(String[] args){
        Test3 test = new Test3();
        Thread thread1=new Thread(){
            public void run(){
                try {
                    test.insert();
                }catch (Exception e){System.out.println(Thread.currentThread().getName()+" be break");}
            }
        };thread1.setName("first");

        Thread thread2=new Thread(){
            public void run(){
                try {
                    test.insert();
                    //thread2.interrupt();֮��ͻ�catch���쳣
                }catch (Exception e){System.out.println(Thread.currentThread().getName()+" be break");}
            }
        };thread2.setName("second");

        thread1.setPriority(Thread.NORM_PRIORITY);//����Ȩ,��ֵ�����ִ��
        thread2.setPriority(Thread.MIN_PRIORITY);
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        thread1.start();
        thread2.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.interrupt();
        //ע�⣬��һ���̻߳�ȡ����֮���ǲ��ᱻinterrupt()�����жϵġ�
        //��Ϊ������ǰ��������н�����������interrupt()���������ж��������й����е��̣߳�ֻ���ж����������е��̡߳�
        //��˵�ͨ��lockInterruptibly()������ȡĳ����ʱ��
        //������ܻ�ȡ����ֻ�н��еȴ�������£��ǿ�����Ӧ�жϵġ�
        //����synchronized���εĻ�����һ���̴߳��ڵȴ�ĳ������״̬��
        //���޷����жϵģ�ֻ��һֱ�ȴ���ȥ
    }
}
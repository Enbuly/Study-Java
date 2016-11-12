package Thread_use.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 ** Created by Administrator on 2016/2/1.
 ** ReentrantReadWriteLock �������������ģ���Ҫѧ����ܲ��������Լ�
 */
public class ReentrantReadWriteLock_example {

    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    public void get(){
        //rwl.readLock().lock();
        //ע����finally����رտ�������ע������
        rwl.writeLock().lock();
        try {//make something
            long start=System.currentTimeMillis();

            while(System.currentTimeMillis()-start<=20) {
                System.out.println(Thread.currentThread().getName()+"���ڽ��ж�����");
            }
            System.out.println(Thread.currentThread().getName()+"���������");
        }catch (Exception e){
            System.out.print(e.getMessage());
        }
        finally {
            //rwl.readLock().unlock();
            rwl.writeLock().unlock();
        }
    }

    public static void main(String[] args)  {
        ReentrantReadWriteLock_example test=new ReentrantReadWriteLock_example();

        new Thread(){
            public void run() {
                test.get();
            }
        }.start();

        new Thread(){
            public void run() {
                test.get();
            }
        }.start();

    }
}

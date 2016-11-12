package Thread_use.ReentrantLock;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2016/1/29.
 * ������ǰ�潲���������Lock����������ȥ�ͷ����������ڷ����쳣ʱ��
 * �����Զ��ͷ��������һ����˵��ʹ��Lock������try{}catch{}���н��У�
 * ���ҽ��ͷ����Ĳ�������finally���н��У��Ա�֤��һ�������ͷţ���ֹ�����ķ�����
 * reentrant  ���������
 **/
public class Test1{
    private List<Integer> arrayList=new ArrayList<>();
    private Lock lock = new ReentrantLock();

    public void insert(){
        //lock()������ƽ��ʹ�õ�����һ������������������ȡ����������ѱ������̻߳�ȡ������еȴ���
        lock.lock();
        try {//make something
            System.out.println(Thread.currentThread().getName()+" get the Lock");
            for(int i=0;i<5;i++) {
                arrayList.add(i);
            }
            System.out.print(arrayList);
        }catch(Exception e){
            //catch the error
        }finally{
            lock.unlock();
            System.out.println(Thread.currentThread().getName()+" unlock the lock");
        }
    }

    public static void main(String[] args){
        Test1 test = new Test1();

        new Thread(){
            public void run() {
                test.insert();
            }
        }.start();

        new Thread(){
            public void run(){
                test.insert();
            }
        }.start();
    }
}
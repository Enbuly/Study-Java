package Thread_use.ReentrantLock;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 Created by Administrator on 2016/1/29.
 tryLock()�������з���ֵ�ģ�����ʾ�������Ի�ȡ����
 �����ȡ�ɹ����򷵻�true�������ȡʧ�ܣ������ѱ������̻߳�ȡ����
 �򷵻�false��Ҳ��˵�������������ζ����������ء����ò�����ʱ����һֱ���ǵȴ���

 tryLock(long time, TimeUnit unit)������tryLock()���������Ƶģ�
 ֻ����������������������ò�����ʱ��ȴ�һ����ʱ�䣬��ʱ������֮��������ò�������
 �ͷ���false��������һ��ʼ�õ��������ڵȴ��ڼ����õ��������򷵻�true��
 */
public class Test2 {
    private List<Integer> arrayList = new ArrayList<>();
    private Lock lock = new ReentrantLock();

    public void insert() throws InterruptedException{
        if(lock.tryLock(3,TimeUnit.SECONDS)){//tryLock args is long timeout,TimeUnit unit
            //tryLock throw a Exception is InterruptedException
            try {//make something
                System.out.println(Thread.currentThread().getName()+" get the Lock");
                for(int i=0;i<5;i++){
                    arrayList.add(i);
                }
                System.out.println(arrayList);
                Thread.currentThread().sleep(6000);
            } catch (Exception e) {
                //catch the error
            }finally {
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + " unlock the lock");
            }
        }else {
            System.out.println(Thread.currentThread().getName()+" fail to get the Lock");
        }
    }

    public static void main(String[] args){
        Test2 test = new Test2();

        new Thread(){
            public void run(){
                try {
                    test.insert();
                }catch (Exception e){}
            }
        }.start();

        new Thread(){
            public void run() {
                try {
                    test.insert();
                }catch (Exception e){}
            }
        }.start();
    }

}
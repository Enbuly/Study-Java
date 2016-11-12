package Thread_use.New_Produce_Consumer.await_signal;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by john on 2016/10/14.
 * a new Storage
 */
public class Storage {
    private final int MAX_SIZE = 100;// �ֿ����洢��

    private LinkedList<Object> list = new LinkedList<>();// �ֿ�洢������

    private final Lock lock = new ReentrantLock();

    private final Condition full = lock.newCondition();// �ֿ�������������

    private final Condition empty = lock.newCondition();// �ֿ�յ���������

    public void produce(int num) {// ����num����Ʒ
        lock.lock();// �����
        while (list.size() + num > MAX_SIZE) {// ����ֿ�ʣ����������
            System.out.println("Ҫ�����Ĳ�Ʒ����:" + num + "/t�����:" + list.size()
                    + "/t��ʱ����ִ����������!");
            try {
                full.await();// �������������㣬��������
            } catch (InterruptedException e) {e.printStackTrace();}
        }
        for (int i = 1; i <= num; ++i) {// ����������������£�����num����Ʒ
            list.add(new Object());
        }
        System.out.println("�Ѿ�������Ʒ��:" + num + "/t�ֲִ���Ϊ:" + list.size());
        empty.signalAll();// �������������߳�
        full.signalAll();// �������������߳�
        lock.unlock();// �ͷ���
    }


    public void consume(int num) {// ����num����Ʒ
        lock.lock();// �����
        while (list.size() < num) {// ����ֿ�洢������
            System.out.println("Ҫ���ѵĲ�Ʒ����:" + num + "/t�����:" + list.size()
                    + "/t��ʱ����ִ����������!");
            try {
                empty.await();// �������������㣬��������
            } catch (InterruptedException e) {e.printStackTrace();}
        }
        for (int i = 1; i <= num; ++i) {// ����������������£�����num����Ʒ
            list.remove();
        }
        System.out.println("�Ѿ����Ѳ�Ʒ��:" + num + "/t�ֲִ���Ϊ:" + list.size());
        full.signalAll();// �������������߳�
        empty.signalAll();// �������������߳�
        lock.unlock();
    }
    // set/get����
    public LinkedList<Object> getList()
    {
        return list;
    }
    public void setList(LinkedList<Object> list)
    {
        this.list = list;
    }
}

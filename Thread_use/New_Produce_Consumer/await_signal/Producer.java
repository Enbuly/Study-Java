package Thread_use.New_Produce_Consumer.await_signal;

/**
 * Created by john on 2016/10/14.
 * produce
 */
public class Producer extends Thread{

    private int num;// ÿ�������Ĳ�Ʒ����

    private Storage storage;// ���ڷ��õĲֿ�

    public Producer(Storage storage) {// ���캯�������òֿ�
        this.storage = storage;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public void run() { // �߳�run����
        produce(num);
    }

    public void produce(int num) {// ���òֿ�Storage����������
        storage.produce(num);
    }
}

package Thread_use.New_Produce_Consumer.await_signal;

/**
 * Created by john on 2016/10/14.
 * consumer
 */
public class Consumer extends Thread{

    private int num;// ÿ�����ѵĲ�Ʒ����

    private Storage storage;// ���ڷ��õĲֿ�

    public Consumer(Storage storage) {// ���캯�������òֿ�
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

    public void run() {// �߳�run����
        consume(num);
    }

    public void consume(int num) {// ���òֿ�Storage����������
        storage.consume(num);
    }

}

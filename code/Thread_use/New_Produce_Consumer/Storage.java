package Thread_use.New_Produce_Consumer;

import java.util.LinkedList;

/**
 * Created by john on 2016/10/14.
 * produce consumer model
 */
public class Storage {

    private int MAX_SIZE = 100;// �ֿ����洢��

    private LinkedList<Object> list = new LinkedList<>();// �ֿ�洢������

    public void produce(int num) {// ����num����Ʒ
        synchronized (this) {// ͬ�������
            while (list.size() + num > MAX_SIZE) {// ����ֿ�ʣ����������
                System.out.println("Ҫ�����Ĳ�Ʒ����:" + num + "/t�����:"
                        + list.size() + "/t��ʱ����ִ����������!");
                try {
                    wait();// �������������㣬��������
                } catch (InterruptedException e) {e.printStackTrace();}
            }
            for (int i = 1; i <= num; ++i) {// ����������������£�����num����Ʒ
                list.add(new Object());
            }
            System.out.println("�Ѿ�������Ʒ��:" + num + "/t�ֲִ���Ϊ:" + list.size());
            notifyAll();
        }
    }

    // ����num����Ʒ
    public void consume(int num) {
        synchronized (this){// ͬ�������
            while (list.size() < num) { // ����ֿ�洢������
                System.out.println("Ҫ���ѵĲ�Ʒ����:" + num + "/t�����:"
                        + list.size() + "/t��ʱ����ִ����������!");
                try {
                    wait();// �������������㣬��������
                } catch (InterruptedException e){e.printStackTrace();}
            }
            for (int i = 1; i <= num; ++i){ // ����������������£�����num����Ʒ
                list.remove();
            }
            System.out.println("�Ѿ����Ѳ�Ʒ��:" + num + "/t�ֲִ���Ϊ:" + list.size());
            notifyAll();
        }
    }

    public LinkedList<Object> getList() {
        return list;
    }

    public void setList(LinkedList<Object> list) {
        this.list = list;
    }
}

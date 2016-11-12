package Thread_use.ThreadLocal;

/**
 * Created by Administrator on 2016/4/3.
 * �ڽ���get֮ǰ��������set������ᱨ��ָ���쳣��
 * �������get֮ǰ����Ҫ����set�����������ʵĻ���������дinitialValue()������
 */
public class Test2 {
    ThreadLocal<Long> longLocal = new ThreadLocal<Long>(){
        protected Long initialValue() {
            return Thread.currentThread().getId();
        }
    };

    ThreadLocal<String> stringLocal = new ThreadLocal<String>(){
        protected String initialValue() {
            return Thread.currentThread().getName();
        }
    };

    public void set() {
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public long getLong() {
        return longLocal.get();
    }

    public String getString() {
        return stringLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {
        final Test2 test = new Test2();

        //test.set();
        System.out.println(test.getLong());
        System.out.println(test.getString());

        Thread thread1 = new Thread(){
            public void run() {
                //test.set();
                System.out.println(test.getLong());
                System.out.println(test.getString());
            }
        };
        thread1.start();
        thread1.join();

        System.out.println(test.getLong());
        System.out.println(test.getString());
    }
}
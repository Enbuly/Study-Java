package Thread_use.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by john on 2016/10/14.
 * ����Executors�ṩ��д�õ��̳߳�
 */
public class Test_Executor {
    public static void main(String[]args) {
        ExecutorService threadPoll = Executors.newCachedThreadPool();
//        Executors.newCachedThreadPool();//��Ҫʱ�����߳̿����̻߳ᱻ����60��
//        Executors.newFixedThreadPool(5);//�óذ����̶��������̣߳������̻߳�һֱ������
//        Executors.newSingleThreadExecutor();//ֻ��һ���̵߳ĳأ����߳�˳���ִ��ÿһ���ύ������
        for (int i = 0; i < 15; i++) {
            Thread_for_Pool thread_for_pool = new Thread_for_Pool(i);
            threadPoll.execute(thread_for_pool);
        }
        threadPoll.shutdown();
    }
}

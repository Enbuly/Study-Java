package Design_mode.Singleton;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * Created by Administrator on 2016/3/21.
 * @author zzy
 */
public class Singleton2 {
    private static Lock lock=new ReentrantLock();
    private static volatile Singleton2 uniqueInstance;//ע��volatile������
    private Singleton2() {}
    public static Singleton2 getInstance() {
        if(uniqueInstance == null) {
            lock.lock();
            try {
                //DCL�����ķ�ʽ����Ҫ��ô����JMM5�Ժ�����volatile�ؼ��ֺ����ʹ�ã�
                // �����Ѿ����㷺����������Ϊ�䲻�Ǹ�Ч���Ż���ʩ(�޾���ͬ����ִ���ٶȺ������Լ�JVM�����ٶ���)
                if(uniqueInstance == null)
                    uniqueInstance = new Singleton2();
            }catch (Exception e){
                System.out.print(e.getMessage());
            }finally {
                lock.unlock();
            }
        }
        return uniqueInstance;
    }
    public static void main(String[] args) {
        Singleton2 s1 = Singleton2.getInstance();
        Singleton2 s2 = Singleton2.getInstance();
        System.out.println(s1 == s2);
    }

}

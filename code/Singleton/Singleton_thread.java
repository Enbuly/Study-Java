package Design_mode.Singleton;

/**
 * Created by Administrator on 2016/3/20.
 * @author zzy
 */
public class Singleton_thread {
    private Singleton_thread() {}

    private static class SingletonFactory {
        private static Singleton_thread instance = new Singleton_thread();
    }//jvm���Ƴ�SingletonFactory�ĳ�ʼ��������ֱ����ʼʹ�������ʱ�ų�ʼ������������ͨ��һ����̬��ʼ��
    //����ʼ��Singleton_thread����˲���Ҫ����ͬ����

    public static Singleton_thread getInstance() {
        return SingletonFactory.instance;
    }

    public static void main(String[] args) {
        Singleton_thread s1 = Singleton_thread.getInstance();
        Singleton_thread s2 = Singleton_thread.getInstance();
        System.out.println(s1 == s2);
    }

}

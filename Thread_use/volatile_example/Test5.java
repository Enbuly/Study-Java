package Thread_use.volatile_example;

/**
 * Created by Administrator on 2016/2/10.
 * synchronized�����ԭ���ԣ��ɼ��Ժ�������
 */
public class Test5 {
    public int inc = 0;

    public synchronized void increase() {
        inc++;
    }

    public static void main(String[] args) {
        final Test5 test = new Test5();
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<1000;j++)
                        test.increase();
                }
            }.start();
        }

        /**������������
           hile(Thread.activeCount()>1)
            Thread.yield();
         **/
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(test.inc);
    }
}

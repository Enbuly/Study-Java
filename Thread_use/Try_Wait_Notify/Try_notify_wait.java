package Thread_use.Try_Wait_Notify;

/**
 * Created by john on 2016/10/13.
 * try a simple example
 */
public class Try_notify_wait implements Runnable{
    private int i=1;//�������
    public void run(){
        synchronized (this) {
            for (; i < 101; i++) {//��һ�ν����ǲ���һ�����Գ���i����10�������ε����
                System.out.print(Thread.currentThread().getName() + " get " + i);
                if (i % 10 == 0) {
                    System.out.println();
                    try {
                        notifyAll();
                        if (i == 100)
                            break;
                        else {
                            wait();
                        }
                    }catch (Exception e){System.out.print(e.getMessage());}
                }
            }
        }
    }
    public static void main(String[]args){
        Try_notify_wait try_notify_wait=new Try_notify_wait();
        Thread thread=new Thread(try_notify_wait);
        Thread thread1=new Thread(try_notify_wait);
        thread.setName(">>zzy");thread1.setName(">>Gaga");
        thread.start();thread1.start();
    }
}

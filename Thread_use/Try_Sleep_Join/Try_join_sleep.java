package Thread_use.Try_Sleep_Join;

/**
 * Created by john on 2016/10/13.
 * try join and sleep
 */
public class Try_join_sleep implements Runnable{
    private Computer computer;
    Thread student,maker;
    public Try_join_sleep(){
        student=new Thread(this);
        maker=new Thread(this);
    }
    public void run(){
        if (Thread.currentThread()==student){
            System.out.println("the student want buy a computer");
            try {
                maker.join();
                //һ���߳�A������һ���߳�B��join����������ʹ�߳�A
                //��ʱֹͣ���У�ֱ���߳�B��ֹ���������B�߳��Ѿ����н�����
                //��B.join��������κν��������join��������ʵ���߳�֮���ͬ����
            }catch (Exception e){System.out.println(e.getMessage());}
            System.out.println("you buy a "+computer.getName()+" the price is "+computer.getPrice());
        }else if (Thread.currentThread()==maker){
            System.out.println("make a computer,please wait...");
            try {
                Thread.sleep(2000);
            }catch (Exception e){System.out.println(e.getMessage());}
            computer=new Computer();computer.setName("Apple");computer.setPrice(6999);
            System.out.println("success to make,you can buy.");
        }
    }
    public static void main(String[]args){
        Try_join_sleep try_join_sleep=new Try_join_sleep();
        try_join_sleep.student.setPriority(Thread.MAX_PRIORITY);
        try_join_sleep.maker.setPriority(Thread.MIN_PRIORITY);
        try_join_sleep.student.start();
        try_join_sleep.maker.start();
    }

}

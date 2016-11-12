package Thread_use.ThreadPool;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by john on 2016/5/14.
 * a class for a test
 */
public class Test {
    public static void main(String[] args){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(10));
        //executor.setCorePoolSize();��̬�����̳߳ص�CorePoolSize
        //executor.setKeepAliveTime();��̬�����̳߳ص�KeepAliveTime
        //(int corePoolSize,int maximumPoolSize,long keepAliveTime,
        // TimeUnit unit, BlockingQueue<Runnable> workQueue);
        //executor.prestartAllCoreThreads();

        for(int i=0;i<15;i++){
            Thread_for_Pool thread_for_pool=new Thread_for_Pool(i);
            executor.execute(thread_for_pool);
            System.out.println("�̳߳����߳���Ŀ��"+executor.getPoolSize()+"�������еȴ�ִ�е�������Ŀ��"+
            executor.getQueue().size()+"����ִ������������Ŀ��"+executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }
}
/**     ThreadPoolExecutor��Ľ���
 * public class ThreadPoolExecutor extends AbstractExecutorService {
 .....
 public ThreadPoolExecutor(int corePoolSize,int maximumPoolSize,long keepAliveTime,TimeUnit unit,
 BlockingQueue<Runnable> workQueue);

 public ThreadPoolExecutor(int corePoolSize,int maximumPoolSize,long keepAliveTime,TimeUnit unit,
 BlockingQueue<Runnable> workQueue,ThreadFactory threadFactory);

 public ThreadPoolExecutor(int corePoolSize,int maximumPoolSize,long keepAliveTime,TimeUnit unit,
 BlockingQueue<Runnable> workQueue,RejectedExecutionHandler handler);

 public ThreadPoolExecutor(int corePoolSize,int maximumPoolSize,long keepAliveTime,TimeUnit unit,
 BlockingQueue<Runnable> workQueue,ThreadFactory threadFactory,RejectedExecutionHandler handler);
 ...
 }

  corePoolSize�����ĳصĴ�С��������������潲�����̳߳ص�ʵ��ԭ���зǳ���Ĺ�ϵ��
  �ڴ������̳߳غ�Ĭ������£��̳߳��в�û���κ��̣߳����ǵȴ����������Ŵ���,
  �߳�ȥִ�����񣬳��ǵ�����prestartAllCoreThreads()����prestartCoreThread()������
  ����2�����������־Ϳ��Կ�������Ԥ�����̵߳���˼������û��������֮ǰ�ʹ���,
  corePoolSize���̻߳���һ���̡߳�Ĭ������£��ڴ������̳߳غ��̳߳��е��߳���,
  Ϊ0������������֮�󣬾ͻᴴ��һ���߳�ȥִ�����񣬵��̳߳��е��߳���Ŀ�ﵽcorePoolSize��
  �ͻ�ѵ��������ŵ�������е��У�

 maximumPoolSize���̳߳�����߳������������Ҳ��һ���ǳ���Ҫ�Ĳ���������ʾ���̳߳�������ܴ������ٸ��̣߳�

 keepAliveTime����ʾ�߳�û������ִ��ʱ��ౣ�ֶ��ʱ�����ֹ��Ĭ������£�
 ֻ�е��̳߳��е��߳�������corePoolSizeʱ��keepAliveTime�Ż������ã�ֱ���̳߳��е�
 �߳���������corePoolSize�������̳߳��е��߳�������corePoolSizeʱ�����һ���߳̿���
 ��ʱ��ﵽkeepAliveTime�������ֹ��ֱ���̳߳��е��߳���������corePoolSize���������
 ������allowCoreThreadTimeOut(boolean)���������̳߳��е��߳���������corePoolSizeʱ��
 keepAliveTime����Ҳ�������ã�ֱ���̳߳��е��߳���Ϊ0��

 unit������keepAliveTime��ʱ�䵥λ����7��ȡֵ����TimeUnit������7�־�̬���ԣ�
 TimeUnit.DAYS;               //��
 TimeUnit.HOURS;             //Сʱ
 TimeUnit.MINUTES;           //����
 TimeUnit.SECONDS;           //��
 TimeUnit.MILLISECONDS;      //����
 TimeUnit.MICROSECONDS;      //΢��
 TimeUnit.NANOSECONDS;       //����

 workQueue��һ���������У������洢�ȴ�ִ�е��������������ѡ��Ҳ����Ҫ��
 ����̳߳ص����й��̲����ش�Ӱ�죬һ����˵��������������������¼���ѡ��
 ArrayBlockingQueue;
 LinkedBlockingQueue;
 SynchronousQueue;
 ArrayBlockingQueue��PriorityBlockingQueueʹ�ý��٣�һ��ʹ��LinkedBlockingQueue��Synchronous��
 �̳߳ص��ŶӲ�����BlockingQueue�йء�

 threadFactory���̹߳�������Ҫ���������̣߳�

 handler����ʾ���ܾ���������ʱ�Ĳ��ԣ�����������ȡֵ��
 ThreadPoolExecutor.AbortPolicy:���������׳�RejectedExecutionException�쳣��
 ThreadPoolExecutor.DiscardPolicy��Ҳ�Ƕ������񣬵��ǲ��׳��쳣��
 ThreadPoolExecutor.DiscardOldestPolicy������������ǰ�������Ȼ�����³���ִ�������ظ��˹��̣�
 ThreadPoolExecutor.CallerRunsPolicy���ɵ����̴߳��������
 **/



/**  ��ThreadPoolExecutor�����м����ǳ���Ҫ�ķ�����
 execute()
 submit()
 shutdown()
 shutdownNow()
 execute()����ʵ������Executor�������ķ�������ThreadPoolExecutor�����˾����ʵ�֣�
 ���������ThreadPoolExecutor�ĺ��ķ�����ͨ����������������̳߳��ύһ�����񣬽����̳߳�ȥִ�С�
 submit()��������ExecutorService�������ķ�������AbstractExecutorService���Ѿ����˾���
 ��ʵ�֣���ThreadPoolExecutor�в�û�ж��������д���������Ҳ���������̳߳��ύ����ģ�������
 ��execute()������ͬ�����ܹ���������ִ�еĽ����ȥ��submit()������ʵ�֣��ᷢ����ʵ���ϻ���
 ���õ�execute()������ֻ������������Future����ȡ����ִ�н����Future������ݽ�����һƪ��������
 shutdown()��shutdownNow()�������ر��̳߳صġ�
 ���кܶ������ķ�����
 ���磺getQueue() ��getPoolSize() ��getActiveCount()��getCompletedTaskCount()�Ȼ�ȡ��
 �̳߳�������Եķ���������Ȥ�����ѿ������в���API��
 **/



/**
 �����ǰ�̳߳��е��߳���ĿС��corePoolSize����ÿ��һ�����񣬾ͻᴴ��һ���߳�ȥִ���������

 �����ǰ�̳߳��е��߳���Ŀ>=corePoolSize����ÿ��һ�����񣬻᳢�Խ�����ӵ����񻺴���е��У�
 ����ӳɹ�����������ȴ������߳̽���ȡ��ȥִ�У������ʧ�ܣ�һ����˵�����񻺴������������
 ��᳢�Դ����µ��߳�ȥִ���������

 �����ǰ�̳߳��е��߳���Ŀ�ﵽmaximumPoolSize������ȡ����ܾ����Խ��д���

 ����̳߳��е��߳��������� corePoolSizeʱ�����ĳ�߳̿���ʱ�䳬��keepAliveTime��
 �߳̽�����ֹ��ֱ���̳߳��е��߳���Ŀ������corePoolSize���������Ϊ���ĳ��е��߳���
 �ô��ʱ�䣬��ô���ĳ��е��߳̿���ʱ�䳬��keepAliveTime���߳�Ҳ�ᱻ��ֹ��
 **/



/**   �̳߳��е��̳߳�ʼ��
 prestartCoreThread()����ʼ��һ�������̣߳�
 prestartAllCoreThreads()����ʼ�����к����߳�
 **/


/**���񻺴���м��ŶӲ���
 ������ǰ�����Ƕ���ᵽ�����񻺴���У���workQueue����������ŵȴ�ִ�е�����
 ����workQueue������ΪBlockingQueue<Runnable>��ͨ������ȡ�����������ͣ�
 ����1��ArrayBlockingQueue������������Ƚ��ȳ����У��˶��д���ʱ����ָ����С��
 ����2��LinkedBlockingQueue������������Ƚ��ȳ����У��������ʱû��ָ���˶��д�С����Ĭ��ΪInteger.MAX_VALUE��
 ����3��synchronousQueue��������бȽ����⣬�����ᱣ���ύ�����񣬶��ǽ�ֱ���½�һ���߳���ִ������������
 **/



/**        ����ܾ�����
 �������̳߳ص����񻺴�������������̳߳��е��߳���Ŀ�ﵽmaximumPoolSize��
     ��������������ͻ��ȡ����ܾ����ԣ�ͨ�����������ֲ��ԣ�
 ThreadPoolExecutor.AbortPolicy:���������׳�RejectedExecutionException�쳣��
 ThreadPoolExecutor.DiscardPolicy��Ҳ�Ƕ������񣬵��ǲ��׳��쳣��
 ThreadPoolExecutor.DiscardOldestPolicy������������ǰ�������Ȼ�����³���ִ�������ظ��˹��̣�
 ThreadPoolExecutor.CallerRunsPolicy���ɵ����̴߳��������
 **/


/**  �̳߳صĹر�
 ThreadPoolExecutor�ṩ�����������������̳߳صĹرգ��ֱ���shutdown()��shutdownNow()�����У�
 shutdown()������������ֹ�̳߳أ�����Ҫ���������񻺴�����е�����ִ��������ֹ������Ҳ��������µ�����
 shutdownNow()��������ֹ�̳߳أ������Դ������ִ�е����񣬲���������񻺴���У�������δִ�е�����
 **/

/**�̳߳������Ķ�̬����
 ����ThreadPoolExecutor�ṩ�˶�̬�����̳߳�������С�ķ�����setCorePoolSize()��setMaximumPoolSize()��
 setCorePoolSize�����ú��ĳش�С
 setMaximumPoolSize�������̳߳�����ܴ������߳���Ŀ��С
 ������������С���ʱ��ThreadPoolExecutor�����̸߳�ֵ�����������������µ��߳���ִ������
 **/



/**
 * ������java doc�У������ᳫ����ֱ��ʹ��ThreadPoolExecutor������ʹ��Executors�����ṩ�ļ�����̬�����������̳߳أ�
 Executors.newCachedThreadPool();        //����һ������أ������������СΪInteger.MAX_VALUE
 Executors.newSingleThreadExecutor();   //��������Ϊ1�Ļ����
 Executors.newFixedThreadPool(int);    //�����̶�������С�Ļ����
 ������������������̬�����ľ���ʵ��;
 public static ExecutorService newFixedThreadPool(int nThreads) {
 return new ThreadPoolExecutor(nThreads, nThreads,0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>());
 }
 public static ExecutorService newSingleThreadExecutor() {
 return new FinalizableDelegatedExecutorService(new ThreadPoolExecutor(1, 1,0L, TimeUnit.MILLISECONDS,
 new LinkedBlockingQueue<Runnable>()));
 }
 public static ExecutorService newCachedThreadPool() {
 return new ThreadPoolExecutor(0, Integer.MAX_VALUE,60L, TimeUnit.SECONDS,new SynchronousQueue<Runnable>());
 }
 ���������ǵľ���ʵ������������ʵ����Ҳ�ǵ�����ThreadPoolExecutor��ֻ���������������ú��ˡ�
 ����newFixedThreadPool�������̳߳�corePoolSize��maximumPoolSizeֵ����ȵģ���ʹ�õ�LinkedBlockingQueue��
 ����newSingleThreadExecutor��corePoolSize��maximumPoolSize������Ϊ1��Ҳʹ�õ�LinkedBlockingQueue��
 ����newCachedThreadPool��corePoolSize����Ϊ0����maximumPoolSize����ΪInteger.MAX_VALUE��ʹ�õ�SynchronousQueue��
     Ҳ����˵��������ʹ����߳����У����߳̿��г���60�룬�������̡߳�
 ����ʵ���У����Executors�ṩ��������̬����������Ҫ�󣬾;���ʹ�����ṩ������������
     ��Ϊ�Լ�ȥ�ֶ�����ThreadPoolExecutor�Ĳ����е��鷳��Ҫ����ʵ����������ͺ��������������á�
 �������⣬���ThreadPoolExecutor�ﲻ��Ҫ�󣬿����Լ��̳�ThreadPoolExecutor�������д��
 **/
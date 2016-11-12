package io_example.Bokeyuan.PipedOut_InputStream;
import java.io.PipedOutputStream;

/**
 ** Created by Administrator on 2016/1/3.
 ** PipedOutputStream
 **/
public class Send implements Runnable{
    private PipedOutputStream out=null;
    public Send() {
        out=new PipedOutputStream();
    }
    public PipedOutputStream getOut(){
        return this.out;
    }
    public void run(){
        String message="hello , zzy";
        try{
            out.write(message.getBytes());
        }catch (Exception e) {
            e.printStackTrace();
        }try{
            out.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
/**
 * ���췽��ժҪ
 PipedOutputStream()
 ������δ���ӵ��ܵ��������Ĺܵ��������
 PipedOutputStream(PipedInputStream snk)
 �������ӵ�ָ���ܵ��������Ĺܵ��������

 ����ժҪ
 void	close()
 �رմ˹ܵ���������ͷ�������йص�����ϵͳ��Դ��
 void	connect(PipedInputStream snk)
 ���˹ܵ���������ӵ������ߡ�
 void	flush()
 ˢ�´��������ǿ��д�����л��������ֽڡ�
 void	write(byte[] b, int off, int len)
 �� len �ֽڴӳ�ʼƫ����Ϊ off ��ָ�� byte ����д��ùܵ��������
 void	write(int b)
 ��ָ�� byte д�봫�͵��������**/

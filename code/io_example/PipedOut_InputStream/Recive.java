package io_example.Bokeyuan.PipedOut_InputStream;
import java.io.IOException;
import java.io.PipedInputStream;

/**
 * Created by Administrator on 2016/1/3.
 * PipedInputStream
 */
public class Recive implements Runnable{
    private PipedInputStream input=null;
    public Recive(){
        this.input=new PipedInputStream();
    }
    public PipedInputStream getInput(){
        return this.input;
    }
    public void run(){
        byte[] b=new byte[1024];
        int len=0;
        System.out.println("The recive contain:");
        try{
            while ((len=input.read(b))!=-1) {
                System.out.println(new String(b,0,len));
            }
        }catch (IOException e){
            e.printStackTrace();
        }try{
            input.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/**
 ���췽��ժҪ
 PipedInputStream()
 ������δ���ӵ� PipedInputStream��
 PipedInputStream(int pipeSize)
 ����һ����δ���ӵ� PipedInputStream�����Թܵ�������ʹ��ָ���Ĺܵ���С��
 PipedInputStream(PipedOutputStream src)
 ���� PipedInputStream��ʹ�����ӵ��ܵ������ src��
 PipedInputStream(PipedOutputStream src, int pipeSize)
 ����һ�� PipedInputStream��ʹ�����ӵ��ܵ������ src�����Թܵ�������ʹ��ָ���Ĺܵ���С��

 ����ժҪ
 int	available()
 ���ؿ��Բ��������شӴ��������ж�ȡ���ֽ�����
 void	close()
 �رմ˹ܵ����������ͷ��������ص�����ϵͳ��Դ��
 void	connect(PipedOutputStream src)
 ʹ�˹ܵ����������ӵ��ܵ������ src��
 int	read()
 ��ȡ�˹ܵ��������е���һ�������ֽڡ�
 int	read(byte[] b, int off, int len)
 ����� len �������ֽڴӴ˹ܵ����������� byte ���顣
 protected  void	receive(int b)
 ���������ֽڡ�**/

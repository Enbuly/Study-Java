package NIO.Buffer_detail;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by john on 2016/9/10.
 * ByteBuffer allocateDirect
 */
// ֱ�ӻ�������Ϊ�ӿ�I/O�ٶȣ�ʹ��һ�����ⷽʽΪ������ڴ�Ļ�������
// JDK�ĵ��е�����Ϊ������һ��ֱ���ֽڻ�������Java������������Ŭ
// ��ֱ�Ӷ���ִ�б���I/O������Ҳ����˵��������ÿһ�ε��õײ����ϵ
// ͳ�ı���I/O����֮ǰ(��֮��)�����Ա��⽫�����������ݿ�����һ����
// �仺������ ���ߴ�һ���м仺�����п������ݡ�Ҫ����ֱ�ӻ�������
// ��Ҫ����allocateDirect()������������allocate()������ʹ�÷�ʽ
// ����ͨ��������������
public class Direct_ByteBuffer {
    static public void main( String args[] ) throws Exception {
        String infile = "D:\\ran.txt";
        FileInputStream fin = new FileInputStream( infile );
        FileChannel fcin = fin.getChannel();

        String outfile = String.format("D:\\ran2.txt");
        FileOutputStream fout = new FileOutputStream( outfile );
        FileChannel fcout = fout.getChannel();

        // ʹ��allocateDirect��������allocate
        ByteBuffer buffer = ByteBuffer.allocateDirect( 1024 );

        int recond = fcin.read(buffer); //read into buffer.
        while (recond != -1) {
            try {
                buffer.flip();  //make buffer ready for read
                fcout.write(buffer);
                buffer.clear(); //make buffer ready for writing
                recond = fcin.read(buffer);
            }catch (Exception e){System.out.println(e.getMessage());}
        }
    }
}


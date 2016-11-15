package NIO.Buffer_detail;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by john on 2016/9/14.
 * author zzy
 */
// MappedByteBuffer��һ�ֶ���д�ļ����ݵķ����������Աȳ���Ļ���
// �����߻���ͨ����I/O��Ķࡣ�ڴ�ӳ���ļ�I/O��ͨ��ʹ�ļ��е���
// �ݳ���Ϊ �ڴ��������������ɵģ�������������ƺ��������ǽ�
// �����ļ������ڴ��У�������ʵ�ϲ�����������һ����˵��ֻ����
// ����ʵ�ʶ�ȡ����д��Ĳ��ֲŻ�ӳ�䵽�ڴ���
//ByteBuffer:
//Read time :54ms
//Write time :31ms

//MappedByteBuffer:
//Read time :7ms
//Write time :31ms
public class MappedByteBuffer_it {
    public static void main(String[] args) throws Exception {
        //ByteBuffer byteBuf = ByteBuffer.allocate(1024*14*1024);
        FileInputStream fis = new FileInputStream("D:\\Monster.mp3");
        FileOutputStream fos = new FileOutputStream("D:\\copyMonster.mp3");
        FileChannel fic = fis.getChannel();
        FileChannel foc=fos.getChannel();

        long timeStar = System.currentTimeMillis();
        //fic.read(byteBuf);
        MappedByteBuffer mib = fic.map(FileChannel.MapMode.READ_ONLY, 0, fic.size());
        System.out.println(fic.size()/(1024*1024));
        long timeEnd = System.currentTimeMillis();
        System.out.println("Read time :" + (timeEnd - timeStar) + "ms");

        timeStar = System.currentTimeMillis();
        //byteBuf.flip();
        //foc.write(byteBuf);
        foc.write(mib);
        timeEnd = System.currentTimeMillis();
        System.out.println("Write time :" + (timeEnd - timeStar) + "ms");

        fic.close();
        foc.close();
        fos.flush();
        fis.close();
    }
}

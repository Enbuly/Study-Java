package io_example.FileWriter_FileReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Administrator on 2015/12/27.
 * FileWriter.
 * separator
 ������������װ��; ������;
 */
public class Demo{
    public static void main(String[]args){
        /**String doc="f:/RRZZYY/data.txt";
        ����Ҫ�������ļ�·��������
        ���У�File.separator��ʾϵͳ��صķָ�����Linux��Ϊ��/  Windows��Ϊ��\
        **/
        String path ="d:"+ File.separator+"testio"+File.separator+"data4.txt";
        /**����IO�������׳��쳣�������try������ⲿ����FileWriter������**/
        FileWriter w = null;
        try{
            /**�����Ҫ׷�����ݣ������Ǹ��ǣ���ʹ��FileWriter��path��true�����췽��**/
            w = new FileWriter(path,true);
            /**���ַ���д�뵽���У�\r\n��ʾ����**/
            w.write("zzy is a good boy\r\n");
            /**��������Ͽ���д��Ч��������Ҫ����w.flush()����**/
            w.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            /**���ǰ�淢���쳣����ô���޷�����w�����
            ���Ҫ�����жϣ����ⷢ����ָ���쳣**/
            if(w != null) {
                try {
                    w.close();/**�ر�����Դ����Ҫ�ٴβ�׽�쳣**/
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
/***

 public void write(String str)
 throws IOException
 д���ַ�����
 ������
 str - Ҫд����ַ���
 �׳���
 IOException - ������� I/O ����


 public void write(String str,int off,int len) throws IOException
 д���ַ�����ĳһ���֡�
 ������
 str - �ַ���
 off - ��Գ�ʼд���ַ���ƫ����
 len - Ҫд����ַ���
 �׳���
 IndexOutOfBoundsException - ��� off �� len Ϊ�������� off+len Ϊ������ڸ����ַ����ĳ���
 IOException - ������� I/O ����
 ***/

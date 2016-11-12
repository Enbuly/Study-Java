package io_example.FileWriter_FileReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Administrator on 2015/12/28.
 * FileReader.
 **/
public class Demo2 {
    public static void main(String[] args ) {
        /**String path ="f:/RRZZYY/data.txt";**/
        String path ="d:"+ File.separator+"testio"+File.separator+"data4.txt";
        //System.out.print(File.separator);
        FileReader r = null;
        try {
             r=new FileReader(path);
            /**��ʽһ����ȡ�����ַ��ķ�ʽ
            ÿ��ȡһ�Σ������ƶ�һ���ַ���λ**/
            /**
            int temp1 = r.read();
            System.out.println((char)temp1);
            int temp2 = r.read();
            System.out.println((char)temp2);**/

            /**��ʽ����ѭ����ȡ�ļ򻯲���
            �����ַ���ȡ����temp������-1��ʱ���ӡ�ַ�**/

           /**�ַ����������
            int temp =0;
            while ((temp = r.read())!= -1){
                System.out.print((char)temp);
            }**/

            /**��ʽ�������뵽�ַ�������Ż�
            ������ʱ���ļ�̫���޷�ȷ����Ҫ����������С
            ���һ�㶨�����鳤��Ϊ1024������ѭ���ķ�ʽ����**/
            char[] buf = new char[1024];
            int temp = 0;
            while((temp = r.read(buf)) != -1) {
                System.out.print(new String(buf,0,temp));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(r != null) {
                try {
                    r.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
/**
 public int read(char[] cbuf)
 throws IOException
 ���ַ��������顣��ĳ��������á����� I/O ��������ѵ�������ĩβǰ���˷���һֱ������
 ������
 cbuf - Ŀ�껺����
 ���أ�
 ��ȡ���ַ���������ѵ�������ĩβ���򷵻� -1
 �׳���
 IOException - ������� I/O ����
 **/

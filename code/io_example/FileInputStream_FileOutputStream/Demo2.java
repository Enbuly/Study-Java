package io_example.FileInputStream_FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2015/12/28.
 * FileInputStream
 */
public class Demo2 {
    public static void main(String[] args ) {
        String path ="D:/testio/data3.txt";
        FileInputStream i = null;
        try {
            i = new FileInputStream(path);
            /**��ʽһ�������ַ���ȡ
            ��Ҫע����ǣ��˴�����Ӣ���ı�����Ч������
            �����ľͱ����ˣ�����������������Ч������
            int ch = 0;
            while((ch=i.read())!=-1){
                System.out.print((char)ch);
            }**/

            /**��ʽ��������ѭ����ȡ**/
            byte[] buf = new byte[1024];
            int len = 0;
            while((len = i.read(buf))!=-1) {
                System.out.println(new String(buf,0,len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(i != null) {
                try {
                    i.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

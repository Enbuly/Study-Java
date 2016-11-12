package io_example.FileWriter_FileReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Administrator on 2015/12/28.
 * �ļ��ĸ���
 */
public class Demo3 {
    public static void main(String[]args){
        String doc="d:/testio/data2.data";
        String copy="d:/testio/data2copy.data";
        FileReader r = null;
        FileWriter w = null;
        try {
            r = new FileReader(doc);
            w = new FileWriter(copy);

            /**��ʽһ�������ַ�д��**/
            /**
            int temp = 0;
            while((temp = r.read()) != -1) {
                w.write(temp);
            }**/

            /**��ʽ�����ַ����鷽ʽд��**/
            char[] buf = new char[1024];
            int temp = 0;
            while((temp = r.read(buf))!=-1){
                w.write(new String(buf,0,temp));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            /**�ֱ��ж��Ƿ��ָ�����ã�Ȼ��ر���**/
            if(r != null) {
                try {
                    r.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(w != null) {
                try {
                    w.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

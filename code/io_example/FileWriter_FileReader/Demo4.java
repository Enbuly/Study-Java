package io_example.FileWriter_FileReader;

import java.io.*;

/**
 * Created by Administrator on 2015/12/28.
 * BufferedReader    BufferedWriter
 */
public class Demo4 {
    public static void main(String[] args ){
        String doc="d:/testio/data2.data";
        String copy="d:/testio/data2copy2.data";
        FileReader r=null;
        FileWriter w=null;
        /**����������������**/
        BufferedReader br = null;
        BufferedWriter bw = null;
        try{
            r = new FileReader(doc);
            w = new FileWriter(copy);
            /**��������������
            ����Ҫ���Ч�ʵ�FileReader��FileWriter��������乹�캯����
            ��Ȼ��Ҳ����ʹ����������ķ�ʽ br = new BufferedReader(new FileReader(doc));**/
            br=new BufferedReader(r);
            bw=new BufferedWriter(w);

            String line = null;
            /**��ȡ�У�ֱ������null
            readLine()����ֻ���ػ��з�֮ǰ������**/
            while((line = br.readLine()) != null){
                bw.write(line);
                /**ʹ��BufferWriter�����д�뷽��д���ļ�����֮����
                 newLine()��������ƽ̨����windows�µĻ�����\r\nLinux������\n**/
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            /**�˴�������Ҫ��׽FileReader��FileWriter������쳣
            �رջ��������ǹرջ������е�������**/
            if(br != null) {
                try {
                    r.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

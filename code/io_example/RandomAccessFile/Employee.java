package io_example.RandomAccessFile;
/**
 * Created by Administrator on 2015/12/26.
 * RandomAccessFile��
 ֻ�ܷ����ļ������ܲ�������io�豸
 ֧���������
 �ڶ�д�ȳ���¼�ļ�������
 */
public class Employee{
    private String name;
    private int age;
    public static final int LEN = 8;
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public Employee(String name, int age){
        if (name.length() > LEN) { /** Ϊ�˹���ȳ���¼��String name�ɰ˸�char���**/
            this.name=name.substring(0, LEN-1);
            /**��ȡ�ַ�����0��LEN-1���֣�����һ�����ַ��������Ǵ��ַ�����һ�����ַ�����**/
        } else {
            this.name=name;
            while(this.name.length()<LEN) {
                this.name +='\u0000';
            }
        }
        this.age = age;
    }
}

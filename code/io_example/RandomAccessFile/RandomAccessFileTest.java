package io_example.RandomAccessFile;

import java.io.RandomAccessFile;

/**
 * Created by Administrator on 2015/12/26.
 * RandomAccessFile��
 ֻ�ܷ����ļ������ܲ�������io�豸
 ֧���������
 �ڶ�д�ȳ���¼�ļ�������
 */
public class RandomAccessFileTest{
    public static void main(String[]args){
        Employee e1 = new Employee("Ronnie", 37);
        Employee e2 = new Employee("John", 33);
        Employee e3 = new Employee("Mark", 38);
        try {
            RandomAccessFile randFile = new RandomAccessFile("employee.txt", "rw");

            randFile.writeChars(e1.getName());
            /**randFile.getFilePointer()���ش��ļ��еĵ�ǰƫ������**/
            /**long zzy=randFile.getFilePointer();
            System.out.println(zzy);һ��char16λ�������ֽڣ��˸�16���ֽ�**/
            randFile.writeInt(e1.getAge());
            /**long zzx=randFile.getFilePointer();
            System.out.println(zzx);һ��int32λ���ĸ��ֽ�**/
            randFile.writeChars(e2.getName());
            randFile.writeInt(e2.getAge());
            randFile.writeChars(e3.getName());
            randFile.writeInt(e3.getAge());
            randFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            RandomAccessFile randFile = new RandomAccessFile("employee.txt", "r");

            randFile.seek(40);
            String name = "";
            for (int i=0;i<Employee.LEN; ++i) {
                name+=randFile.readChar();
            }
            System.out.println(name.trim()+":" + randFile.readInt());/***name.trim�����ַ����ĸ���������ǰ���հ׺�β���հס�**/

            randFile.seek(0);
            name = "";
            for (int i=0;i<Employee.LEN;++i) {
                name += randFile.readChar();
            }
            System.out.println(name.trim() + ":" + randFile.readInt());

            randFile.seek(20);
            name = "";
            for (int i=0;i<Employee.LEN;++i) {
                name += randFile.readChar();
            }
            System.out.println(name.trim() + ":" + randFile.readInt());
            randFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

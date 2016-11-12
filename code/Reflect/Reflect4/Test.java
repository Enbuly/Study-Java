package Reflect.Reflect4;

import java.lang.reflect.Method;

/**
 * Created by john on 2016/5/9.
 * get the class Methods
 */
public class Test {
    public static void main(String[]args)throws Exception{
        Class<?> demo1;
        demo1=Class.forName("Reflect.Reflect4.Emp");
        //Method[] method=demo1.getDeclaredMethods();
        Method[] method=demo1.getMethods();
        for (Method m : method) {
            System.out.println(m);
        }

        //����һ������
        Emp emp=(Emp)demo1.newInstance();
        Method setName=demo1.getMethod("setName",String.class);
        setName.invoke(emp,"zzy");
        System.out.println(emp);

        //����һ������,���������private���򲻿��Ե���
        Emp emp2=(Emp)demo1.newInstance();
        Method save=demo1.getMethod("save");
        save.invoke(emp2);

    }
}
//public Method[] getMethods()
/**����һ�� Method ��������飬��Щ����ӳ�� Class
 * ��������ʾ�����ӿڣ�������Щ�ɸ����ӿ��������Լ���
 * ����ͳ��ӿڼ̳е���Щ�����ӿڣ���!!public member method **/

//public Method[] getDeclaredMethods()
/**���� Method �����һ�����飬��Щ����ӳ�� Class �����
 * ʾ�����ӿ����������з���������������������Ĭ�ϣ�����
 * ���ʺ�˽�з��������������̳еķ���**/
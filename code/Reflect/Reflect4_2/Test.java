package Reflect.Reflect4_2;

import java.lang.reflect.Field;

/**
 * Created by john on 2016/5/9.
 * get the class Fields
 */
public class Test {
    public static void main(String[]args)throws ClassNotFoundException{
        Class<?> demo1;
        demo1=Class.forName("Reflect.Reflect4_2.Emp");
        Field[] fields=demo1.getDeclaredFields();
        for (Field m : fields) {
            System.out.println(m);
        }
    }
}
/**�ɼ�getFields��getDeclaredFields����
 getFields���ص�������Ϊpublic�����ԣ����������ж��壬
 getDeclaredFields���ص���ָ���ඨ������ж�������ԣ�����������ġ�**/
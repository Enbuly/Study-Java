package Reflect.Reflect4_3;

import java.lang.reflect.Constructor;

/**
 * Created by john on 2016/5/9.
 * get the class Constructor
 */
public class Test {
    public static void main(String[]args)throws ClassNotFoundException{
        Class<?> demo1;
        demo1=Class.forName("Reflect.Reflect4_3.Emp");
        Constructor<?>[] constructors = demo1.getConstructors();
        for (Constructor<?> m : constructors) {
            System.out.println(m);
        }

        constructors = demo1.getDeclaredConstructors();
        for (Constructor<?> m : constructors) {
            System.out.println(m);
        }
    }
}
//public Constructor<?>[] getConstructors()
/**����һ������ĳЩ Constructor ��������飬��Щ����ӳ�� Class ��������ʾ��������й������췽��**/

//public Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes)
/**����һ�� Constructor ���󣬸ö���ӳ�� Class ��������ʾ�����ӿڵ�ָ�����췽��**/
package Reflect.Reflect5;

/**
 * Created by Administrator on 2015/12/25.
 * return a class interface
 **/
public class hello {
    public static void main(String[] args) {
        Class<?> demo=null;
        try{
            demo=Class.forName("Reflect.Reflect5.Person");
        }catch (Exception e) {
            e.printStackTrace();
        }
        //�������еĽӿ�
        Class<?>[] intes=demo.getInterfaces();
        for (int i = 0; i < intes.length; i++) {
            System.out.println("The interface  "+intes[i].getName());
        }
    }
}

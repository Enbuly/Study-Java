package Thread_use.Publish;

/**
 * Created by john on 2016/5/24.
 * test UnsafeStates
 */
public class Main {
    public static void main(String[]args){
        UnsafeStates unsafeStates=new UnsafeStates();
        //System.out.print(unsafeStates.getStates());
        String[]a=unsafeStates.getStates();
        a[0]="ss";//��������õĶ���Ϊʲô�޸����ö���Ϳ��Զ�ԭ��������޸�
        String[]b=unsafeStates.getStates();
        System.out.print(b[0]);
    }
}

package NIO.Scatter_Gather;

import java.nio.ByteBuffer;

/**
 * Created by john on 2016/9/10.
 * scatter / gather����������Ҫ����������ݷֿ�����ĳ��ϣ�
 * ���紫��һ������Ϣͷ����Ϣ����ɵ���Ϣ������ܻὫ��Ϣ��
 * ����Ϣͷ��ɢ����ͬ��buffer�У���������Է���Ĵ�����Ϣ
 * ͷ����Ϣ�塣
 */
//��ɢ��scatter����Channel�ж�ȡ��ָ�ڶ�����ʱ��
// ��ȡ������д����buffer�С���ˣ�Channel��
// ��Channel�ж�ȡ�����ݡ���ɢ��scatter������
// ���Buffer�С�
public class Scattering_Reads {
    public static void main(String[]args){
        ByteBuffer header = ByteBuffer.allocate(128);
        ByteBuffer body   = ByteBuffer.allocate(1024);
        ByteBuffer[] bufferArray = { header, body };
        //channel.read(bufferArray);
        // read()��������buffer�������е�˳�򽫴�channel
        // �ж�ȡ������д�뵽buffer����һ��buffer��д����channel��
        // ��������һ��buffer��д��
    }
}
// Scattering Reads���ƶ���һ��bufferǰ������������ǰ��buffer��
// ��Ҳ��ζ�����������ڶ�̬��Ϣ(����ע����Ϣ��С���̶�)�����仰˵��
// ���������Ϣͷ����Ϣ�壬��Ϣͷ���������䣨���� 128byte����
// Scattering Reads��������������

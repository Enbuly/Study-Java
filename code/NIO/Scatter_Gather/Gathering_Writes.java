package NIO.Scatter_Gather;

import java.nio.ByteBuffer;

/**
 * Created by john on 2016/9/10.
 * scatter / gather����������Ҫ����������ݷֿ�����ĳ��ϣ�
 * ���紫��һ������Ϣͷ����Ϣ����ɵ���Ϣ������ܻὫ��Ϣ
 * �����Ϣͷ��ɢ����ͬ��buffer�У���������Է���Ĵ�
 * ����Ϣͷ����Ϣ�塣
 */
//�ۼ���gather��д��Channel��ָ��д����ʱ�����
// buffer������д��ͬһ��Channel����ˣ�Channel
// �����Buffer�е����ݡ��ۼ���gather��������
// ��Channel��
public class Gathering_Writes {
    ByteBuffer header = ByteBuffer.allocate(128);
    ByteBuffer body   = ByteBuffer.allocate(1024);
    //write data into buffers
    ByteBuffer[] bufferArray = { header, body };
    //channel.write(bufferArray);
}
//buffers������write()��������Σ�write()�����ᰴ��buffer
// �������е�˳�򣬽�����д�뵽channel��ע��ֻ��position��
// limit֮������ݲŻᱻд�롣��ˣ����һ��buffer������Ϊ
// 128byte�����ǽ�������58byte�����ݣ���ô��58byte�����ݽ�
// ��д�뵽channel�С������Scattering Reads�෴��Gathering
// Writes�ܽϺõĴ���̬��Ϣ��
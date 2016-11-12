package Data_Structure;

public class Sort {
	public static int[] insertSort(int[]a){//��������
		int j;
		for(int p=1;p<a.length;p++){
			int tmp=a[p];
			for(j=p;j>0&&tmp-a[j-1]<0;j--){
				a[j]=a[j-1];
			}
			a[j]=tmp;
		}
		return a;
	}
	public static int[] shellSort(int[]a){//ϣ������
		int j;
		for(int gap=a.length/2;gap>0;gap/=2)
			for(int i=gap;i<a.length;i++){
				int tmp=a[i];
				for(j=i;j>=gap&&tmp-a[j-gap]<0;j-=gap)
					a[j]=a[j-gap];
				a[j]=tmp;
			}
		return a;
	}
	public static void HeapAdjust(int array[],int i,int nLength)//������ĵ�������
	{
	    int nChild;
	    int nTemp;
	    for(;2*i+1<nLength;i=nChild)
	    {
	        //�ӽ���λ��=2*�������λ�ã�+1
	        nChild=2*i+1;
	        //�õ��ӽ���нϴ�Ľ��
	        if(nChild<nLength-1&&array[nChild+1]>array[nChild])
	        	++nChild;
	        //����ϴ���ӽ����ڸ������ô�ѽϴ���ӽ�������ƶ����滻���ĸ����
	        if(array[i]<array[nChild])
	        {
	            nTemp=array[i];
	            array[i]=array[nChild];
	            array[nChild]=nTemp; 
	        }
	        else break; //�����˳�ѭ��
	    }
	}
	public static int[] HeapSort(int array[],int length)//������
	{
	    int i;
		//�������е�ǰ�벿��Ԫ�أ�������֮���һ��Ԫ�������е�����Ԫ��
		//length/2-1�����һ����Ҷ�ڵ㣬�˴�"/"Ϊ����
	    for(i=length/2-1;i>=0;--i)
	        HeapAdjust(array,i,length);
		//�����һ��Ԫ�ؿ�ʼ�����н��е��������ϵ���С�����ķ�Χֱ����һ��Ԫ��
	    for(i=length-1;i>0;--i)
	    {
	        //�ѵ�һ��Ԫ�غ͵�ǰ�����һ��Ԫ�ؽ�����
	        //��֤��ǰ�����һ��λ�õ�Ԫ�ض��������ڵ��������֮������
	    	int ittemp=array[i];
	    	array[i]=array[0];
	    	array[0]=ittemp;
	        //������С����heap�ķ�Χ��ÿһ�ε�����ϱ�֤��һ��Ԫ���ǵ�ǰ���е����ֵ
	        HeapAdjust(array,0,i);
	    }
	    return array;
	}
	public static int[] sort(int arr[],int low,int high){//��������
		 int l=low;
		 int h=high;
		 int povit=arr[low];
		 while(l<h)
		 {
			 while(l<h&&arr[h]>=povit)
		        h--;
		     if(l<h){
		        int temp=arr[h];
		        arr[h]=arr[l];
		        arr[l]=temp;
		        l++;
		     }
		     while(l<h&&arr[l]<=povit)
		        l++;
		     if(l<h){
		        int temp=arr[h];
		        arr[h]=arr[l];
		        arr[l]=temp;
		        h--;
		     }
		 }
		 if(l>low)sort(arr,low,l-1);
		 if(h<high)sort(arr,l+1,high);
		 return arr;
	}
	public static int[] SimpleChoiceSort(int[]a){//��ѡ������
		for(int i=0;i<a.length;i++)
	    {
	        int k=i;
	        for(int j=i+1;j<a.length;j++){
	            if(a[k]>a[j])
	                k=j;
	         }
	         if(k!=i){
	            int t=a[i];
	            a[i]=a[k];
	            a[k]=t;
	         }
	    }
		return a;
	}
	public static int[] bubble_sort(int[]a)//ð������
	{
	    int i,j,temp;
	    for(j=0;j<a.length-1;j++)
	        for(i=0;i<a.length-1-j;i++)
	        {
	            if(a[i]<a[i+1])
	            {
	                temp=a[i];
	                a[i]=a[i+1];
	                a[i+1]=temp;
	            }
	        }
	    return a;
	}
	public static int[] mergeSort(int[]a){//�鲢�����㷨
		int[]tmpArray=new int[a.length];
		mergeSortt(a,tmpArray,0,a.length-1);
		return a;
	}
	public static void mergeSortt(int[]a,int[]tmpArray,int left,int right){//�ݹ鲿��
		if(left<right){
			int center=(left+right)/2;
			mergeSortt(a,tmpArray,left,center);
			mergeSortt(a,tmpArray,center+1,right);
			merge(a,tmpArray,left,center+1,right);
		}
	}
	public static void merge(int[]a,int[]tmpArray,int leftPos,int rightPos,int rightEnd){//�ϲ�����
		int leftEnd=rightPos-1;
		int tmpPos=leftPos;int num=rightEnd-leftPos+1;
		while(leftPos<=leftEnd&&rightPos<=rightEnd){
			if(a[leftPos]-a[rightPos]<=0){
				tmpArray[tmpPos++]=a[leftPos++];
			}
			else{
				tmpArray[tmpPos++]=a[rightPos++];
			}
		}
		while(leftPos<=leftEnd){
			tmpArray[tmpPos++]=a[leftPos++];
		}
		while(rightPos<=rightEnd){
			tmpArray[tmpPos++]=a[rightPos++];
		}
		for(int i=0;i<num;i++,rightEnd--){
			a[rightEnd]=tmpArray[rightEnd];
		}
	}
	public  static void main(String[]args){//���������������
		int[]a={6,9,7,4,5,8,3,2,1};
		int[]b= Sort.bubble_sort(a);
		for(int i=0;i<b.length;i++){
			System.out.println(b[i]);
		}
	}
}

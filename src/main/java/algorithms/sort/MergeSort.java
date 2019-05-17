package algorithms.sort;

/**
 * Created by 82138 on 2019/2/25.
 */
public class MergeSort extends Example {
    private static Comparable[] aux;
    private static void sort(Comparable[] a,int lo,int hi){
        if(lo == hi) return;
        int mid = lo + (hi - lo)/2;
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        merge(a,lo,mid,hi);
    }
    /**
     * 将两个有序数组进行合并
     * */
    public static void merge(Comparable[] a,int lo,int mid,int hi){
        int i=lo;int j = mid+1;
        //浅拷贝 System.arraycopy(); Arrays。copy这里为深copy 所以只能用循环来复制
        for(int k=lo;k<=hi;k++){
            aux[k] = a[k];
        }
        for(int k=lo;k<=hi;k++){
            if(i>mid) a[k]=aux[j++];
            else if(j>hi)  a[k]=aux[i++];
            else if(less(aux[i],aux[j])) a[k]=aux[i++];
            else a[k]=aux[j++];

        }
    }   @Override
    public void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        int N = a.length;
        sort(a,0,a.length-1);
    }


    public static void main(String[] args) {
        Example ss = new MergeSort();
        Integer[] a = {5,4,6,2,1,10};
        ss.sort(a);
        ss.show(a);
    }
}

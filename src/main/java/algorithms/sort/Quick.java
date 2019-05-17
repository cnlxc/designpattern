package algorithms.sort;

/**
 * Created by 82138 on 2018/10/10.
 */
public class Quick extends Example {

    @Override
    public void sort(Comparable[] a) {
        int hi = a.length-1;
        int lo=0;
        sort(a,lo,hi);
    }
    private void sort(Comparable[] a,int lo,int hi) {
        if(hi <= lo) return;
        int j = parition(a,lo,hi);

        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }

    private int parition(Comparable[] a,int lo,int hi) {
        int i=lo;int j = hi+1;
        Comparable v = a[lo];
        while(true){
            while(less(a[++i],v)) if(i==hi) break;
            while(less(v,a[--j])) if(j==lo) break;
            if(i >= j) break;
            exch(a,i,j);
        }
        exch(a,lo,j);
        return j;
    }


    public static void main(String[] args) {
        Example ss = new Quick();
        Integer[] a = {5,4,6,2,1,10};
        ss.sort(a);
        ss.show(a);
    }

}

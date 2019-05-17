package algorithms.sort;

/**
 * Created by 82138 on 2018/10/7.
 */
public class SelectionSort extends Example {

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        for(int i=0; i<N; i++) {
            int min = i;
            for(int j = i+1;j<N; j++){
                if(less(a[j],a[min]))
                    min = j;

            }
            exch(a,min,i);
        }
    }


    public static void main(String[] args) {
        SelectionSort ss = new SelectionSort();
        Integer[] a = {5,4,6,2,1,10};
        ss.sort(a);
        ss.show(a);
    }
}

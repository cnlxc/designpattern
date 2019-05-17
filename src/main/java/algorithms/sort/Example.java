package algorithms.sort;

/**
 * Created by 82138 on 2018/10/7.
 */
public abstract class Example {
    public abstract  void sort(Comparable[] a);
    public static boolean less(Comparable v,Comparable w) {
        return v.compareTo(w) <  0;
    }
    static void exch(Comparable[] a,int i,int j) {
        Comparable t = a[i]; a[i] = a[j];a[j] = t;
    }

    public static void show(Comparable[] a) {
        for(int i=0;i<a.length;i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    public static boolean isSort(Comparable[] a) {
        for(int i=1;i<a.length;i++) {
            if(less(a[i],a[i-1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Comparable[] a = {5,4,3,2,1};
        Example example = new Quick();
        example.sort(a);
        show(a);

    }

}

package algorithms.sort;

/**
 * Created by 82138 on 2018/10/7.
 */
public class InsertionSort extends Example {
    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        for(int i=1; i<N; i++) {
            for(int j=i;j>0&&less(a[j],a[j-1]);j--){
                //j位置的元素跟j-1位置的元素比较，如果a[j]小于[j-1]则交换位置，如果不小，因为j前面
                //的元素已经排好序了，所以a[j]也不会比a[j-2],a[j-3]....位置的元素小，所以只要一遇见a[j]>a[j-1]
                //就证明这个元素比左边的都大了，不用再循环了
                exch(a,j,j-1);
            }
        }
    }
    public void sortrecite(Comparable[] a){
        int N = a.length;
        for(int i=1;i<N;i++){
            for(int j=i;j>0&&less(a[j],a[j-1]);j--){
                exch(a,j-1,j);
            }
        }
        }

    public static void main(String[] args) {
        InsertionSort ss = new InsertionSort();
        Integer[] a = {5,4,6,2,1,10};
        ss.sortrecite(a);
        System.out.println(ss.isSort(a));
        ss.show(a);
    }
}

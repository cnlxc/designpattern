package algorithms.sort;

/**
 * Created by 82138 on 2018/12/30.
 */
public class HeapSort {
    private  void sink(Comparable[] a,int i,int N){
/*        while(2*k <= N){
            int j = 2*k;
            if(j<N && less(j,j+1)) j++;//找出子节点中大的那一个
            if( less(j,k) ) break;//j是子节点,k是父节点，子节点比父节点小的话，位置没问题 推出循环
            exch(k,j);//上面那个条件不满足的话，交换子节点和父节点

            exch(k,j+1);
            k=j;
        }*/

    }

    public void sort (Comparable[] a){
        int N = a.length;
        for(int i=N/2;i>=1;i--){
            sink(a,i,N);
        }
    }

 
}

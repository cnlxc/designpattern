package algorithms.search;

import java.util.Random;

/**
 * Created by 82138 on 2019/5/5.
 */
public class BST<KEY extends Comparable<KEY>,VALUE> {
    private Node root;

    private class Node{
        private KEY key;
        private VALUE value;
        private Node left;
        private Node right;
        private int n;//count
        public Node(KEY key,VALUE value,int count){
            this.key =key;
            this.value = value;
            this.n = count;
        }

        public String toString(){
            return key.toString();
        }
    }
    public int size(){
        return size(root);
    }

    public int size(Node node){
        if(node == null) return 0;
        return node.n;
    }

    public Node min(){
        return min(root);
    }
    private Node min(Node x){
        if(x.left ==null) return x;
        else return min(x.left);
    }



    public VALUE get(KEY k){
       return get(k,root);
    }

    private VALUE get(KEY key,Node root){
        if(root == null) return null;
        if(key.compareTo(root.key) < 0){
            get(key,root.left);
        }else if(key.compareTo(root.key) > 0){
            get(key,root.right);
        }
        return root.value;
    }


    public void put(KEY k,VALUE v){
        root = put(k,v,root);
    }

    private Node put(KEY k,VALUE v,Node x){
        if(x == null) return new Node(k,v,1);
        int comp = k.compareTo(x.key);
        if(comp < 0) x.left = put(k,v,x.left);
        else if(comp > 0) x.right = put(k,v,x.right);
        else {
            x.value = v;
        }
        x.n = size(x.left) +size(x.right) + 1;
        return x;
    }
    //获取排名为k的节点
    public Node select(int k){
        return select(k,root);
    }
    private Node select(int k,Node x){
        if(x==null) return null;

        if(k<x.left.n) return select(k,x.left);
        else if(k>x.left.n) return select(k - x.left.n - 1,x.right);
        else return x;
    }
    //返回键k的排名
    private int rank(Node x,KEY k){
        if(x == null) return 0;
        int comp = k.compareTo(x.key);
        if(comp < 0) return rank(x.left,k);
        if(comp > 0) return 1 + size(x.left) + rank(x.right,k);
        else return size(x.left);
    }

    public void deleteMin(){

    }
    //重点不在删除，而在如何连接被删节点附近的节点
    private Node deleteMin(Node x){
        if(x.left == null) return x.right;//左节点为空，则x为最小节点，返回它的右节点，即让x的右节点指向x的父节点的left引用
        x.left = deleteMin(x.left);//删除节点会返回它的右节点，所以x的左节点被删除，让被删除节点的右边指向x的left
        x.n = size(x.left) +size(x.right) +1;
        return x;


    }

    public void delete(KEY k){
        root = delete(root,k);

    }
    private Node delete(Node x,KEY k){
        if(x == null) return null;
        int cmp = k.compareTo(x.key);
        if(cmp < 0) x.left =  delete(x.left,k);
        else if(cmp > 0) x.right = delete(x.right,k);
        else {
            if(x.left == null) return x.right;
            if(x.right == null) return x.left;
            Node t = x;
            x = min(x.left);
            x.right = deleteMin(t);
            x.left = t.left;

        }
        x.n = size(x.left)+size(x.right)+1;
        return x;
    }
    //先序遍历，输出值从小到大
    public void print(Node x){
        if(x == null) return;
        print(x.left);
        System.out.println(x);
        print(x.right);

    }


    public static void main(String[] args) {
        BST<Integer,String> tree = new BST<>();
        Random random = new Random();
        int i = 0;
        while(i < 10){
            tree.put(random.nextInt(1000),"a");
            i++;
        }
        tree.print(tree.root);

    }

}

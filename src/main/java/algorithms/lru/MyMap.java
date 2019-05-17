package algorithms.lru;

import java.util.*;

/**
 * Created by 82138 on 2019/5/12.
 * 自己实现HashMap，为下一步用LinkedHashMap实现LRU算法做准备
 * get和remove还没写
 */
public class MyMap implements Map {

    private static String ss= "wocao";
    public static void main(String[] args) {
        MyMap myMap = new MyMap();
        Random random =new Random();
        int i = 0;
        while(i <200){
            i++;
            myMap.put(random.nextInt(),random.nextInt());
        }
        myMap.put(1,"1");
        myMap.put(1,"2");
        myMap.put(2,"2");
        myMap.put(2,"36");
        myMap.put(3,"2");
        myMap.put(4,"2");
        myMap.put(43,"2");
    }
    int size = 0;
    Node[] table = null;
    float loadfactor = 0.75f;
    int capacity;
    public MyMap(int capacity,float loadfactor){
        if(capacity <=0 || loadfactor <= 0 || loadfactor > 1)
            throw new IllegalArgumentException();
        table = new Node[tableSizeFor(capacity)];
        this. loadfactor = loadfactor;
        this.capacity =capacity;
    }

    public MyMap(){
        init();
    }
    public void init(){
        table = new Node[16];
        capacity  = 16;

    }
    private class Node{
        Object key;
        Object value;
        Node next;
        public Node(Object key,Object value,Node next){
            this.key = key;
            this.value = value;
            this.next =next;
        }
        public Object getKey() {return key;}
        public Object getValue() {return value;}
        public void setValue(Object value){this.value = value;}
        public int hashCode(){
            return Objects.hash(key,value);
        }
        public boolean equals(Object key){
            if(key == null)
                return false;
            if(key instanceof Node){
                Node node = (Node)key;
                return Objects.equals(node.key,this.key) && Objects.equals(node.value,this.value);
            }else return false;
        }
    }
    static int tableSizeFor(int cap){
        int i = 0;
        while(cap >>>1 >=0){
            i++;
        }
        return 1>>> i;
    }

    static final int hash(Object key) {
        int k = key.hashCode();
        return key==null? 0 : (k >>> 16) ^ k;
    }


    @Override
    public Object put(Object key, Object value) {
        Node willInsert = new Node(key,value,null);
        int index = hash(key) & (capacity -1);
        Node[] tab = table;
        if(tab[index] == null){
            tab[index] = willInsert;
            size++;

        }else {
            Node var = tab[index];
            while(true){
                if(var.getKey() == key || Objects.equals(var.getKey(),key)){//这个节点与插入的key相等
                    var.setValue(value);
                    break;
                }else if(var.next == null){//链表到终点了
                    var.next = willInsert;
                    size++;
                    break;
                }else var = var.next;
            }
        }

        if(loadfactor * capacity < size){
            resize();
        }
        return willInsert;

    }

    private void resize(){
        if(capacity >= 1<<30){
            return;
        }
        int newCapacity = capacity << 1;
        Node[] oldTab = table,
                newTable = new Node[newCapacity];

        for(int i =0; i<capacity;i++){
            if(oldTab[i] == null)
                continue;
            Node loHead = null,hiHead = null;
            Node node = oldTab[i];
            while(node != null){
                if((hash(node.key) & newCapacity) == 0){
                    if(loHead == null)//头
                        loHead = node;
                    else loHead.next = node;//不是头，往后放
                }else {
                    if(hiHead == null)//头
                        hiHead = node;
                    else hiHead.next = node;//不是头，往后放
                }
                node = node.next;
            }
            newTable[i] = loHead;
            newTable[i*2] = hiHead;

        }

        table = newTable;
        capacity = table.length;
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public Object get(Object key) {
        return null;
    }



    @Override
    public Object remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set keySet() {
        return null;
    }

    @Override
    public Collection values() {
        return null;
    }

    @Override
    public Set<Entry> entrySet() {
        return null;
    }
}

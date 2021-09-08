package 数据结构与算法.algorithm.linear;

import java.util.Iterator;

public class TwoWayLinkList<T> implements Iterable<T>{
    //首结点
    private Node head;
    //最后一个结点
    private Node last;
    //链表的长度
    private int N;


    //结点类
    private class Node{
        public Node(T item,Node pre,Node next){
            this.item = item;
            this.pre = pre;
            this.next = next;
        }

        //存储数据
        public T item;
        //指向上一个结点
        public Node pre;
        //指向下一个结点
        public Node next;

    }

    public TwoWayLinkList(){
       //初始化头结点和尾结点
        this.head = new Node(null,null,null);
        this.last = null;
       //初始化元素个数
        this.N = 0;

    }

    //清空链表
    public void clear(){
        head.next = null;
        N = 0;

    }

    //获取链表的长度
    public int length(){
        return N;
    }

    //判断链表是否为空
    public boolean isEmpty(){
        return N == 0;
    }

    //获取第一个元素
    public T getFirst(){
        if(isEmpty()){
            return null;
        }
        return head.next.item;
    }

    //获取最后一个元素
    public T getLast(){
        if(isEmpty()){
            return null;
        }
        return last.item;
    }

    //插入元素t
    public void insert(T t){
        //如果链表为空
        if(isEmpty()) {
            //创建新结点
            Node newNode = new Node(t, head, null);
            //让新结点称为尾结点
            last = newNode;
            //让头结点指向尾结点
            head.next = last;
        }else {
            //如果链表不为空
            Node oldNode = last;
            //创建新结点
            Node newNode = new Node(t, oldNode, null);
            //让当前的尾结点指向新结点
            oldNode.next = newNode;
            //让新结点成为尾结点
            last = newNode;
        }
            //让元素个数+1
            N++;
    }



    //向指定位置i插入元素t
    public void insert(int i,T t){
        Node preNode = head;
        //找到i位置的前一个结点
        for(int index = 0; index < i; index++){
            preNode = preNode.next;
        }

        //找到i位置的结点
        Node currNode = preNode.next;
        //创建新结点
        Node newNode = new Node(t,preNode,currNode);
        //让i位置的前一个结点的下一个节点变为新结点
        preNode.next = newNode;
        //让i位置的前一个结点变为新结点
        currNode.pre = newNode;
        //元素个数+1
        N++;

    }

    //获取指定位置i处的元素
    public T get (int i){
        Node n = head.next;
        for(int index = 0;index < i;index++){
            n = n.next;
        }
        return n.item;
    }

    //找到元素t在链表中第一次出现的位置
    public int indexOf(T t){
        Node n = head;
        for(int index = 0;n.next != null;index++){
            n = n.next;
            if(n.item.equals(t)){
                return index;
            }
        }
        return -1;

    }

    //删除位置i处的元素，并返回该元素
    public T remove(int i){
        //找到i位置的前一个结点
        Node preNode = head;
        for(int index = 0;index < i;index++){
            preNode = preNode.next;
        }
        //找到i位置的结点
        Node currNode = preNode.next;
        //找到i位置的下一个结点
        Node nextNode = currNode.next;
        //让i位置的前一个结点的下一个结点变为i位置的下一个结点
        preNode.next = nextNode;
        //让i位置的下一个结点的上一个结点变为i位置的前一个结点
        nextNode.pre = preNode;
        //元素个数-1
        N++;
        return currNode.item;
    }

    private class TIterator implements Iterator{

        private Node n = head;

        public TIterator(){
            this.n =head;
        }

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public Object next() {
            n = n.next;
            return n.item;
        }

    }


    @Override
    public Iterator<T> iterator() {
        return new TIterator();
    }

}


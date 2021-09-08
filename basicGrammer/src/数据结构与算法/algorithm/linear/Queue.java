package 数据结构与算法.algorithm.linear;

import java.util.Iterator;

public class Queue<T> implements Iterable<T>{
    private Node head;
    private Node last;
    private int N;

    public Queue(){
        this.head = new Node(null,null);
        this.last = null;
        this.N = 0;
    }

    private class Node{
        private T item;
        private Node next;

        public Node(T item,Node next){
            this.item = item;
            this.next = next;
        }
    }

    //获取队列的大小
    public int getSize(){
        return N;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return N == 0;
    }

    //进入队列
    public void enqueue(T t){
        if(isEmpty()){
            //当前尾结点last为null
            Node newNode = new Node(t, null);
            last = newNode;
            head.next = last;
        }else{
            //当前尾结点不为null
            Node oldLast = last;
            Node newNode = new Node(t, null);
            last = newNode;
            oldLast.next = newNode;
        }
        //元素个数+1
        N++;
    }

    //出队列
    public T dequeue(){
        //判断是否为空，如果为空的话，返回null
        if(isEmpty()){
            return null;
        }
        //如果不为空，让头结点指向第一个结点的下一个结点，返回原来的第一个结点
        Node oldFirst = head.next;
        head.next = oldFirst.next;
        N--;

        //因为出队列其实是在删除元素，因此如果队列中的元素被删除完了，需要重置last=null;
        if(isEmpty()){
            last = null;
        }
        return oldFirst.item;
    }

    private class QIterator implements Iterator{
        Node n = head;

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
        return new QIterator();
    }

}

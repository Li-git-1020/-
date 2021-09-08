package 数据结构与算法.algorithm.linear;

import java.util.Iterator;

public class Stack<T> implements Iterable<T>{

    private Node head;
    private int N;

    public Stack(){
        this.head = new Node(null,null);
        this.N = 0;
    }


    public class Node{
        private T item;
        private Node next;

        public Node(T item,Node next){
            this.item = item;
            this.next = next;
        }
    }

    //获取栈的大小
    public int size(){
        return N;
    }

    //判断栈是否为空
    public boolean isEmpty(){
        return N == 0;
    }

    //入栈
    public void push(T t){
        //找出第一个结点
        Node first = head.next;
        //新建一个结点，让头结点指向新结点，新结点指向第一个结点
        Node newNode = new Node(t,first);
        //让首结点指向新结点
        head.next = newNode;
        //元素个数+1
        N++;
    }

    //出栈
    public T pop(){
        //找到首结点指向的第一个结点
        Node oldFirst = head.next;
        if(oldFirst == null){
            return null;
        }
        //让首结点指向第一个结点的下一个结点
        head.next = oldFirst.next;
        //元素个数-1
        N--;
        return oldFirst.item;
    }

    private class SIterator implements Iterator{
        private Node n;
        public SIterator(){
            this.n = head;
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
    public Iterator iterator() {
        return new SIterator();
    }

}

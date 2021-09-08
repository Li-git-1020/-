package 数据结构与算法.algorithm.linear;

import java.util.Iterator;

public class SequenceList<T> implements Iterable<T>{
    //存储元素数组
    private T[] elss;
    //记录当前顺序表中的元素个数
    private int N;

    //构造方法
    public SequenceList(int capacity){
        //初始化数组
        this.elss = (T[])new Object[capacity];

        //初始化长度
        this.N = 0;
    }

    //将一个线性表置为空表
    public void clear(){
        this.N = 0;
    }

    //判断当前线性表是否为空表
    public boolean isEmpty(){
        return N == 0;
    }

    //获取线性表的长度
    public int length(){
        return N;
    }

    //获取指定位置的元素
    public T get(int i){
        return elss[i];
    }

    //向线性表中添加元素t
    public void insert(T t){
        if(N == elss.length){
            resize(2* elss.length);
        }
        elss[N++] = t;

    }

    //在i元素处插入元素t
    public void insert(int i,T t){
        if(N == elss.length){
            resize(2* elss.length);
        }
        //先把i索引处的元素及其后面的元素依次向后移动一位
        for (int index = N; index > i; index--) {
            elss[index] = elss[index-1];
        }

        //再把t元素放到i索引处即可
        elss[i] = t;

        //元素个数+1
        N++;
    }

    //删除指定位置i处的元素，并返回该元素
    public T remove(int i){
        //记录索引i处的值
        T current = elss[i];
        //索引i后面元素依次向前移动一位即可
        for (int index = i; index < N; index++) {
            elss[index] = elss[index+1];
        }
        //元素个数减一
        N--;

        if(N < elss.length/4){
            resize(elss.length/2);
        }
        return current;
    }

    //查找元素第一次出现的位置
    public int indexOf(T t){
        for (int i = 0; i < N; i++) {
            if(elss[i].equals(t)){
                return i;
            }

        }
        return -1;
    }

    //根据参数newSize，重置else的大小
    public void resize(int newSize){
        //定义一个临时数组，指向原数组
        T[] temp = elss;
        //创建新数组
        elss = (T[])new Object[newSize];
        //把原数组的数据拷贝到新数组即可

        for (int i = 0; i < N; i++) {
            elss[i] = temp[i];

        }
    }

    private class SIterator implements Iterator{

        private int cursor;

        public SIterator() {
            this.cursor = 0;
        }

        @Override
        public boolean hasNext() {
            return cursor < N;
        }

        @Override
        public Object next() {
            return elss[cursor++];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }
}

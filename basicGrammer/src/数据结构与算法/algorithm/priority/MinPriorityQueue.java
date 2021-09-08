package 数据结构与算法.algorithm.priority;

public class MinPriorityQueue<T extends Comparable<T>> {
    //获取堆中的元素
    T[] items;
    //记录堆中元素的个数
    private int N;

    public MinPriorityQueue(int capacity) {
        this.items = (T[]) new Comparable[capacity+1];
        this.N = 0;
    }

    //获取队列中元素的个数
    public int size() {
        return N;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return N == 0;
    }

    //判断堆中索引i处的元素是否小于索引j处的元素
    private boolean less(int i, int j){
        return items[i].compareTo(items[j])<0;
    }

    //交换堆中的i索引和j索引处的值
    private void exch(int i, int j){
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    //往堆中插入一个元素
    public void insert(T t){
        items[++N] = t;
        swim(N);
    }

    //删除堆中最小的元素，并返回这个最小元素
    public T delMin(){
        T min = items[1];
        exch(1,N);
        N--;
        sink(1);
        return min;
    }

    //使用上浮算法，使索引k处的元素能在堆中处于一个正确的位置
    public void swim(int k){
        //通过循环比较当前结点和其父结点的大小
        while(k>1){
            if(less(k,k/2)){
                exch(k,k/2);
                k = k/2;
            }
        }

    }

    //使用下沉算法，使索引k处的元素能在堆中处于一个正确的位置
    public void sink(int k){
        //通过循环比较当前结点和其子结点的较小值
        int min;
        while(2*k <= N){
            //找到子结点的较小值
            if(2*k+1 <= N){
                if(less(k*2,k*2+1)){
                    min = k*2;
                }else{
                    min = k*2 + 1;
                }
            }else{
                min = k*2;
            }
            //判断当前结点和较小值的大小
            if(less(k,min)){
                break;
            }
            exch(k,min);
            k = min;
        }


    }


}

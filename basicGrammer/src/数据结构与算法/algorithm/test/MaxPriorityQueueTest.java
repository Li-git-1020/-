package 数据结构与算法.algorithm.test;

import 数据结构与算法.algorithm.priority.MaxPriorityQueue;

public class MaxPriorityQueueTest {
    public static void main(String[] args) {
        //创建优先队列
        MaxPriorityQueue<String> queue = new MaxPriorityQueue<>(10);
        //在队列中存储元素
        queue.insert("A");
        queue.insert("B");
        queue.insert("C");
        queue.insert("D");
        queue.insert("E");
        queue.insert("F");
        queue.insert("G");
        //通过循环从队列中获取最大元素
        while(!queue.isEmpty()){
            String max = queue.dekMax();
            System.out.print(max+" ");
        }
    }
}

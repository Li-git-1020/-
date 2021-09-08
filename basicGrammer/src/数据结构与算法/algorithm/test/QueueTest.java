package 数据结构与算法.algorithm.test;

import 数据结构与算法.algorithm.linear.Queue;

public class QueueTest {
    public static void main(String[] args) {
        Queue<String> queue = new Queue<String>();

        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");

        for (String q : queue){
            System.out.println(q);
        }

        System.out.println("-----------------------");
        String result = queue.dequeue();
        System.out.println(result);
        System.out.println("剩余元素大小为：" + queue.getSize());
    }
}

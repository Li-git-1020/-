package 数据结构与算法.algorithm.test;

import 数据结构与算法.algorithm.priority.IndexMinPriorityQueue;

public class IndexMinpriorityQueueTest {
    public static void main(String[] args) {
        //创建索引最小优先队列对象
        IndexMinPriorityQueue<String> queue = new IndexMinPriorityQueue<>(10);
        //往队列中添加元素
        queue.insert(0,"A");
        queue.insert(1,"C");
        queue.insert(2,"F");
        //测试修改
        queue.changeItem(2,"B");
        //测试删除
        while(!queue.isEmpty()){
            int index = queue.delMin();
            System.out.print(index + " ");
        }
    }
}

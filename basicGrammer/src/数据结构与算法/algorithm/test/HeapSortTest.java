package 数据结构与算法.algorithm.test;

import 数据结构与算法.algorithm.heap.HeapSort;

import java.util.Arrays;

public class HeapSortTest {
    public static void main(String[] args) {
        //待排序数组
        String[] arr = {"s", "o", "r", "t", "e", "x", "a", "m", "p", "l", "e"};
        //通过HeapSort对数组中的元素进行排序
        HeapSort.sort(arr);
        //打印排序后数组中的元素
        System.out.println(Arrays.toString(arr));
    }
}

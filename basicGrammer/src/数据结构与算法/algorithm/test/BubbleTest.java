package 数据结构与算法.algorithm.test;

import 数据结构与算法.algorithm.sort.Bubble;

import java.util.Arrays;

public class BubbleTest  {
    public static void main(String[] args) {
        Integer[] arr = {4,5,6,3,2,1};
        Bubble.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

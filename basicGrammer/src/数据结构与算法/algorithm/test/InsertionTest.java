package 数据结构与算法.algorithm.test;

import 数据结构与算法.algorithm.sort.Insertion;

import java.util.Arrays;

public class InsertionTest {
    public static void main(String[] args) {
        Integer[] a = {4,3,2,10,12,1,5,6};

        Insertion.sort(a);
        System.out.println(Arrays.toString(a));
    }



}

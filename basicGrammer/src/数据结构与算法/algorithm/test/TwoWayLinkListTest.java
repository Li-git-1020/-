package 数据结构与算法.algorithm.test;

import 数据结构与算法.algorithm.linear.TwoWayLinkList;

public class TwoWayLinkListTest {
    public static void main(String[] args) {
        //创建双向链表对象
        TwoWayLinkList<String> s1 = new TwoWayLinkList<>();
        //测试插入
        s1.insert("姚明");
        s1.insert("科比");
        s1.insert("麦迪");
        s1.insert(1,"詹姆斯");

        for(String s : s1){
            System.out.println(s);
        }

        System.out.println("------------------------------------------");
        System.out.println("第一个元素是："+s1.getFirst());
        System.out.println(s1.get(0));
        System.out.println("最后一个元素是："+s1.getLast());
        System.out.println(s1.get(3));


        System.out.println("------------------------------------------");
        //测试获取
        String getResult = s1.get(1);
        System.out.println("获取索引1处的结果为：" + getResult);

        //测试删除
        String removeResult = s1.remove(0);
        System.out.println("删除的元素是：" + removeResult);
        //测试清空
        s1.clear();
        System.out.println("清空后的线性表中的元素个数为：" + s1.length());
    }
}

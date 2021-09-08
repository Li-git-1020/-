package 数据结构与算法.algorithm.test;

import 数据结构与算法.algorithm.symbol.OrderSymbolTable;

public class OrderSymbolTableTest {
    public static void main(String[] args) {
        OrderSymbolTable<Integer,String> table = new OrderSymbolTable();
        table.put(1,"张三");
        table.put(4,"李四");
        table.put(6,"赵六");
        table.put(7,"田七");

        table.put(2,"马超");

    }
}

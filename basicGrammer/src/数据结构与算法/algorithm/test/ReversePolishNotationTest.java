package 数据结构与算法.algorithm.test;

import 数据结构与算法.algorithm.linear.Stack;

public class ReversePolishNotationTest {
    public static void main(String[] args) {
        //中缀表达式 3*（17-5）+18/6 的逆波兰表达式如下
        String[] notation = {"3", "17", "15", "-", "*", "18", "6", "/", "+"};
        int result = calculate(notation);
        System.out.println("逆波兰表达式的结果为： "+result);
    }

    public static int calculate(String[] notation){
        //1.定义一个栈，用来存储操作数
        Stack<Integer> operands = new Stack<>();
        //2.从左往右遍历逆波兰表达式，得到每一个元素
        Integer o1;
        Integer o2;
        Integer result;
        for(int i = 0;i < notation.length;i++){
            //3.判断当前元素是运算符还是操作数
            switch (notation[i]) {
                //4.运算符，从栈中弹出两个操作数，完成运算，把运算完的结果再压入栈中
                case "+":
                    o1 = operands.pop();
                    o2 = operands.pop();
                    result = o2 + o1;
                    operands.push(result);
                    break;
                case "-":
                    o1 = operands.pop();
                    o2 = operands.pop();
                    result = o2 - o1;
                    operands.push(result);
                    break;
                case "*":
                    o1 = operands.pop();
                    o2 = operands.pop();
                    result = o2 * o1;
                    operands.push(result);
                    break;
                case "/":
                    o1 = operands.pop();
                    o2 = operands.pop();
                    result = o2 / o1;
                    operands.push(result);
                    break;
                //5。操作数，把操作数压入到栈中
                default:
                    operands.push(Integer.parseInt(notation[i]));
                    break;
            }
        }

        //6.得到栈中最后一个元素，就是逆波兰表达式的结果
        result = operands.pop();
        return result;
    }
}

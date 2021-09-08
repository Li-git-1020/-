package 数据结构与算法.algorithm.test;

public class JosephTest {
    public static void main(String[] args) {
        //解决约瑟夫问题
        //记录首结点
        Node<Integer> first = null;
        //记录前一个结点
        Node<Integer> pre = null;

        //1.构建循环链表，包含41个结点分别存储1-41之间的值
        for(int i=1;i <= 41;i++){
            //如果是第一个结点
            if(i == 1){
                first = new Node<>(i,null);
                pre = first;
                continue;
            }
            //如果不是第一个结点
            Node<Integer> newNode = new Node<Integer>(i,null);
            pre.next = newNode;
            pre = newNode;

            //如果是最后一个结点,那么需要让最后一个结点变为first，变为循环链表了
            if(i == 41){
                pre.next = first;
            }

        }

        //2.需要count计数器，模拟报数
        int count = 0;
        //3.遍历循环链表
        //记录每次遍历拿到的结点，默认从首结点开始
        Node n = first;
        //记录前一个结点
        Node beforeNode = null;

        while(n.next != n){
            //模拟报数
            count++;
            //判断当前报数是不为3
            if(count == 3){
                //如果是3，删除当前结点，即当前结点的上一结点的下一结点变为当前结点的下一结点
                beforeNode.next = n.next;
                //输出当前删掉的结点
                System.out.print(n.item+" ");
                //移动当前结点
                n = n.next;
                count = 0;
            }else{
                //当count不是3的时候
                beforeNode = n;
                n = n.next;
            }
        }
        //打印出最后一个结点
        System.out.print(n.item);
    }

    //结点类
    private static class Node<T>{
        //存储数据
        T item;
        //下一个结点
        Node next;
        //构造方法
        public Node(T item, Node next){
            this.item = item;
            this.next = next;
        }
    }
}

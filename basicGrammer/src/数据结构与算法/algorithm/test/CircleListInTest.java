package 数据结构与算法.algorithm.test;

public class CircleListInTest {

    public static void main(String[] args) {
        //创建结点
        Node<String> first = new Node<String>("aa",null);
        Node<String> second = new Node<String>("bb",null);
        Node<String> third = new Node<String>("cc",null);
        Node<String> fourth = new Node<String>("dd",null);
        Node<String> fifth = new Node<String>("ee",null);
        Node<String> sixth = new Node<String>("ff",null);
        Node<String> seventh = new Node<String>("gg",null);

        //完成结点之间的指向
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;
        //产生环
        seventh.next = third;


        //查找环的入口结点
        Node entrance = getEntrance(first);
        System.out.println("first链表中是否有环："+entrance.item);

    }

    /*
    当快慢指针相遇时，我们可以判断链表中有环，这是重新设定一个新指针指向链表的起点，且步长与满指针一样为一，则慢指针与新指针相遇的地方就是环的入口。
     */
    public static Node getEntrance(Node<String> first){
        //定义快慢指针
        Node<String> fast = first;
        Node<String> slow = first;
        Node<String> temp = null;
        //遍历链表，先找到环（快慢指针相遇），准备一个临时指针，指向链表的首结点，继续遍历，直到慢指针和临时指针相遇，那么相遇时所指向的结点就是环的入口
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            //判断快慢指针是否相遇
            if(fast.equals(slow)){
                temp = first;
                continue;
            }
            //让临时指针结点变换
            if(temp != null){
                temp = temp.next;
                if(temp.equals(slow)){
                    break;
                }
            }
        }
        return temp;
    }

    //结点类
    private static class Node<T>{
        //存储数据
        T item;
        //下一个结点
        Node next;

        public Node(T item,Node next){
            this.item = item;
            this.next = next;
        }
    }
}

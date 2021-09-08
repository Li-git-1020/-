package 数据结构与算法.algorithm.symbol;

public class OrderSymbolTable<Key extends Comparable<Key>, Value> {
    //头结点
    private Node head;
    //用来计数
    private int N;

    public OrderSymbolTable(){
        this.head = new Node(null,null,null);
        this.N = 0;
    }

    //定义结点类
    private class Node{
        //键
        private Node next;
        //值
        private Key key;
        //下一个结点
        private Value value;

        public Node(Key key,Value value,Node next){
            this.key =key;
            this.value = value;
            this.next = next;
        }
    }

    //获取符号表中键值的个数
    public int size(){
        return N;
    }

    //往符号表中插入键值对
    public void put(Key key,Value value){
        //定义两个结点，用来记录当前结点和当前节点的上一结点
        Node curr = head.next;
        Node pre = head;
        //遍历符号表，找到当前结点和当前结点的下一个结点
        while(curr!=null && key.compareTo(curr.key)>0){
            pre = curr;
            curr = curr.next;
        }
        //如果key等于当前结点的key值则替换value
        if(curr!=null && key.compareTo(curr.key)==0){
            curr.value = value;
            return;
        }

        //若key不等于当前结点的key值，则新建一个结点，该结点指向当前结点，当前的上一个结点指向新结点
        Node newNode = new Node(key,value,curr);
        pre.next = newNode;
        //元素个数+1
        N++;


    }

    //删除符号表中键为key的键值对
    public void delete(Key key){
        //找到键为key的结点，把该节点从链表中删除
        Node n = head;
        while(n.next != null){
            //判断n结点的下一个节点的键是否为key，如果是，就删除该节点
            if(n.next.key.equals(key)){
                n.next = n.next.next;
                N--;
                return;
            }

            //若不是，变动n
            n = n.next;
        }
    }

    //从符号表中获取key对应的值
    public Value get(Key key){
        //找到键为key的结点，获取道该节点的value值
        Node n = head;
        while(n.next != null){
            n = n.next;
            if(n.key.equals(key)){
                return n.value;
            }
        }
        return null;
    }
}

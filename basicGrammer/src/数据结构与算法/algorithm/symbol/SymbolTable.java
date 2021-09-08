package 数据结构与算法.algorithm.symbol;

public class SymbolTable<Key, Value> {
    //头结点
    private Node head;
    //用来计数
    private int N;

    public SymbolTable(){
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
        Node n = head;
        //符号表中已经存在了键为key的键值对，那么只需要找到该结点，替换值为value即可
        while(n.next != null){
            //变换n
            n = n.next;
            //判断n结点的存储的键是否为key，如果是，则替换n结点的值
            if(n.key.equals(key)){
                n.value = value;
                return;
            }
        }
        Node oldFirst = head.next;
        //如果符号表中不存在键为key的键值对，只需要创建新的结点，保存要插入的键值对，把新结点插入到链表的表头 head.next=新结点即可
        Node newNode = new Node(key, value, oldFirst);
        head.next = newNode;
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

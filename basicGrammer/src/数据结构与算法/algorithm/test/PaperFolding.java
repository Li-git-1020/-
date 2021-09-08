package 数据结构与算法.algorithm.test;

import 数据结构与算法.algorithm.linear.Queue;

public class PaperFolding {
    public static void main(String[] args) {

        //遍历折纸过程，产生树
        Node<String> tree = createTree(2);
        //遍历树，打印每个结点
        printTree(tree);
    }

    //通过模拟对折N次纸，产生树
    public static Node<String> createTree(int N) {
        //定义根节点
        Node<String> root = null;

        for (int i = 0; i < N; i++) {
            //1.当前是第一次对折
            if (i == 0) {
                root = new Node<String>("down", null, null);
                continue;
            }
            //2.当前不是第一次对折
            //定义一个辅助队列，通过层序遍历的思想，找到叶子节点，叶子节点添加结点
            Queue<Node> queue = new Queue<Node>();
            queue.enqueue(root);
            //循环遍历队列
            while (!queue.isEmpty()) {
                //从队列中弹出一个结点
                Node temp = queue.dequeue();
                //如果有左子节点，则把左子节点放入到队列中
                if (temp.left != null) {
                    queue.enqueue(temp.left);
                }
                //如果有右子节点，则把右子节点放入到队列中
                if (temp.right != null) {
                    queue.enqueue(temp.right);
                }

                //如果同时没有左子节点和右子节点，那么证明该结点是叶子结点，只需要给该结点添加左子结点和右子节点即可
                if (temp.left == null && temp.right == null) {
                    temp.left = new Node<String>("down", null, null);
                    temp.right = new Node<String>("up", null, null);
                }
            }
        }

        return root;
    }

    //打印树中每个结点到控制台
    public static void printTree(Node<String> root) {
        //需要使用层序遍历来完成
        if (root == null) {
            return;
        }
        //打印左子树的每个结点
        if (root.left != null) {
            printTree(root.left);
        }
        //打印当前结点
        System.out.print(root.item + " ");
        //打印右子树的每个结点
        if(root.right!=null){
            printTree(root.right);
        }
    }

    //节点类
    private static class Node<T> {
        public T item; //存储元素
        public Node left;
        public Node right;

        public Node(T item, Node left, Node right) {
            this.item = item;
            this.left = left;
            this.right = right;
        }
    }

}

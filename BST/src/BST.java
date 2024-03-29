import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author :DengSiYuan
 * @date :2019/9/8 14:42
 * @desc : 二分搜索树
 */
public class BST<E extends Comparable<E>> {

    private class Node{
        public E e;
        public Node left,right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    /**
     *向二分搜索树中添加新的元素e
     * @param e
     */
    public void add(E e){
        root = add(root,e);
    }

    /**
     * 向以node为根的二分搜索树插入元素e，递归算法
     * 返回插入新节点后二分搜索树的根
     * @param node
     * @param e
     * @return
     */
    private Node add(Node node,E e){
        if (node == null){
            size++;
            return new Node(e);
        }
        if(e.compareTo(node.e) < 0){
            node.left = add(node.left,e);
        }else if (e.compareTo(node.e) > 0){
            node.right = add(node.right,e);
        }
        return node;
    }

    /**
     * 看二分搜索树中是否包含元素e
     * @param e
     * @return
     */
    public boolean contains(E e){
        return contains(root,e);
    }

    /**
     * 看以node为根的二分搜索树中是否包含元素e，递归算法
     * @param node
     * @param e
     * @return
     */
    private boolean contains(Node node,E e){
        if (node == null){
            return false;
        }
        if (e.compareTo(node.e) == 0){
            return true;
        }else if(e.compareTo(node.e) < 0){
            return contains(node.left,e);
        }else {
            return contains(node.right,e);
        }
    }


    /**
     * 二分搜索树的前序遍历
     */
    public void preOrder(){
        preOrder(root);
    }


    /**
     * 前序遍历以node为根的二分搜索树，递归算法
     * @param node
     */
    private void preOrder(Node node){
        if (node != null){
            System.out.println(node.e);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * 前序遍历的非递归
     */
    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node current = stack.pop();
            System.out.println(current.e);
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
    }

    /**
     * 二分搜索树的中序遍历
     */
    public void inOrder(){
        inOrder(root);
    }


    /**
     * 中序遍历以node为根的二分搜索树，递归算法
     * @param node
     */
    private void inOrder(Node node){
        if (node != null){
            inOrder(node.left);
            System.out.println(node.e);
            inOrder(node.right);
        }
    }

    /**
     * 二分搜索树的后序遍历
     */
    public void postOrder(){
        postOrder(root);
    }


    /**
     * 后序遍历以node为根的二分搜索树，递归算法
     * @param node
     */
    private void postOrder(Node node){
        if (node != null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.e);
        }
    }


    /**
     * 层序遍历
     */
    public void leverOrder(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node current = queue.remove();
            System.out.println(current.e);
            if (current.left != null){
                queue.add(current.left);
            }
            if (current.right != null){
                queue.add(current.right);
            }
        }
    }

    /**
     * 寻找最小节点
     * @return 最小节点的数值
     */
    public E minimum(){
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty!!");
        }
        return minimum(root).e;
    }

    private Node minimum(Node node){
        if (node.left == null){
            return node;
        }
        return minimum(node.left);
    }

    /**
     * 寻找最小节点
     * @return 最小节点的数值
     */
    public E maximum(){
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty!!");
        }
        return maximum(root).e;
    }

    private Node maximum(Node node){
        if (node.right == null){
            return node;
        }
        return maximum(node.right);
    }

    /**
     * 从二分搜索树中删除最小值所在节点，返回最小值
     * @return
     */
    public E removeMin(){
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    /**
     * 删除以node为根的二分搜索树中的最小节点
     * 返回删除节点后新的二分搜索树的根
     * @param node
     * @return
     */
    private Node removeMin(Node node){
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 从二分搜索树中删除最小值所在节点，返回最小值
     * @return
     */
    public E removeMax(){
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    /**
     * 删除以node为根的二分搜索树中的最小节点
     * 返回删除节点后新的二分搜索书的根
     * @param node
     * @return
     */
    private Node removeMax(Node node){
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }


    /**
     * 从二叉树中删除元素为e的节点
     * @param e 要删除的节点
     */
    public void remove(E e){
        root = remove(root,e);
    }

    private Node remove(Node node,E e){
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left,e);
            return node;
        }else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right,e);
            return node;
        }else {
            //待删除节点右子树为空的情况
            if (node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            //待删除节点左子树为空的情况
            if (node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            //待删除结点左右子树均不为空的情况
            //找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
            //用这个节点顶替待删除接待节点的位置
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        generateBSTString(root,0,result);
        return result.toString();
    }

    /**
     * 遍历打印二叉树
     * @param node
     * @param depth
     * @param result
     */
    private void generateBSTString(Node node,int depth,StringBuilder result){
        if (node == null){
            result.append(generateDepthString(depth) + "null\n");
            return;
        }
        result.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left,depth + 1 ,result);
        generateBSTString(node.right,depth + 1,result);
    }

    /**
     * 表现层次数的符号输出
     * @param depth
     * @return
     */
    private String generateDepthString(int depth) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            result.append("--");
        }
        return result.toString();
    }

}

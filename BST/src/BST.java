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


    private void generateBSTString(Node node,int depth,StringBuilder result){
        if (node == null){
            result.append(generateDepthString(depth) + "null\n");
            return;
        }
        result.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left,depth + 1 ,result);
        generateBSTString(node.right,depth + 1,result);
    }

    private String generateDepthString(int depth) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            result.append("--");
        }
        return result.toString();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        generateBSTString(root,0,result);
        return result.toString();
    }
}

/**
 * @author :DengSiYuan
 * @date :2019/9/8 20:46
 * @desc : 二分搜索树检测
 */
public class BSTMain {

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        for (int i = 0; i < 5; i++) {
            bst.add(i);
        }
        System.out.println(bst);
    }

}

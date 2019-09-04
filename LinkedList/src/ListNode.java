/**
 * @author :DengSiYuan
 * @date :2019/9/4 16:50
 * @desc : 结点
 */
public class ListNode {

    public int val;
    public ListNode next;
    public ListNode(int x){
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

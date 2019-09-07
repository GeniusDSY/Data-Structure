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

    public ListNode(int[] arr){
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("数组不能为空！！");
        }
        this.val = arr[0];
        ListNode current = this;
        for (int i = 0; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode current = this;
        while (current != null){
            sb.append(current.val + "->");
            current = current.next;
        }
        sb.append("NULL");
        return sb.toString();
    }
}

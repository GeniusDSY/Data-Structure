/**
 * @author :DengSiYuan
 * @date :2019/9/4 16:48
 * @desc : 输入: 1->2->6->3->4->5->6, val = 6
 *         输出: 1->2->3->4->5
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {1,2,6,3,4,5,6};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        System.out.println(removeElements(head, 6));

    }

    public static ListNode removeElements(ListNode head, int val){
        if(head==null) {
            return null;
        }
        head.next=removeElements(head.next, val);
        return head.val==val ? head.next:head;
    }
}

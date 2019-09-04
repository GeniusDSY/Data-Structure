/**
 * @author :DengSiYuan
 * @date :2019/9/4 16:48
 * @desc : 输入: 1->2->6->3->4->5->6, val = 6
 *         输出: 1->2->3->4->5
 */
public class Solution {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(6);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(4);
        listNode.next.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next.next = new ListNode(6);
        System.out.println(listNode);
        System.out.println(removeElements(listNode, 6));

    }

    public static ListNode removeElements(ListNode head, int val){
        if(head==null) {
            return null;
        }
        head.next=removeElements(head.next, val);
        return head.val==val ? head.next:head;
    }
}

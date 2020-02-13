package list;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 */
public class RemoveNthFromEnd {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        List list = new List();
        ListNode head = null;
        for(int i=0;i<nums.length;i++){
            head = list.add(new ListNode(nums[i]));
        }
        ListNode before = head;
        while(before.next!=null){
            System.out.print(before.val+"->");
            before = before.next;
        }
        System.out.println(before.val);
        ListNode after = removeNthFromEnd(head, 2);
        while(after.next!=null){
            System.out.print(after.val+"->");
            after = after.next;
        }
        System.out.print(after.val);
    }

    /**
     * 非常明显的快慢指针的解法
     *
     * 先将快指针移动n位即可，如果移动之后为null，则说明删除的是第一个，则只需要将头指针右移一位
     * 否则则开始同时移动两个指针，直到快指针到尾部
     * 然后将慢指针指向下一个的下一个
     * 返回头指针即可
     * @param head
     * @param n
     * @return
     */
    private  static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        int i = 0;
        while(i<n){
            p2 = p2.next;
            i++;
        }
        if(p2==null){
            return head.next;
        }
        while(p2.next!=null){
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p1.next.next;
        return head;
    }
}

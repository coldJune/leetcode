package list;




public class List{
    ListNode head,tail;

    public ListNode add(ListNode node){
        if(head == null){
            head = node;
            tail = head;
        }else{
            tail.next=node;
            tail = tail.next;
        }
        return head;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

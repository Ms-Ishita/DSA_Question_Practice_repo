public class reverse_node_in_k_group {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode groupPrevious = dummy;

        while (true) {
            ListNode kth = groupPrevious;
            for (int i = 0; i < k && kth != null; i++) {
                kth = kth.next;
            }
            if (kth == null) {
                break;
            }

            ListNode groupNext = kth.next;
            ListNode previous = groupNext;
            ListNode current = groupPrevious.next;

            while (current != groupNext) {
                ListNode next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }

            ListNode oldGroupHead = groupPrevious.next;
            groupPrevious.next = kth;
            groupPrevious = oldGroupHead;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        reverse_node_in_k_group solution = new reverse_node_in_k_group();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        head = solution.reverseKGroup(head, 2);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}

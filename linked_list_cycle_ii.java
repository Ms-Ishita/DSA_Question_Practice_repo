public class linked_list_cycle_ii {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                ListNode current = head;
                while (current != slow) {
                    current = current.next;
                    slow = slow.next;
                }
                return current;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        linked_list_cycle_ii solution = new linked_list_cycle_ii();

        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;

        ListNode cycleStart = solution.detectCycle(head);
        if (cycleStart != null) {
            System.out.println("Cycle starts at node: " + cycleStart.val);
        } else {
            System.out.println("No cycle");
        }
    }
}

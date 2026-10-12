public class merge_k_sorted_list {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        java.util.PriorityQueue<ListNode> queue =
                new java.util.PriorityQueue<>((first, second) -> Integer.compare(first.val, second.val));

        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!queue.isEmpty()) {
            ListNode smallest = queue.poll();
            tail.next = smallest;
            tail = tail.next;

            if (smallest.next != null) {
                queue.offer(smallest.next);
            }
        }

        tail.next = null;
        return dummy.next;
    }

    public static void main(String[] args) {
        merge_k_sorted_list solution = new merge_k_sorted_list();

        ListNode first = new ListNode(1);
        first.next = new ListNode(4);
        first.next.next = new ListNode(5);

        ListNode second = new ListNode(1);
        second.next = new ListNode(3);
        second.next.next = new ListNode(4);

        ListNode third = new ListNode(2);
        third.next = new ListNode(6);

        ListNode[] lists = {first, second, third};
        ListNode result = solution.mergeKLists(lists);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}

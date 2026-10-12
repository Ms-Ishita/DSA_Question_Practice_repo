public class palindrome_linked_list {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = reverse(slow.next);
        ListNode firstHalf = head;
        ListNode currentSecond = secondHalf;
        boolean palindrome = true;

        while (currentSecond != null) {
            if (firstHalf.val != currentSecond.val) {
                palindrome = false;
                break;
            }
            firstHalf = firstHalf.next;
            currentSecond = currentSecond.next;
        }

        // Restore the list so the method does not leave it modified.
        slow.next = reverse(secondHalf);
        return palindrome;
    }

    private ListNode reverse(ListNode head) {
        ListNode previous = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    private static ListNode createList(int... values) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for (int value : values) {
            tail.next = new ListNode(value);
            tail = tail.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        palindrome_linked_list solution = new palindrome_linked_list();

        ListNode palindrome = createList(1, 2, 2, 1);
        ListNode notPalindrome = createList(1, 2, 3);

        System.out.println("1 -> 2 -> 2 -> 1: " + solution.isPalindrome(palindrome));
        System.out.println("1 -> 2 -> 3: " + solution.isPalindrome(notPalindrome));
    }
}

public class InsertGreatestCommonDivisors {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode curr = head;

        while (curr != null && curr.next != null) {
            int gcd = gcd(curr.val, curr.next.val);

            ListNode node = new ListNode(gcd);
            node.next = curr.next;
            curr.next = node;

            curr = node.next;
        }

        return head;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);

            if (head.next != null) {
                System.out.print(" -> ");
            }

            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        InsertGreatestCommonDivisors solution = new InsertGreatestCommonDivisors();

        ListNode head = new ListNode(18,
                new ListNode(6,
                        new ListNode(10,
                                new ListNode(3))));

        System.out.println("Original List:");
        printList(head);

        head = solution.insertGreatestCommonDivisors(head);

        System.out.println("Modified List:");
        printList(head);
    }
}
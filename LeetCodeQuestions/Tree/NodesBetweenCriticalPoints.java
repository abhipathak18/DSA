public class NodesBetweenCriticalPoints {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static int[] nodesBetweenCriticalPoints(ListNode head) {
        int minDist = Integer.MAX_VALUE;

        int firstCritical = -1;
        int lastCritical = -1;

        ListNode prev = head;
        ListNode curr = head.next;

        int index = 1;

        while (curr != null && curr.next != null) {

            // Check if current node is a critical point
            boolean isCritical =
                    (curr.val > prev.val && curr.val > curr.next.val) ||
                    (curr.val < prev.val && curr.val < curr.next.val);

            if (isCritical) {

                // First critical point
                if (firstCritical == -1) {
                    firstCritical = index;
                } 
                else {
                    // Distance from previous critical point
                    minDist = Math.min(minDist, index - lastCritical);
                }

                lastCritical = index;
            }

            prev = curr;
            curr = curr.next;
            index++;
        }

        // Fewer than 2 critical points
        if (firstCritical == -1 || firstCritical == lastCritical) {
            return new int[]{-1, -1};
        }

        // Maximum distance = last critical - first critical
        int maxDist = lastCritical - firstCritical;

        return new int[]{minDist, maxDist};
    }

    public static void main(String[] args) {

        // Example:
        // [5, 3, 1, 2, 5, 1, 2]

        ListNode head = new ListNode(5);
        head.next = new ListNode(3);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next = new ListNode(2);

        int[] result = nodesBetweenCriticalPoints(head);

        System.out.println("Minimum Distance: " + result[0]);
        System.out.println("Maximum Distance: " + result[1]);
    }
}
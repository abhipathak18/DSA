class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class DetectCycle {

    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        // Detect cycle using Floyd's Cycle Detection Algorithm
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {

                // Find the starting node of the cycle
                ListNode temp = head;

                while (temp != slow) {
                    temp = temp.next;
                    slow = slow.next;
                }

                return temp;
            }
        }

        return null;
    }

    // Driver Code
    public static void main(String[] args) {

/*
    3 -> 2 -> 0 -> -4
         ^         |
         |_________|
*/

        ListNode head = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(0);
        ListNode fourth = new ListNode(-4);

        head.next = second;
        second.next = third;
        third.next = fourth;

        // Create cycle: -4 -> 2
        fourth.next = second;

        DetectCycle obj = new DetectCycle();

        ListNode cycleStart = obj.detectCycle(head);

        if (cycleStart != null) {
            System.out.println("Cycle starts at node with value: " + cycleStart.val);
        } else {
            System.out.println("No cycle detected.");
        }
    }
}
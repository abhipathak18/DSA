// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        // Handle removing elements from the head of the list
        while (head != null && head.val == val) {
            head = head.next;
        }
        
        ListNode temp = head;
        ListNode prev = null;
        
        while (temp != null) {
            if (temp.val == val) {
                // Bypass the node with the target value
                if (prev != null) {
                    prev.next = temp.next;
                }
            } else {
                // Update prev only if the current node is kept
                prev = temp;
            }
            temp = temp.next;
        }
        return head;
    }

    // Main method to run and test the code in VS Code
    public static void main(String[] args) {
        RemoveElements solver = new RemoveElements();

        // Create a test linked list: 1 -> 2 -> 6 -> 3 -> 4 -> 5 -> 6
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);

        System.out.print("Original List: ");
        printList(head);

        // Remove all occurrences of 6
        head = solver.removeElements(head, 6);

        System.out.print("Modified List: ");
        printList(head);
    }

    // Helper method to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

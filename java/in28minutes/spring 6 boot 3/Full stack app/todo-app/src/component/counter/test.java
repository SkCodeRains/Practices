package component.counter;

// Java program to check if a linked list
// with loop is palindrome or not.
import java.util.*;

class test {

    /* Link list node */

    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        public SinglyLinkedListNode(int data) {
            this.data = data;
            this.next = null;
        }

        public SinglyLinkedListNode(int data, SinglyLinkedListNode next) {
            this.data = data;
            this.next = next;
        }

        public SinglyLinkedListNode() {
            super();
        }
    }

    /*
     * Function to find loop starting node.
     * loop_node --> Pointer to one of
     * the loop nodes head --> Pointer to
     * the start node of the linked list
     */
    static SinglyLinkedListNode getLoopstart(SinglyLinkedListNode loop_node,
            SinglyLinkedListNode head) {
        SinglyLinkedListNode ptr1 = loop_node;
        SinglyLinkedListNode ptr2 = loop_node;

        // Count the number of nodes in loop
        int k = 1, i;
        while (ptr1.next != ptr2) {
            ptr1 = ptr1.next;
            k++;
        }

        // Fix one pointer to head
        ptr1 = head;

        // And the other pointer to k
        // nodes after head
        ptr2 = head;
        for (i = 0; i < k; i++)
            ptr2 = ptr2.next;

        /*
         * Move both pointers at the same pace,
         * they will meet at loop starting node
         */
        while (ptr2 != ptr1) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr1;
    }

    /*
     * This function detects and find
     * loop starting node in the list
     */
    static SinglyLinkedListNode detectAndgetLoopstarting(SinglyLinkedListNode head) {
        SinglyLinkedListNode slow_p = head, fast_p = head, loop_start = null;

        // Start traversing list and detect loop
        while (slow_p != null && fast_p != null &&
                fast_p.next != null) {
            slow_p = slow_p.next;
            fast_p = fast_p.next.next;

            /*
             * If slow_p and fast_p meet then find
             * the loop starting node
             */
            if (slow_p == fast_p) {
                loop_start = getLoopstart(slow_p, head);
                break;
            }
        }

        // Return starting node of loop
        return loop_start;
    }

    // Utility function to check if
    // a linked list with loop is
    // palindrome with given starting point.
    static boolean isPalindromeUtil(SinglyLinkedListNode head,
            SinglyLinkedListNode loop_start) {
        SinglyLinkedListNode ptr = head;
        Stack<Integer> s = new Stack<Integer>();

        // Traverse linked list until last node
        // is equal to loop_start and store the
        // elements till start in a stack
        int count = 0;
        while (ptr != loop_start || count != 1) {
            s.push(ptr.data);
            if (ptr == loop_start)
                count = 1;
            ptr = ptr.next;
        }
        ptr = head;
        count = 0;

        // Traverse linked list until last node is
        // equal to loop_start second time
        while (ptr != loop_start || count != 1) {
            // Compare data of node with the top of stack
            // If equal then continue
            if (ptr.data == s.peek())
                s.pop();

            // Else return false
            else
                return false;

            if (ptr == loop_start)
                count = 1;
            ptr = ptr.next;
        }

        // Return true if linked list is palindrome
        return true;
    }

    // Function to find if linked list
    // is palindrome or not
    static boolean isPalindrome(SinglyLinkedListNode head) {
        // Find the loop starting node
        SinglyLinkedListNode loop_start = detectAndgetLoopstarting(head);

        // Check if linked list is palindrome
        return isPalindromeUtil(head, loop_start);
    }

    static SinglyLinkedListNode newNode(int key) {
        SinglyLinkedListNode temp = new SinglyLinkedListNode();
        temp.data = key;
        temp.next = null;
        return temp;
    }

    /* Driver code */
    public static void main(String[] args) {
        SinglyLinkedListNode head = newNode(50);
        head.next = newNode(20);
        head.next.next = newNode(15);
        head.next.next.next = newNode(20);
        head.next.next.next.next = newNode(50);

        /* Create a loop for testing */
        head.next.next.next.next.next = head.next.next;

        if (isPalindrome(head) == true)
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");

    }
}

// This code is contributed by prerna saini

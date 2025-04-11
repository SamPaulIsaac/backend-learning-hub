 public class AddTwoNos {
        public static void main(String[] args) {
            // Create the first number: 9999999
            ListNode l1 = new ListNode(9);
            l1.next = new ListNode(9);
            l1.next.next = new ListNode(9);
            l1.next.next.next = new ListNode(9);
            l1.next.next.next.next = new ListNode(9);
            l1.next.next.next.next.next = new ListNode(9);
            l1.next.next.next.next.next.next = new ListNode(9);

            // Create the second number: 9999
            ListNode l2 = new ListNode(9);
            l2.next = new ListNode(9);
            l2.next.next = new ListNode(9);
            l2.next.next.next = new ListNode(9);

            // Add the two numbers
            ListNode result = addTwoNumbers(l1, l2);

            // Print the result
            printList(result);  // Should output: 8 -> 9 -> 9 -> 9 -> 0 -> 0 -> 0 -> 1
        }

        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode(0);
            ListNode p = l1, q = l2, curr = dummyHead;
            int carry = 0;
            while (p != null || q != null) {
                int x = (p != null) ? p.val : 0;
                int y = (q != null) ? q.val : 0;
                int sum = carry + x + y;
                carry = sum / 10;
                curr.next = new ListNode(sum % 10);
                curr = curr.next;
                if (p != null) p = p.next;
                if (q != null) q = q.next;
            }
            if (carry > 0) {
                curr.next = new ListNode(carry);
            }
            return dummyHead.next;
        }

        public static void printList(ListNode node) {
            while (node != null) {
                System.out.print(node.val);
                node = node.next;
                if (node != null) {
                    System.out.print(" -> ");
                }
            }
            System.out.println();
        }
    }

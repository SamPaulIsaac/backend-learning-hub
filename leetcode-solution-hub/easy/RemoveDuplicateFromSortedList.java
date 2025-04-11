class ListNode {
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

public class RemoveDuplicateFromSortedList {
    static ListNode node1, node2, node3;

    private static void initializeTheListNodes() {
        node3 = new ListNode(2, null);
        node2 = new ListNode(2, node3);
        node1 = new ListNode(1, node2);
    }

    public static void main(String[] args) {
        initializeTheListNodes();
        ListNode listNode = deleteDuplicates(node1);
        if (listNode != null) {
            System.out.println("Iterating the result: ");
            while (listNode != null) {
                System.out.println(listNode.val);
                listNode = listNode.next;
            }
        }
    }

    private static ListNode deleteDuplicates(ListNode head) {
        ListNode track = head;
        while (track != null && track.next != null) {
            if (track.val != track.next.val) track = track.next;
            else track.next = track.next.next;
        }
        return head;
    }
}

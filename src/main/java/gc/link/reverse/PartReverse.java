package gc.link.reverse;

public class PartReverse {
    public Node partReverse(Node head, int from, int to) {
        if (head == null || from == to)
            return head;
        int cnt = 0;
        Node toNext = null;
        Node fromPrev = null;
        Node cur = head;
        while (cur != null) {
            cnt++;
            if (cnt == from)
                fromPrev = cur;
            else if (cnt == to)
                toNext = cur;
            cur = cur.next;
        }

        if (to < from || from < 1 || to > cnt)
            return head;
        cur = fromPrev == null ? head : fromPrev.next;
        Node pre = toNext;
        Node lat = cur.next;
        while (lat != toNext) {
            cur.next = pre;
            pre = cur;
            cur = lat;
            lat = cur.next;
        }
        cur.next = pre;

        if (fromPrev != null) {
            fromPrev.next = cur;
            pre.next = toNext;
            return head;
        }
        return null;
    }

    private void display(Node head) {
        if (head == null)
            System.out.println("null");
        while (head != null) {
            System.out.print(head.val + "  ");
        }
    }

    class Node {
        int val;
        Node next;

        public Node() {
        }

        public Node(int x) {
            val = x;
        }
    }
}



public class ListNode {
    private String val;
    private ListNode prev;
    private ListNode next;

    public ListNode(String val) {
        this.val = val;
    }

     public ListNode(String val, ListNode prev, ListNode next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}

class BrowserHistory {
    private ListNode curr;

    public BrowserHistory(String homepage) {
        curr = new ListNode(homepage);
    }

    public void visit(String url) {
        curr.next = new ListNode(url, curr, null);
        curr = curr.next;
    }

    public String back(int steps) {
        while (steps > 0 && curr.prev != null) {
            curr = curr.prev;
            steps--;
        }
        return curr.val;
    }

    public String forward(int steps) {
        while (steps > 0 && curr.next != null) {
            curr = curr.next;
            steps--;
        }
        return curr.val;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
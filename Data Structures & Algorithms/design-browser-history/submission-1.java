public class ListNode {
    private String val;
    private ListNode prev;
    private ListNode next;

    public ListNode(String val) {
        this.val = val;
    }
}

class BrowserHistory {
    private ListNode curr;
    private int size;
    private int index;

    public BrowserHistory(String homepage) {
        curr = new ListNode(homepage);
        size = 1;
        index = 0;
    }

    public void visit(String url) {
        ListNode newNode = new ListNode(url);
        curr.next = newNode;
        newNode.prev = curr;
        curr = newNode;
        
        index++;
        size = index+1;
    }

    public String back(int steps) {
        while (steps > 0 && index > 0) {
            curr = curr.prev;
            steps--;
            index--;
        }
        return curr.val;
    }

    public String forward(int steps) {
        int availableSteps = size - 1 - index;
        while (steps > 0 && availableSteps > 0) {
            curr = curr.next;
            availableSteps--;
            steps--;
            index++;
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
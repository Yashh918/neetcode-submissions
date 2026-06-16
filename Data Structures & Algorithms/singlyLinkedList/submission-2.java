public class ListNode {
    private int val;
    private ListNode next;

    public ListNode(int val){
        this.val = val;
    }

    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}

class LinkedList {
    private ListNode head;
    private ListNode tail;
    private int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int get(int index) {
        if(index >= size) return -1;
        if(index == 0) return head.val;
        if(index == size-1) return tail.val;

        int currIndex = 0;
        ListNode curr = head;
        while(currIndex < index){
            curr = curr.next;
            currIndex++;
        }

        return curr.val;
    }

    public void insertHead(int val) {
        if(head == null){
            head = new ListNode(val);
            tail = head;
        } else {
            ListNode newHead = new ListNode(val, head);
            head = newHead;
        }
        size++;
    }

    public void insertTail(int val) {
        if(tail == null){
            tail = new ListNode(val);
            head = tail;
        } else {
            ListNode newTail = new ListNode(val);
            tail.next = newTail;
            tail = newTail;
        }
        size++;
    }

    public boolean remove(int index) {
        if(index >= size) return false;
        if(index == 0) {
            head = head.next;
            size--;
            return true;
        }

        ListNode curr = head;
        int currIndex = 0;
        while(currIndex < index-1){
            curr = curr.next;
            currIndex++;
        }

        curr.next = curr.next.next;
        size--;
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> list = new ArrayList<>();

        ListNode curr = head;
        while(curr != null){
            list.add(curr.val);
            curr = curr.next;
        }

        return list;
    }
}

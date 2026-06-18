public class ListNode {
    private int val;
    private ListNode next;

    public ListNode(int val){
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class MyLinkedList {
    private ListNode head;
    private ListNode tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    
    public int get(int index) {
        if(index >= size) return -1;
        if(index == 0) return head.val;
        if(index == size-1) return tail.val;

        ListNode curr = head;
        int currIndex = 0;

        while(currIndex < index){
            curr = curr.next;
            currIndex++;
        }

        return curr.val;
    }
    
    public void addAtHead(int val) {
        if(size == 0) {
            head = new ListNode(val);
            tail = head;
        } else {
            ListNode newHead = new ListNode(val, head);
            head = newHead;
        }

        size++;
    }
    
    public void addAtTail(int val) {
        if(size == 0){
            tail = new ListNode(val);
            head = tail;
        } else {
            ListNode newTail = new ListNode(val);
            tail.next = newTail;
            tail = newTail;
        }

        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index > size) return;
        if(index == 0) {
            addAtHead(val);
            return;
        }
        if(index == size){
            addAtTail(val);
            return;
        }
        
        ListNode curr = new ListNode(val);

        ListNode prev = head;
        int currIndex = 0;

        while(currIndex < index-1){
            prev = prev.next;
            currIndex++;
        }

        ListNode next = prev.next;

        prev.next = curr;
        curr.next = next;
        
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if(index >= size) return;   
        if(index == 0) {
            head = head.next;
            size--;
            return;
        }

        ListNode prev = head;
        int currIndex = 0;

        while(currIndex < index-1){
            prev = prev.next;
            currIndex++;
        }

        if(index == size-1){
            tail = prev;
        }
        prev.next = prev.next.next;
       
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
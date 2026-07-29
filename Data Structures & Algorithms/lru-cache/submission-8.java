public class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    Map<Integer, Node> map;
    int capacity;
    Node head;
    Node tail;
    int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        Node curr = map.get(key);
        if (curr == null) {
            return -1;
        }
        int val = curr.val;

        if (tail == curr) {
            return tail.val;
        }

        remove(curr);
        add(curr);

        return val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        } else if (size >= capacity) {
            remove(head);
        }

        Node curr = new Node(key, value);
        add(curr);
    }

    private void remove(Node curr) {
        Node prev = curr.prev;
        Node next = curr.next;

        if (size == 1) {
            head = null;
            tail = null;
        } else if (prev == null) {
            head = head.next;
            head.prev = null;
        } else if (next == null) {
            tail = tail.prev;
            tail.next = null;
        } else {
            prev.next = next;
            next.prev = prev;
        }

        curr.prev = null;
        curr.next = null;

        map.remove(curr.key);
        size--;
    }

    private void add(Node curr) {
        if (head == null) {
            head = curr;
            tail = curr;
        } else {
            tail.next = curr;
            curr.prev = tail;
            tail = curr;
        }

        map.put(curr.key, curr);
        size++;
    }
}

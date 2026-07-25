class LRUCache {
    int size;
    LinkedList<Integer> list;
    Map<Integer, Integer> map;

    public LRUCache(int capacity) {
        size = capacity;
        list = new LinkedList<>();
        map = new HashMap<>();
    }

    public int get(int key) {
        int val = map.getOrDefault(key, -1);
        if (val == -1)
            return val;

        list.removeFirstOccurrence(key);
        list.addLast(key);

        return val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value);

            list.removeFirstOccurrence(key);
            list.addLast(key);

            return;
        }

        if (list.size() >= size) {
            int removeKey = list.remove();
            map.remove(removeKey);
        }

        list.addLast(key);
        map.put(key, value);
    }
}

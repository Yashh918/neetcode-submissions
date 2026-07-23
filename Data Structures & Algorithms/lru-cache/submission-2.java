class LRUCache {
    int size;
    Queue<Integer> queue;
    Map<Integer, Integer> map;

    public LRUCache(int capacity) {
        size = capacity;
        queue = new LinkedList<>();
        map = new HashMap<>();
    }

    public int get(int key) {
        int val = map.getOrDefault(key, -1);
        if (val == -1)
            return val;

        int currSize = queue.size();
        for (int i = 0; i < currSize; ++i) {
            if (queue.peek() == key) {
                queue.poll();
                continue;
            }

            queue.offer(queue.poll());
        }

        queue.offer(key);

        return val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value);

            int currSize = queue.size();
            for (int i = 0; i < currSize; ++i) {
                if (queue.peek() == key) {
                    queue.poll();
                    continue;
                }

                queue.offer(queue.poll());
            }

            queue.offer(key);
            return;
        }

        if (queue.size() >= size) {
            int removeKey = queue.poll();
            map.remove(removeKey);
        }

        queue.offer(key);
        map.put(key, value);
    }
}

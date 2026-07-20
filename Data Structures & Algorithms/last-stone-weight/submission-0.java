class Solution {
    public int lastStoneWeight(int[] stones) {
        Comparator<Integer> c = (a, b) -> b - a;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(c);

        for(int stone : stones){
            maxHeap.offer(stone);
        }

        while(maxHeap.size() >= 2){
            int x = Math.abs(maxHeap.poll() - maxHeap.poll());
            if(x != 0)
                maxHeap.offer(x);
        }

        if(maxHeap.isEmpty()) return 0;

        return maxHeap.poll();
    }
}

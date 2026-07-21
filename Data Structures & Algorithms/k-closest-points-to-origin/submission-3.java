class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];
        Comparator<int[]> c =
            (a, b) -> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]);
        PriorityQueue<int[]> maxHeap = new PriorityQueue(c);

        for (int[] point : points) {
            maxHeap.offer(point);

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        for(int i=0; i<k; ++i){
            ans[i] = maxHeap.poll();
        }

        return ans;
    }
}

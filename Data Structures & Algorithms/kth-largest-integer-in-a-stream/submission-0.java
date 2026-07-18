class KthLargest {

    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    int k;
    Stack<Integer> s = new Stack<>();


    public KthLargest(int k, int[] nums) {
        for(int num : nums){
            pq.offer(num);
        }

        this.k = k;
    }
    
    public int add(int val) {
        int count = k;
        int ans = 0;

        pq.offer(val);

        while(count > 0){
            s.push(pq.poll());
            --count;
        }

        ans = s.peek();

        while(!s.isEmpty()){
            pq.offer(s.pop());
        }

        return ans;
    }
}

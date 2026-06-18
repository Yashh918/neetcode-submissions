class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int n = students.length;
        int counter = 0;
        Deque<Integer> d1  = new LinkedList<>(); 
        Deque<Integer> d2  = new LinkedList<>(); 

        for(int i=0; i<n; ++i){
            d1.addLast(students[i]);
            d2.addLast(sandwiches[i]);
        }

        while(n > 0 && counter < n){
            if(d1.peekFirst() == d2.peekFirst()){
                d1.pollFirst();
                d2.pollFirst();
                n--;
                counter = 0;
                continue;
            } 

            d1.addLast(d1.pollFirst());
            counter++;
        }

        return n;
    }
}
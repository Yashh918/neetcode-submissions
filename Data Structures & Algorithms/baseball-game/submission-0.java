class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        int n = operations.length;
        int total = 0;

        for(int i=0; i<n; ++i){
            if(operations[i].equals("+")){
                stack2.push(stack.pop());
                int sum = stack.peek() + stack2.peek();
                stack.push(stack2.pop());
                stack.push(sum);
                total += sum;
            }
            else if(operations[i].equals("C")){
                total -= stack.pop();
            }
            else if(operations[i].equals("D")){
                int x = stack.peek() * 2;
                stack.push(x);
                total += x;
            } else {
                int x = Integer.valueOf(operations[i]);
                stack.push(x);
                total += x;
            }
        }

        return total;
    }
}
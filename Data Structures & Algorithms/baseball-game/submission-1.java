class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = operations.length;
        int total = 0;

        for(String x : operations){
            if(x.equals("+")){
                int top = stack.pop();
                int newTop = stack.peek() + top;
                stack.push(top);
                stack.push(newTop);
                total += newTop;
            }
            else if(x.equals("C")){
                total -= stack.pop();
            }
            else if(x.equals("D")){
                int y = stack.peek() * 2;
                stack.push(y);
                total += y;
            } else {
                int y = Integer.valueOf(x);
                stack.push(y);
                total += y;
            }
        }

        return total;
    }
}
class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char x : s.toCharArray()) {
            if (x == '(' || x == '[' || x == '{') {
                stack.push(x);
                continue;
            } 

            if (x == ')' || x == ']' || x == '}') {
               if(stack.isEmpty()) return false;
            } 
            
            if (x == ')' && stack.peek() == '(') {
                stack.pop();
            } else if (x == ']' && stack.peek() == '[') {
                stack.pop();
            } else if (x == '}' && stack.peek() == '{') {
                stack.pop();
            } else {
                return false;
            }
        }

        if (!stack.isEmpty()) return false;

        return true;
    }
}

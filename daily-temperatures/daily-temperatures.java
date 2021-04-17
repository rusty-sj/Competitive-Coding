class Solution {
    public int[] dailyTemperatures(int[] T) {
        
        int n = T.length;
        int[] output = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        int i = n - 1;
        while (i >= 0) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
                stack.pop();
            } 
            if (stack.isEmpty())
                output[i] = 0;
            else
                output[i] = stack.peek() - i;
            stack.push(i);
            i--;
        }
        return output;
    }
}
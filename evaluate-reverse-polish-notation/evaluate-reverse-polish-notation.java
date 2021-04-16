class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        int num1 = 0, num2 = 0;
        for (String token : tokens) {
            switch(token) {
                case "+": 
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2 + num1);
                    break;
                case "-": 
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2 - num1);
                    break;
                case "*": 
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2 * num1);
                    break;
                case "/": 
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2 / num1);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }
        return stack.pop();
    }
}
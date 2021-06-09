class Solution {
    public boolean isHappy(int n) {
        
        Set<Integer> set = new HashSet<>();
        
        int sum = n;
        while (true) {
            sum = getDigitSquaresSum(sum);
            if (set.contains(sum))  // Found cycle
                return false;
            set.add(sum);
            if (sum == 1)
                return true;
        }
    }
    
    public int getDigitSquaresSum(int n) {
        int sum = 0;
        while (n > 0) {
            int mod = n % 10;
            sum += mod * mod;
            n = n / 10;
        } 
        return sum;
    }
}
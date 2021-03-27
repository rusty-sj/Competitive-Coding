class Solution {
    public int reverse(int x) {
        
        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
            x = Math.abs(x);
        }
        
        int size = (int) Math.log10(x);
        long result = 0;
        
        while (x > 0) {
            int digitStrip = x % 10;
            result += digitStrip * (long)Math.pow(10, size);
            x = x / 10;
            size--;
        }
        System.out.println(result);
        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE)
            return 0;
        return isNegative ? (int)result * -1 : (int)result;
    }
}
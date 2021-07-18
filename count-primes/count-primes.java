class Solution {
    public int countPrimes(int n) {
        if (n <= 2)
            return 0;
        
        boolean[] numbers = new boolean[n];
        Arrays.fill(numbers, true);
        
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (numbers[i]) {
                for (int j = i * i; j < n; j += i) {
                    numbers[j] = false;
                }
            }
        }
        int primes = 0;
        for (int i = 2; i < n; i++) {
            if (numbers[i])
                primes++;
        }
        return primes;
    }
}
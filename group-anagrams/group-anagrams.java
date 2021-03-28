class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> output = new ArrayList<>();
        if (strs == null || strs.length == 0)
            return output;
        int[] primes = generatePrimes(26);
        Map<Long, List<String>> map = new HashMap<>();
        for (String str: strs) {
            long encoded = encodeString(str, primes);
            if (!map.containsKey(encoded))
                map.put(encoded, new ArrayList<String>());
            map.get(encoded).add(str);
        }
        for (List<String> list : map.values()) {
            output.add(list);
        }
        return output;
    }
    
    public long encodeString(String str, int[] primes) {
        long product = 1;
        for (char c: str.toCharArray()) {
            product *= primes[c - 'a'];
        }
        return product;
    }
    
    public int[] generatePrimes(int n) {
        int[] primes = new int[n];
        int count = 0, num = 2;
        while (count < n) { 
            boolean prime = true;
            for (int i = 2; i <= Math.sqrt(num); i++) { 
                if (num % i == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime) {
                primes[count++] = num;
            }
            num++;
        }
        return primes;
    }
}
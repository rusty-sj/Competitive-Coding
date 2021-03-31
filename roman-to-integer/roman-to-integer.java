class Solution {
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>(){{
            put("I", 1); put("IV", 4); put("V", 5);
            put("IX", 9); put("X", 10); put("XL", 40);
            put("L", 50); put("XC", 90); put("C", 100);
            put("CD", 400); put("D", 500); put("CM", 900);
            put("M", 1000);
        }};
        
        int sum = 0;
        int i = 0;
        while (i < s.length()) {
            if (i < s.length() - 1) {
                String temp = s.substring(i, i + 2);
                if (map.containsKey(temp)) {
                    sum += map.get(temp);
                    i += 2;
                    continue;
                }
            }
            String single = s.substring(i, i + 1);
            sum += map.get(single);
            i += 1;
        }
        return sum;
    }
}
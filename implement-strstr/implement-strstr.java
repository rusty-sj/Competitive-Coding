class Solution {
    public int strStr(String haystack, String needle) {
      
        if (haystack.length() == 0 && needle.length() == 0)
            return 0;
        int ptr1 = 0, ptr2 = 0;
        
        while (ptr1 < haystack.length()) {
            int start = ptr1;
            while (ptr1 < haystack.length() && ptr2 < needle.length() && haystack.charAt(ptr1) == needle.charAt(ptr2)) {
                ptr1++;
                ptr2++;
            }
            if (ptr2 < needle.length()) {
                ptr2 = 0;
                ptr1 = start + 1;
            } else {
                return ptr1 - needle.length();
            }
        }
        return -1;
    }
}
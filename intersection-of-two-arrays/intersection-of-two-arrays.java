class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> output = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        for (int num : nums2) {
            if (set.contains(num)) {
                output.add(num);
                set.remove(num);
            }
        }
        int[] ints = new int[output.size()];
        for (int i = 0; i < output.size(); i++) {
            ints[i] = output.get(i);
        }
        return ints;
    }
}
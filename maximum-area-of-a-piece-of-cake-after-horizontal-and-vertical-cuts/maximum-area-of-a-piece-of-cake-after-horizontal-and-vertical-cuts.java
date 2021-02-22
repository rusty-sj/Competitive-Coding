class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int maxhCut = 0, maxvCut = 0;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        maxhCut = Math.max(horizontalCuts[0] - 0, h - horizontalCuts[horizontalCuts.length - 1]);        
        for (int i = 1; i < horizontalCuts.length; i++) {
            maxhCut = Math.max(maxhCut, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        
        maxvCut = Math.max(verticalCuts[0] - 0, w - verticalCuts[verticalCuts.length - 1]);
        for (int i = 1; i < verticalCuts.length; i++) {
            maxvCut = Math.max(maxvCut, verticalCuts[i] - verticalCuts[i - 1]);
        }
        return (int)((1L * maxhCut * maxvCut) % (1e9 + 7));
    }
}
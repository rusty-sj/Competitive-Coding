/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        List<String> words = new LinkedList<>(Arrays.asList(wordlist));
        int calls = 0;
        while (calls < 10) {
            int index = new Random().nextInt(words.size());
            String pickedWord = words.get(index);
            int guessed = master.guess(pickedWord);
            if (guessed == 6)
                return;
            List<String> narrowed = new LinkedList<>();
            for (String word: words) {
                if (countMathes(word, pickedWord) == guessed) {
                    narrowed.add(word);
                }
            }
            words = narrowed;
            calls++;
        }
    }
    
    public int countMathes(String word1, String word2) {
        int count = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) == word2.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}
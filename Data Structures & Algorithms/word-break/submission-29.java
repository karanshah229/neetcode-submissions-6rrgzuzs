class Solution {
    Set<String> wordDict = new HashSet<>();
    int minWordLen = Integer.MAX_VALUE;
    int maxWordLen = Integer.MIN_VALUE;
    Map<Integer, Boolean> memo = new HashMap<>();

    public boolean wBreak(String s, int index) {
        if (index == s.length()) {
            return true;
        }

        if (memo.containsKey(index)) {
            return memo.get(index);
        }

        for (int len = minWordLen; len <= maxWordLen; len++) {
            int end = index + len;

            if (end > s.length()) {
                break;
            }

            String newWord = s.substring(index, end);

            if (
                wordDict.contains(newWord) &&
                wBreak(s, end)
            ) {
                memo.put(index, true);
                return true;
            }
        }

        memo.put(index, false);
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDictOg) {
        for (String word : wordDictOg) {
            wordDict.add(word);
            minWordLen = Math.min(minWordLen, word.length());
            maxWordLen = Math.max(maxWordLen, word.length());
        }

        return wBreak(s, 0);
    }
}
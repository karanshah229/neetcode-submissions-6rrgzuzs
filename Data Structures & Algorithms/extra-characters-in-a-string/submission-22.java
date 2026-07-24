class Solution {
    Set<String> words = new HashSet<>();
    int minLen = Integer.MAX_VALUE;
    int maxLen = Integer.MIN_VALUE;
    Integer[] memo;

    public int dfs(String s, int index) {
        if (index == s.length()) return 0;
        if (memo[index] != null) return memo[index];

        int ans = 1 + dfs(s, index + 1); // skip current char

        for (int len = minLen; len <= maxLen; len++) {
            if (index + len > s.length()) break;
            String word = s.substring(index, index + len);
            if (words.contains(word)) {
                ans = Math.min(ans, dfs(s, index + len));
            }
        }

        return memo[index] = ans;
    }

    public int minExtraChar(String s, String[] dictionary) {
        for (String word : dictionary) {
            words.add(word);
            minLen = Math.min(minLen, word.length());
            maxLen = Math.max(maxLen, word.length());
        }

        memo = new Integer[s.length()];
        return dfs(s, 0);
    }
}

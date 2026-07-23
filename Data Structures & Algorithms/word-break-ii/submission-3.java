class Solution {
    Set<String> wordDict = new HashSet<>();
    int minWordLen = Integer.MAX_VALUE;
    int maxWordLen = Integer.MIN_VALUE;

    Map<Integer, List<List<String>>> memo = new HashMap<>();

    public List<List<String>> wBreak(String s, int index) {
        if (memo.containsKey(index)) {
            return memo.get(index);
        }

        List<List<String>> paths = new ArrayList<>();

        if (index == s.length()) {
            paths.add(new ArrayList<>());
            return paths;
        }

        for (int len = minWordLen; len <= maxWordLen; len++) {
            int end = index + len;

            if (end > s.length()) break;

            String newWord = s.substring(index, end);

            if (wordDict.contains(newWord)) {
                List<List<String>> suffixPaths = wBreak(s, end);

                for (List<String> suffixPath : suffixPaths) {
                    List<String> completePath = new ArrayList<>();

                    completePath.add(newWord);
                    completePath.addAll(suffixPath);

                    paths.add(completePath);
                }
            }
        }

        memo.put(index, paths);
        return paths;
    }

    public List<String> wordBreak(String s, List<String> wordDictOg) {
        for (String word : wordDictOg) {
            int len = word.length();

            minWordLen = Math.min(minWordLen, len);
            maxWordLen = Math.max(maxWordLen, len);
            wordDict.add(word);
        }

        List<List<String>> res = wBreak(s, 0);

        System.out.println(res);

        List<String> re = new ArrayList<>();
        for(List<String> words: res){
            re.add(String.join(" ", words));
        }

        return re;
    }
}
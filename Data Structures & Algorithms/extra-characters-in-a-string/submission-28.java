class Solution {
    Set<String> words = new HashSet<>();
    int minLen = Integer.MAX_VALUE;
    int maxLen = Integer.MIN_VALUE;
    int res = Integer.MAX_VALUE;
    Map<String, Integer> cache = new HashMap<>();

    public int solve(String s, int index, List<String> curr, int charsSkipped){
        String key = index + "," + charsSkipped;

        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        if(index == s.length()){
            // if no word is possible 
            System.out.println(charsSkipped);
            System.out.println(curr);
            res = Math.min(res, charsSkipped);
            return charsSkipped;
        }

        // if yes, recurse on the word created
        boolean foundWord = false;
        int re = solve(s, index+1, curr, charsSkipped+1);
        for(int len = minLen; len <= maxLen; len++){
            if(index + len - 1 > s.length() - 1) break;
            
            String word = s.substring(index, index+len);
            if(words.contains(word)){
                foundWord = true;
                List<String> currC = new ArrayList<>(curr);
                currC.add(word);
                re = Math.min(re, solve(s, index+len, currC, charsSkipped));
            }
        }
        cache.put(key, re);
        return re;
    }

    public int minExtraChar(String s, String[] dictionary) {
        for(String word: dictionary) {
            words.add(word);
            minLen = Math.min(minLen, word.length());
            maxLen = Math.max(maxLen, word.length());
        }

        solve(s, 0, new ArrayList<>(), 0);

        return res;
    }
}
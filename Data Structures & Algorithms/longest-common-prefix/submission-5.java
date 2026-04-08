class Solution {
    public String longestCommonPrefix(String[] strs) {
        String result = "";

        // shortest string
        int shortestStrLen = 999999999;
        for(int i = 0; i < strs.length; i++){
            shortestStrLen = Math.min(strs[i].length(), shortestStrLen);
        }

        for(int i = 0; i < shortestStrLen; i++){
            Set<Character> s = new HashSet<>();

            for(int j = 0; j < strs.length; j++){
                s.add(strs[j].charAt(i));
            }

            if(s.size() == 1) result += strs[0].charAt(i);
            else return result;
        }

        return result;
    }
}
class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i = 0;
        int j = 0;

        String result = "";
        while(i < word1.length() && j < word2.length()){
            result += word1.charAt(i);
            result += word2.charAt(j);

            i++;
            j++;
        }


        while(i < word1.length()){
            result += word1.charAt(i);
            i++;
        }

        while(j < word2.length()){
            result += word2.charAt(j);
            j++;
        }

        return result;
    }
}
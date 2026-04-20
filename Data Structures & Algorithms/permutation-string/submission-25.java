class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] c1 = new int[26];
        int[] c2 = new int[26];

        for(int i = 0; i < s1.length(); i++){
            c1[s1.charAt(i) - 'a']++;
        }

        int start = 0;
        for(int i = 0; i < s2.length(); i++){
            char ch = s2.charAt(i);
            c2[ch - 'a']++;

            while (c2[ch - 'a'] > c1[ch - 'a']) {
                c2[s2.charAt(start) - 'a']--;
                start++;
            }

            if(i - start + 1 == s1.length()) {
                return true;
            }
        }

        return false;
    }
}
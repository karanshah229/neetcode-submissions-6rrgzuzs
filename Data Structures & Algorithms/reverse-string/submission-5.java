class Solution {
    public void reverseString(char[] s) {
        int sLen = s.length;
        for(int i = 0; i < sLen / 2; i++){
            char swap = s[i];
            s[i] = s[sLen - 1 - i];
            s[sLen - 1 - i] = swap;
        }
    }
}
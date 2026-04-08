class Solution {
    int asciiDiff(int first, int second) {
        return Math.abs(first - second);
    }

    public int scoreOfString(String s) {
        int sLen = s.length();
        int sum = 0;
        for (int i = 0; i < sLen - 1; i++){
            sum += asciiDiff(s.charAt(i), s.charAt(i+1));
        }
        return sum;
    }
}
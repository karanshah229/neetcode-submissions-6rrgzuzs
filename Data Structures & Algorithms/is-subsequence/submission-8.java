class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0) return true;

        char[] sCharArr = s.toCharArray();
        char[] tCharArr = t.toCharArray();

        int sCharrArrIndex = 0;
        int tCharrArrIndex = 0;
        int sCharArrLen = sCharArr.length;
        int tCharArrLen = tCharArr.length;

        while(tCharrArrIndex < tCharArrLen && sCharrArrIndex < sCharArrLen){
            char sChar = sCharArr[sCharrArrIndex];
            char tChar = tCharArr[tCharrArrIndex];

            if(sChar == tChar){
                sCharrArrIndex++;
            }

            tCharrArrIndex++;
        }

        if(sCharrArrIndex == sCharArrLen){
            return true;
        }

        return false;
    }
}
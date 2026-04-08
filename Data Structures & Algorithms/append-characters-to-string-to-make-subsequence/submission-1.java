class Solution {
    public int appendCharacters(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        
        if(sLen == 0 || tLen == 0) return 0;

        int sIndex = 0;
        int tIndex = 0;

        while(sIndex < sLen && tIndex < tLen){
            char sChar = s.charAt(sIndex);
            char tChar = t.charAt(tIndex);

            if(tChar == sChar){
                tIndex++;
            }
            sIndex++;
        }

        return tLen - tIndex;
    }
}
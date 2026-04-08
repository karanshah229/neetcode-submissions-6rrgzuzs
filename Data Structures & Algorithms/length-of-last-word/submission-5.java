class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;
        int sLen = s.length();

        for(int i = sLen-1; i >= 0; i--){
            char ch = s.charAt(i);
            if(Character.isWhitespace(ch)){
                if(length != 0) return length;
            } else length++;
        }

        return length;
    }
}
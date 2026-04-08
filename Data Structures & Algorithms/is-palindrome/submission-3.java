class Solution {
    public boolean isPalindrome(String s) {
        String sanitized = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        
        boolean result = true;
        int sLen = sanitized.length();
        for(int i = 0; i < sLen / 2; i++){
            if(sanitized.charAt(i) != sanitized.charAt(sLen - 1 - i)) result = false;
        }

        return result;
    }
}

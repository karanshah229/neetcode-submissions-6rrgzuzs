class Solution {
    static boolean deleted = false;

    static boolean isValid(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                if(deleted) return false;
                deleted = true;

                return isValid(s, i+1, j) || isValid(s, i, j-1);
            }

            i++;
            j--;
        }

        return true;
    }

    public boolean validPalindrome(String s) {
        deleted = false;
        return isValid(s, 0, s.length() - 1);
    }
}
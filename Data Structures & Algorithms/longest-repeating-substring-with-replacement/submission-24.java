class Solution {
    public int characterReplacement(String s, int k) {
        int slen = s.length();
        int l = 0;
        int r = 0;

        int result = 0;

        HashMap<Character, Integer> hm = new HashMap<>();
        int maxF = 0;

        while(r < slen){
            Character ch = s.charAt(r);

            int newF = hm.getOrDefault(ch, 0) + 1;
            hm.put(ch, newF);
            maxF = Math.max(maxF, newF);

            int len = r - l + 1;
            boolean isValid = len - maxF <= k;
            if(isValid) {
                result = Math.max(result, len);
            } else {
                // increment left till you get a valid subarray
                while(l <= r) {
                    char leftChar = s.charAt(l);
                    hm.put(leftChar, hm.get(leftChar) - 1);
                    l++;
                    
                    len = r - l + 1;
                    isValid = len - maxF <= k;
                    if(isValid) break;
                }
            }

            System.out.println(hm + " - " + maxF + " - " + result + " : " + l + " : " + r);
            r++;
        }
        
        return result;
    }
}

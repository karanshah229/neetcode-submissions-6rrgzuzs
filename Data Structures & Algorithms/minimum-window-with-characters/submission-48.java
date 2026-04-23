class Solution {
    public String minWindow(String s, String t) {
        int i = 0;
        int j = 0;
        int matches = 0;
        int slen = s.length();
        int tlen = t.length();

        int[] t1 = new int[128];
        int[] s1 = new int[128];
        HashSet<Character> sSet = new HashSet<>();

        for (char tc : t.toCharArray()) {
            t1[tc]++;
            sSet.add(tc);
        }

        int resLen = Integer.MAX_VALUE;
        String result = "";

        while(j < slen){
            char c = s.charAt(j);

            // check if char exists in t
            // increase matches only if frequency matches
            if(t1[c] != 0){
                s1[c]++;
                if(s1[c] == t1[c]) matches++;
            }

            // if matches == tlen
            // update result if required
            while(matches == sSet.size()){
                int len = j - i + 1;
                if(len < resLen){
                    resLen = len;
                    result = s.substring(i, j+1);
                }

                char left = s.charAt(i);
                if (t1[left] != 0) {
                    if (s1[left] == t1[left]) {
                        matches--;
                    }
                    s1[left]--;
                }
                i++;
            }
        
            j++;
        }

        return result;
    }
}
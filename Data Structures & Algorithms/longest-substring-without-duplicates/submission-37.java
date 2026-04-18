class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int localResult = 0;

        int slen = s.length();
        int i = 0;
        int j = 0;

        HashMap<Character, Integer> hm = new HashMap<>();


        while(j < slen){
            Character ch = s.charAt(j);

            if(hm.get(ch) == null){
                hm.put(ch, j);
            } else {
                result = Math.max(result, j-i);
                i = Math.max(i, hm.get(ch) + 1);
                hm.put(ch, j);
            }


            j++;
            System.out.println(hm);
            System.out.println(i + " : " + j);
        }
        
        result = Math.max(result, j-i);

        return result;
    }
}

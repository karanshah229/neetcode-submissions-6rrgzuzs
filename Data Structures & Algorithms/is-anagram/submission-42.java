class Solution {
    static void fillHM(HashMap<Character, Integer> hm, String s){
        for(char c: s.toCharArray()){
            int count = 0;
            if(hm.get(c) != null) count = hm.get(c);
            
            hm.put(c, ++count);
        }
    }

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        var hms = new HashMap<Character, Integer>();
        var hmt = new HashMap<Character, Integer>();

        fillHM(hms, s);
        fillHM(hmt, t);
        
        for(char key: hms.keySet()){
            if( !( hms.get(key).equals(hmt.get(key)) ) ){
                System.out.println(key + " " + hms.get(key) + " " + hmt.get(key));
                System.out.println(hms.get(key) == hmt.get(key));
                return false;
            }
        }

        return true;
    }
}

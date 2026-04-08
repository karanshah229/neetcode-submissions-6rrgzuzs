class Solution {
    static final String DELIMETER = ":#:";

    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();
        
        for(String s: strs){
            result.append(s.length()).append(DELIMETER).append(s);
        }
        
        return result.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int delimIndex = str.indexOf(DELIMETER, i);
            int length = Integer.parseInt(str.substring(i, delimIndex));
            i = delimIndex + DELIMETER.length();
            result.add(str.substring(i, i + length));
            i += length;
        }

        return result;
    }
}
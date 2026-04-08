class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<Integer>> hm = new HashMap<>();
        List<List<String>> returnVal = new ArrayList<>();

        for(int i = 0; i < strs.length; i++){
            String s = strs[i];

            // Sort string
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String sortedS = new String(c);


            ArrayList<Integer> al = new ArrayList<Integer>();
            // fetch from map
            ArrayList<Integer> temp = hm.get(sortedS);
            // if not null append index to existing arraylist
            if(temp != null) al.addAll(temp);
            // add current index
            al.add(i);

            hm.put(sortedS, al);
        }
        
        // iterate over hm keyset and create arrays for each group
        for(String key: hm.keySet()){
            ArrayList<Integer> valuesIndex = hm.get(key);
            int valuesIndexLen = valuesIndex.size();
            ArrayList<String> sValues = new ArrayList<String>();
            for(int i = 0; i < valuesIndexLen; i++) {
                sValues.add(strs[valuesIndex.get(i)]);
            }
            returnVal.add(sValues);
        }

        return returnVal;
    }
}

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int i = 0;
        int j = arr.length - 1;

        while(i <= j && (j-i+1) != k ){
            if(Math.abs(x - arr[i]) > Math.abs(x - arr[j])){
                i++;
            } else {
                j--;
            }
        }

        ArrayList<Integer> al = new ArrayList<>();
        for(int s = i; s <= j; s++){
            al.add(arr[s]);
        }

        return al;
    }
}
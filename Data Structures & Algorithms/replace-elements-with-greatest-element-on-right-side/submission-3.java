class Solution {
    public int[] replaceElements(int[] arr) {
        int arrLen = arr.length;
        
        int largestNumberYet = -1;
        for(int i = arrLen - 1; i >= 0; i--){
            int curr = arr[i];
            arr[i] = largestNumberYet;

            if(curr > largestNumberYet) largestNumberYet = curr;
        }

        return arr;
    }
}
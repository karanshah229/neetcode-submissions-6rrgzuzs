/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray m) {
        int peakIndex = -1;
        int peakVal = -1;
        int mLen = m.length();

        int left = 0;
        int right = mLen - 1;
        // find peak - binary search to find peak
        // check the order of mid, mid-1, mid+1
        while(left <= right){
            int mid = left + ((right - left) / 2);

            int midEl = m.get(mid);
            int prevMidEl = m.get(mid - 1);
            int nextMidEl = m.get(mid + 1);

            if(prevMidEl < midEl && midEl > nextMidEl) {
                peakIndex = mid;
                peakVal = midEl;
                break;
            }

            if(prevMidEl < midEl && midEl < nextMidEl){
                left = mid + 1; continue;
            }
            
            if(prevMidEl > midEl && midEl > nextMidEl){
                right = mid - 1; continue;
            }
        }

        System.out.println("Peak Index: " + peakIndex);

        if(peakVal == target) return peakIndex;

        // left side binary search - increasing values
        left = 0;
        right = peakIndex;

        while(left <= right){
            int mid = left + ((right - left) / 2);
            int midEl = m.get(mid);

            if(midEl == target) return mid;

            if(midEl > target){
                right = mid - 1; continue;
            } else {
                left = mid + 1; continue;
            }
        }

        // right side binary search - decreasing values
        left = peakIndex;
        right = mLen - 1;

        while(left <= right){
            int mid = left + ((right - left) / 2);
            int midEl = m.get(mid);

            if(midEl == target) return mid;

            if(midEl > target){
                left = mid + 1; continue;
            } else {
                right = mid - 1; continue;
            }
        }

        return -1;
    }
}
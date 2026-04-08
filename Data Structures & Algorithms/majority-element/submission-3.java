class Solution {
    public int majorityElement(int[] nums) {
        // candidates and counts
        int[] cand = new int[3];
        int[] cnt = new int[3];
        int size = 0;

        int i = 0, j = nums.length - 1;

        while (i <= j) {
            // process left
            size = process(nums[i], cand, cnt, size);
            if (i != j) {
                // process right
                size = process(nums[j], cand, cnt, size);
            }
            i++;
            j--;
        }

        // return candidate with max count
        int maxIdx = 0;
        for (int k = 1; k < size; k++) {
            if (cnt[k] > cnt[maxIdx]) {
                maxIdx = k;
            }
        }
        return cand[maxIdx];
    }

    private int process(int x, int[] cand, int[] cnt, int size) {
        // if x already exists
        for (int k = 0; k < size; k++) {
            if (cand[k] == x) {
                cnt[k]++;
                return size;
            }
        }

        // if space available
        if (size < 3) {
            cand[size] = x;
            cnt[size] = 1;
            return size + 1;
        }

        // drop lowest-count candidate
        int minIdx = 0;
        for (int k = 1; k < 3; k++) {
            if (cnt[k] < cnt[minIdx]) {
                minIdx = k;
            }
        }

        cand[minIdx] = x;
        cnt[minIdx] = 1;
        return size;
    }
}

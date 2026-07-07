class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for(char task: tasks){
            freq[task - 'A']++;
        }

        int maxFreq = Integer.MIN_VALUE;
        int numMax = Integer.MIN_VALUE;
        for(int i = 0; i < 26; i++){
            if(freq[i] > maxFreq){
                maxFreq = freq[i];
                numMax = 1;
            } else if(freq[i] == maxFreq){
                numMax++;
            }
        }

        return Math.max(tasks.length, ( (maxFreq -1) * (n+1) + numMax));

        // max(tasks.length, (maxFreq-1) * (n+1) + numMax)
    }
}

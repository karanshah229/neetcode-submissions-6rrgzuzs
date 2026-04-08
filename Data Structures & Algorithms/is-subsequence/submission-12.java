public class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        if (m == 0) return n == 0;

        int[][] store = new int[m][26];
        for (int i = 0; i < m; i++) {
            Arrays.fill(store[i], m + 1);
        }

        store[m - 1][t.charAt(m - 1) - 'a'] = m - 1;

        System.out.println("Cached Data:");
        for(int i = 0; i < m; i++){
            for(int j = 0; j < 26; j++){
                System.out.println(store[i][j]);
            }
        }

        for (int i = m - 2; i >= 0; i--) {
            store[i] = store[i + 1].clone();
            store[i][t.charAt(i) - 'a'] = i;
        }

        int i = 0, j = 0;
        while (i < n && j < m) {
            j = store[j][s.charAt(i) - 'a'] + 1;
            if (j > m) return false;
            i++;
        }

        return i == n;
    }
}
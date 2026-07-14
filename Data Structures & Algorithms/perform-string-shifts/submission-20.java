class Solution {
    public String rotate(int direction, int amount, String s) {
        int sLen = s.length();
        char[] res = new char[sLen];

        for (int i = 0; i < sLen; i++) {
            char ch = s.charAt(i);
            int newI = 0;
            if (direction == 1)
                newI = (i + amount) % sLen;
            else
                newI = (i - amount + sLen) % sLen;
            res[newI] = ch;
        }

        return new String(res);
    }

    public String stringShift(String s, int[][] shift) {
        int amount = 0;

        for (int[] sh : shift) {
            if (sh[0] == 1)
                amount += sh[1];
            else
                amount -= sh[1];
        }

        return rotate(amount > 0 ? 1 : 0, Math.abs(amount) % s.length(), s);
    }
}

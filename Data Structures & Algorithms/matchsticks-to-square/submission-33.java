class Solution {
    public boolean comb(int[] sticks, int[] sides, int index, int sideMax) {
        if(index == sticks.length){
            if(sides[0] == sides[1] && sides[0] == sides[2] && sides[0] == sides[3]){
                return true;
            }
            return false;
        }

        for(int j = 0; j < 4; j++){
            int[] sidesC = Arrays.copyOf(sides, sides.length);
            sidesC[j] += sticks[index];
            if(sidesC[j] > sideMax) continue;
            boolean re = comb(sticks, sidesC, index + 1, sideMax);
            if(re) return true;
        }

        return false;
    }

    public boolean makesquare(int[] ms) {
        int sum = 0;
        for(int m: ms) sum += m;
        int sideMax = sum / 4;
        if(sum % 4 != 0) return false;

        Arrays.sort(ms);
        int i = 0, j = ms.length - 1;
        while(i <= j){
            int temp = ms[j];
            ms[j] = ms[i];
            ms[i] = temp;
            i++;
            j--;
        }
        // System.out.println(Arrays.toString(ms));

        return comb(ms, new int[]{0,0,0,0}, 0, sideMax);
    }
}
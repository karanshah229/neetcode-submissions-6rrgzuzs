class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        ArrayDeque<Integer> aq = new ArrayDeque<Integer>();

        for(int as: asteroids){
            if(aq.isEmpty()){
                aq.push(as);
            } else {
                if(as == 0) continue;

                aq.push(as);

                while(aq.size() > 1){
                    int top1 = aq.pop();
                    int top2 = aq.pop();

                    if(top1 < 0 && top2 > 0){
                        int abs1 = Math.abs(top1);
                        int abs2 = Math.abs(top2);

                        if(abs1 == abs2) break;

                        aq.push(abs1 > abs2 ? top1 : top2);
                    } else {
                        // same sign break;
                        aq.push(top2);
                        aq.push(top1);
                        break;
                    }
                }
            }
        }

        int[] result = new int[aq.size()];
        int i = aq.size() - 1;
        for (int val : aq) {
            result[i--] = val;
        }
        return result;
    }
}
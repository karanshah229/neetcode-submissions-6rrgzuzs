class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int l = 0;
        int r = people.length - 1;

        List<List<Integer>> result = new ArrayList();

        while(l <= r){
            List<Integer> temp = new ArrayList();
            
            if(l == r) {
                temp.add(people[l]);
                result.add(temp);
                break;
            }

            int sum = people[l] + people[r];

            if(sum <= limit) {
                temp.add(people[l]);
                temp.add(people[r]);
                result.add(temp);
                l++;
                r--;
                continue;
            }

            if(sum > limit){
                temp.add(people[r]);
                result.add(temp);
                r--;
                continue;
            }
        }

        System.out.println(result);
        return result.size();
    }
}
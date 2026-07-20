class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Deque<Integer> st = new ArrayDeque<>();
        for(int i = students.length - 1; i >= 0; i--) st.push(students[i]);

        Deque<Integer> sd = new ArrayDeque<>();
        for(int i = sandwiches.length - 1; i >= 0; i--) sd.push(sandwiches[i]);

        int prevLen = 0;
        while(true){
            List<Integer> std = new ArrayList<>();
            while(!st.isEmpty() && !sd.isEmpty()){
                int popped = st.pop();
                if(popped == sd.peek()) sd.pop();
                else std.add(0, popped);
            }
            for(int el: std) st.push(el);

            
            if(prevLen == st.size()) break;
            else prevLen = st.size();
        }

        return st.size();
    }
}
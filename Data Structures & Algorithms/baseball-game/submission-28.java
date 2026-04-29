class Solution {
    public int calPoints(String[] operations) {
        ArrayDeque<Integer> st = new ArrayDeque<>();


        for (String op : operations) {
            if (op.equals("C")) {
                // C - pop top number
                st.pop();
            } else if (op.equals("D")) {
                // D - remove top number, double it, push result
                st.push(st.peek() * 2);
            } else if (op.equals("+")) {
                // + - remove top 2 numbers, add them, push result
                int first = st.peek();
                st.pop();
                int second = st.peek();
                st.push(first);
                st.push(first + second);
            } else {
                // integer - push to stack
                st.push(Integer.parseInt(op));
            }
        }

        int sum = 0;
        for(int val: st){
            sum += val;
        }
        return sum;
    }
}
class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> aq = new ArrayDeque<Integer>();

        for(String t: tokens){
            if(t.equals("+")){
                int first = aq.pop();
                int second = aq.pop();
                int result = second + first;
                aq.push(result);
            } else if(t.equals("*")){
                int first = aq.pop();
                int second = aq.pop();
                int result = second * first;
                aq.push(result);
            } else if(t.equals("/")){
                int first = aq.pop();
                int second = aq.pop();
                if(second == 0) {
                    aq.push(0);
                } else {
                    int result = second / first;
                aq.push(result);
                }
            } else if(t.equals("-")){
                int first = aq.pop();
                int second = aq.pop();
                int result = second - first;
                aq.push(result);
            } else {
                aq.push(Integer.parseInt(t));
            }

            System.out.println(aq);
        }

        return aq.pop();
    }
}

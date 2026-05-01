class Solution {
    private boolean stringIsNumber(String s){
        if (s.isEmpty()) return false;
        for(char c: s.toCharArray()){
            if(!Character.isDigit(c)){
                return false;
            }
        }

        return true;
    }

    public String decodeString(String s) {
        Deque<String> aq = new ArrayDeque<>();
        String res = "";
        boolean newPush = false;

        for(Character c: s.toCharArray()){
            // [ - new entry on stack
            if(c == '['){
                newPush = true;
            }
            // ] - keep popping till you reach a number. Calculate and push new str to stack
            else if(c == ']'){
                String top = "";
                String push = "";
                while(!aq.isEmpty() && !stringIsNumber(aq.peek())){
                    top = aq.pop() + top;
                }
                int number = Integer.parseInt(aq.pop());
                for(int i = 0; i < number; i++){
                    push = push.concat(top);
                }
                aq.push(push);
            }
            // numbers - add to stack
            else if(Character.isDigit(c)){
                if(!aq.isEmpty() && stringIsNumber(aq.peek()) && !newPush){
                    String p = aq.pop();
                    aq.push(p.concat(String.valueOf(c)));
                } else {
                    aq.push(String.valueOf(c));
                }
                newPush = false;
            }
            // characters - pop and add to same element
            else {
                if(newPush){
                    aq.push(String.valueOf(c));
                    newPush = false;
                    continue;
                }
                
                if(!aq.isEmpty() && !stringIsNumber(aq.peek())){
                    String popped = aq.pop();
                    aq.push(popped.concat(String.valueOf(c)));
                } else {
                    aq.push(String.valueOf(c));
                }
            }
        }

        // process remaining elements on stack
        while(!aq.isEmpty()){
            res = aq.pop() + res;
        }

        return res;
    }
}
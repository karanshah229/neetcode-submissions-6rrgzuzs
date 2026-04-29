class Solution {
    public boolean isValid(String s) {
        ArrayDeque<Character> aq = new ArrayDeque<Character>();

        for(Character c: s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                aq.push(c);
            } else {
                if(aq.isEmpty()) return false;

                char popped = aq.pop();
                if(c == ')' && popped != '('){ return false; }
                if(c == '}' && popped != '{'){ return false; }
                if(c == ']' && popped != '['){ return false; }
            }
        }

        if(!aq.isEmpty()) return false;
        return true;
    }
}

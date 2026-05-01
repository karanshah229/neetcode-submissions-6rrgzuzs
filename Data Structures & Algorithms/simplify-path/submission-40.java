class Solution {
    public String simplifyPath(String path) {
        Deque<String> aq = new ArrayDeque<>();
        String[] splitPaths = path.split("/");

        // push / at start
        // aq.push("/");

        for(String p: splitPaths){
            // empty - ignore
            if(p.equals("") || p.equals(".")) continue;
            // 2 dots - pop top element if exists
            if(p.equals("..")){
                System.out.println("2 dots - " + aq);
                if(!aq.isEmpty()) aq.pop();
            }
            // fallback - push
            else aq.push(p);
        }
        
        // System.out.println(aq);

        StringBuilder sb = new StringBuilder();
        Iterator<String> it = aq.descendingIterator();

        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) sb.append("/");
        }
        String result = sb.toString();
        result = "/".concat(result);

        // System.out.println(result);

        return result;
    }
}
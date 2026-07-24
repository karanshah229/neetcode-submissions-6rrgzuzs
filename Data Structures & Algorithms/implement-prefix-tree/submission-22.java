class Node {
    char val;
    Map<Character, Node> next;
    boolean isWord;

    public Node(char val){
        this.val = val;
        this.next = new HashMap<>();
        this.isWord = false;
    }
}

class PrefixTree {
    Node head;

    public PrefixTree() {
        head = new Node('.');
    }

    public void insert(String word) {
        Node curr = head;
        for(char ch: word.toCharArray()){
            curr.next.putIfAbsent(ch, new Node(ch));
            curr = curr.next.get(ch);
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        Node curr = head;
        for(char ch: word.toCharArray()){
            if(!curr.next.containsKey(ch)) return false;
            else curr = curr.next.get(ch);
        }
        return curr.isWord;
    }

    public boolean startsWith(String prefix) {
        Node curr = head;
        for(char ch: prefix.toCharArray()){
            if(!curr.next.containsKey(ch)) return false;
            else curr = curr.next.get(ch);
        }
        return true;
    }
}

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

class WordDictionary {
    Node head;

    public WordDictionary() {
        head = new Node('.');
    }

    public void addWord(String word) {
        Node curr = head;
        for(char ch: word.toCharArray()){
            curr.next.putIfAbsent(ch, new Node(ch));
            curr = curr.next.get(ch);
        }
        curr.isWord = true;
    }

    private boolean search(String word, Node curr, int index){
        if(word.length() == 1) {
            if(word.charAt(0) == '.'){
                // any of curr.next is a word
                for(Node c: curr.next.values()){
                    if(c.isWord) return true;
                }
                return false;
            }
            return curr.next.containsKey(word.charAt(0)) &&
            curr.next.get(word.charAt(0)).isWord;
        }

        char ch = word.charAt(0);
        if(ch == '.'){
            for(char k: curr.next.keySet()){
                if(search(
                    word.substring(1, word.length()),
                    curr.next.get(k),
                    index+1
                )) return true;
            }
            return false;
        }

        if(!curr.next.containsKey(ch)) return false;
        curr = curr.next.get(ch);

        return search(word.substring(1, word.length()), curr, index+1);
    }

    public boolean search(String word) {
        return search(word, head, 0);
    }
}

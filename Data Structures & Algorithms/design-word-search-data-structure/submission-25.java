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
        if(index == word.length()-1) {
            if(word.charAt(index) == '.'){
                for(Node c: curr.next.values()){
                    if(c.isWord) return true;
                }
                return false;
            }
            return curr.next.containsKey(word.charAt(index)) &&
            curr.next.get(word.charAt(index)).isWord;
        }

        char ch = word.charAt(index);
        if(ch == '.'){
            for(char k: curr.next.keySet()){
                if(search(
                    word,
                    curr.next.get(k),
                    index+1
                )) return true;
            }
            return false;
        }

        if(!curr.next.containsKey(ch)) return false;
        curr = curr.next.get(ch);

        return search(word, curr, index+1);
    }

    public boolean search(String word) {
        return search(word, head, 0);
    }
}

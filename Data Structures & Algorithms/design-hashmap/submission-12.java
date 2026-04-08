class Node {
    int key, val;
    Node next;

    public Node(int key, int val){
        this.key = key;
        this.val = val;
    }

    public Node(int key, int val, Node next){
        this.key = key;
        this.val = val;
        this.next = next;
    }
}

class MyHashMap {
    static final int SIZE = 1000;
    Node[] list;

    static int getIndex(int key){
        return key % SIZE;
    }

    public MyHashMap() {
        list = new Node[SIZE];
    }
    
    public void put(int key, int value) {
        int index = getIndex(key);
        
        if(list[index] == null) {
            list[index] = new Node(key, value);
            return;
        }

        Node curr = list[index];
        while(curr.next != null && curr.key != key) curr = curr.next;
        if(curr.key == key) curr.val = value;
        else curr.next = new Node(key, value);
    }
    
    public int get(int key) {
        int index = getIndex(key);
        
        Node curr = list[index];
        while(curr != null){
            if(curr.key == key) return curr.val;
            curr = curr.next;
        }

        return -1;
    }
    
    public void remove(int key) {
        int index = getIndex(key);
        
        Node curr = list[index];
        Node prev = null;
        while(curr != null) {
            if(curr.key == key) {
                if(prev == null) list[index] = curr.next;
                else prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
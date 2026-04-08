class MyHashSet {
    ArrayList<Integer> al;

    public MyHashSet() {
        this.al = new ArrayList<>();
    }
    
    public void add(int key) {
        if(!this.contains(key)) al.add(key);
    }
    
    public void remove(int key) {
        if(this.contains(key)) {
            int index = al.indexOf(key);
            al.remove(index);
        }
    }
    
    public boolean contains(int key) {
        return al.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
class LRUCache {
    class ListNode {
        int key;
        int value;
        ListNode prev;
        ListNode next;

        ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<Integer, ListNode> hm;
    private int capacity;
    private int size;
    private ListNode head;
    private ListNode tail;

    public LRUCache(int capacity) {
        this.hm = new HashMap<>();
        this.capacity = capacity;
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    private void remove(ListNode node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
    }

    private void insertToTail(ListNode node) {
        node.prev = tail;
        node.next = null;

        if (tail != null) {
            tail.next = node;
        } else {
            head = node;
        }

        tail = node;
    }

    public int get(int key) {
        if (!hm.containsKey(key)) return -1;

        ListNode node = hm.get(key);
        if (node != tail) {
            remove(node);
            insertToTail(node);
        }

        return node.value;
    }

    public void put(int key, int value) {
        if (hm.containsKey(key)) {
            ListNode node = hm.get(key);
            node.value = value;
            if (node != tail) {
                remove(node);
                insertToTail(node);
            }
            return;
        }

        ListNode node = new ListNode(key, value);
        hm.put(key, node);
        insertToTail(node);
        size++;

        if (size > capacity) {
            ListNode lru = head;
            remove(lru);
            hm.remove(lru.key);
            size--;
        }
    }
}

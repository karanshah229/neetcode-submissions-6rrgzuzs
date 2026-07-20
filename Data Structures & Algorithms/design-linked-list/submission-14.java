class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}

class MyLinkedList {
    Node head;

    public MyLinkedList() {
        head = null;
    }

    public int get(int index) {
        Node curr = head;
        while (index-- > 0 && curr.next != null) {
            curr = curr.next;
        }
        return index >= 0 ? -1 : curr.val;
    }

    public void addAtHead(int val) {
        Node newHead = new Node(val);
        if (head != null)
            newHead.next = head;
        head = newHead;
    }

    public void addAtTail(int val) {
        Node curr = head;
        Node newTail = new Node(val);
        while (curr.next != null) curr = curr.next;
        curr.next = newTail;
    }

    public void addAtIndex(int index, int val) {
        Node curr = head;
        Node newNode = new Node(val);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            while (index-- > 1 && curr.next != null) {
                curr = curr.next;
            }
            if(index > 1) return;
            Node temp = curr.next;
            curr.next = newNode;
            newNode.next = temp;
        }
    }

    public void deleteAtIndex(int index) {
        Node curr = head;
        while (index-- > 1 && curr.next != null) {
            curr = curr.next;
        }
        curr.next = curr.next != null ? curr.next.next : null;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
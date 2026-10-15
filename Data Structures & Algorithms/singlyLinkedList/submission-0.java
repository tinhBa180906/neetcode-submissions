class LinkedList {
 
    public class Node {

        int val;
        Node nextNode;

        public Node() {
        }

        public Node(int val, Node nextNode) {
            this.val = val;
            this.nextNode = nextNode;
        }
        
        
    }
    
    Node head, tail;
    

    public LinkedList() {
        head = null;
    }
    
    
    

    public int get(int index) {
        Node run = head;
        int i = 0;
        while (run != null && i < index) {
            run=run.nextNode;
            i++;
        }
        
        if (run == null) return -1;
        return run.val;
    }

    public void insertHead(int val) {
        Node newNode = new Node(val, head);
        head = newNode;
        
    }

    public void insertTail(int val) {
         Node newNode = new Node(val, null);
        Node prev = null;
        Node run = head;
        while (run != null) {
            prev = run;
            run = run.nextNode;
        }
        
        if (prev == null) head = newNode;
        else {
            prev.nextNode = newNode;
        }

    }

    public boolean remove(int index) {
        if (index < 0 || head == null) return false;
        
        if (index == 0) {
            head = head.nextNode;
            return true;
        }
        
        Node prev = head;
        Node current = head.nextNode;
        int i = 1;
        while (current != null && i < index) {
            
            prev = current;
            current = current.nextNode;
            i++;
        }
        if (current == null) return false;
        
        prev.nextNode = current.nextNode;
        current.nextNode = null;
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> list = new ArrayList<>();
        Node run = head;
        while (run != null) {
            list.add(run.val);
            run = run.nextNode;
        }
        return list;
    }
}

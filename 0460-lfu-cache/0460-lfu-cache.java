class LFUCache {
    int minF;                          // Current minimum frequency
    Map<Integer, Node> cache;         // Key → Node mapping
    Map<Integer, DLL> freq;           // Frequency → DLL of nodes
    int cap;                           // Cache capacity

    public LFUCache(int capacity) {
        cap = capacity;
        cache = new HashMap<>();
        freq = new HashMap<>();
        minF = 0;
    }

    // Ensure a DLL exists for the given frequency
    void check(int currentF) {
        if (!freq.containsKey(currentF)) {
            freq.put(currentF, new DLL());
        }
    }

    // Add node into DLL for its frequency
    void add(int currentF, Node node) {
        check(currentF);
        DLL dll = freq.get(currentF);
        // Insert right after head
        node.right = dll.head.right;
        node.left = dll.head;
        dll.head.right.left = node;
        dll.head.right = node;
    }

    // Remove node from its frequency list
    void remove(int currentF, Node node) {
        node.left.right = node.right;
        node.right.left = node.left;
    }

    // Evict least frequently used node at freq = currentF
    void remove(int currentF) {
        DLL dll = freq.get(currentF);
        Node lru = dll.tail.left;
        cache.remove(lru.key);
        remove(currentF, lru);
    }

    // If old frequency list is empty and equals minF, bump minF
    void updateMinF(int oldF) {
        DLL dll = freq.get(oldF);
        if (dll.head.right == dll.tail && oldF == minF) {
            minF++;
        }
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) return -1;

        int oldF = node.f;
        remove(oldF, node);           // remove from old freq list
        node.f++;                     // increment frequency
        add(node.f, node);            // add to new freq list
        cache.put(key, node);         
        updateMinF(oldF);             // adjust minF if needed
        return node.val;
    }

    public void put(int key, int val) {
        if (cap == 0) return;

        Node node = cache.get(key);
        if (node != null) {
            // Key exists: update value and frequency
            int oldF = node.f;
            remove(oldF, node);
            node.f++;
            node.val = val;
            add(node.f, node);
            cache.put(key, node);
            updateMinF(oldF);
        } else {
            // New key
            if (cache.size() == cap) {
                // Evict LFU node
                remove(minF);
            }
            Node newNode = new Node(key, val, 1);
            add(1, newNode);           // insert with freq = 1
            cache.put(key, newNode);
            minF = 1;                  // reset min frequency
        }
    }

    // Node of doubly linked list
    class Node {
        int key, val, f;             // key, value, frequency
        Node left, right;            // DLL pointers
        Node(int key, int val, int f){
            this.key = key;
            this.val = val;
            this.f = f;
        }
    }

    // Doubly linked list with dummy head/tail
    class DLL {
        Node head, tail;
        DLL() {
            head = new Node(-1, -1, -1);
            tail = new Node(-1, -1, -1);
            head.right = tail;
            tail.left = head;
        }
    }
}

class LRUCache {
    class Node{
        int key, value;
        Node prev, next;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    private final int capacity;
    private final Map<Integer, Node> cache;
    private final Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev  = head;
    }
    public void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public void addToFront(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
    public void moveToFront(Node node){
        removeNode(node);
        addToFront(node);
    }
    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        moveToFront(node);  //recently used so keep it in front
        return node.value;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            node.value = value;
            moveToFront(node);
        }else{
            if(cache.size() == capacity){
                cache.remove(tail.prev.key);
                removeNode(tail.prev); 
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addToFront(newNode);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
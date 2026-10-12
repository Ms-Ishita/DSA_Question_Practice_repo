public class lru_cache {
    static class Node {
        int key;
        int value;
        Node previous;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final java.util.Map<Integer, Node> cache = new java.util.HashMap<>();
    private final Node head = new Node(0, 0);
    private final Node tail = new Node(0, 0);

    public lru_cache(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative");
        }
        this.capacity = capacity;
        head.next = tail;
        tail.previous = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToFront(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            moveToFront(node);
            return;
        }

        if (cache.size() == capacity) {
            Node leastRecentlyUsed = tail.previous;
            remove(leastRecentlyUsed);
            cache.remove(leastRecentlyUsed.key);
        }

        node = new Node(key, value);
        cache.put(key, node);
        addToFront(node);
    }

    private void moveToFront(Node node) {
        remove(node);
        addToFront(node);
    }

    private void remove(Node node) {
        node.previous.next = node.next;
        node.next.previous = node.previous;
    }

    private void addToFront(Node node) {
        node.next = head.next;
        node.previous = head;
        head.next.previous = node;
        head.next = node;
    }

    public static void main(String[] args) {
        lru_cache cache = new lru_cache(2);

        cache.put(1, 10);
        cache.put(2, 20);
        System.out.println(cache.get(1));

        cache.put(3, 30);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
    }
}

package gc.cache;

import java.util.HashMap;

public class LRUCache {

    private HashMap<Integer, Node> map;
    private DoubleList cache;
    private int cap;

    public LRUCache(int cap) {
        this.cap = cap;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int val = map.get(key).val;
        put(key, val); // 利用put方法把数据置前
        return val;
    }

    public void put(int key, int val) {
        Node node = new Node(key, val);
        if (map.containsKey(key)) {
            cache.remove(map.get(key)); // 删除旧的节点，新的节点插入头部
            cache.addFirst(node);
            map.put(key, node); // 更新map中的数据
        } else {
            if (cap == map.size()) {
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            cache.addFirst(node);
            map.put(key, node);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }

}

class DoubleList {

    private Node head;
    private Node tail;


    public DoubleList() {
        // 双方向
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public void addFirst(Node node) {
        // 注意双方向
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    public void remove(Node node) {
        // 注意删除2个方向的
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public Node removeLast() {
        Node node = tail.prev;
        remove(node);
        return node;
    }

}

class Node {
    public int key, val;
    public Node next, prev;

    public Node() {
    }

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

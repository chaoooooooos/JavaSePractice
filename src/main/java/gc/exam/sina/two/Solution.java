package gc.exam.sina.two;

import java.util.HashMap;

/**
 * @author gengchao
 * @date 2019/8/31 15:40
 * @description：
 */
public class Solution {
    private HashMap<Integer, Node> map;
    private DoubleList cache;
    private int cap;
    public Solution(int capacity) {
        this.cap = capacity;
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

    public void put(int key, int value) {
        Node node = new Node(key, value);
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
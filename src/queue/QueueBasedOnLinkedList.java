package queue;

/**
 * @author glows777
 * @description 链表实现的队列 -> 无队满情况
 */
public class QueueBasedOnLinkedList {

    /** 队列的队首和队尾*/
    private Node head = null;
    private Node tail = null;

    private static class Node {
        private String data;
        private Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }
        public String getData() {
            return data;
        }
    }
    /**@description 入队 */
    public void enqueue(String value) {
        // 队空
        if (tail == null) {
            Node newNode = new Node(value, null);
            head = newNode;
            tail = newNode;
        } else {
            tail.next = new Node(value, null);
            tail = tail.next;
        }
    }
    /**@description 出队 */
    public String dequeue() {
        // 队空
        if (head == null) {
            return null;
        }
        String data = head.data;
        head = head.next;
        // 判断是否队列出队后已经空了 空了的话 尾指针要指空
        if (head == null) {
            tail = null;
        }
        return data;
    }

    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }
}

package linkedList;




/**
 * @author glows777
 * @description
 *      1）回文字符串判断的单链表
 *      2）实现单链表简单的操作
 *      3) 假设data是int类型
 */
public class SingleLinkedList {

    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }

    /**
     * 定义头结点
     **/
    private Node head = null;

    /**
     * 通过值查找结点
     */
    public Node findNodeByValue(int value) {
        Node p =head;
        while(p != null && p.data != value) {
            p = p.next;
        }
        return p;
    }

    /**
     * 通过索引（位置）查找
     **/
    public Node findNodeByIndex(int index) {
        Node p =head;
        int pos = 0;

        while(p != null && pos != index) {
            p = p.next;
            pos++;
        }
        return p;
    }

    /**
     * 无头结点
     * 表头部插入
     * 这种操作将于输入的顺序相反，逆序
     **/
    public void insertToHead(int value) {
        Node newNode = new Node(value, null);
        insertToHead(newNode);
    }

    public void insertToHead(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }







}

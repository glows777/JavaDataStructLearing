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
    public void insertNodeToHead(int value) {
        Node newNode = new Node(value, null);
        insertNodeToHead(newNode);
    }

    public void insertNodeToHead(Node newNode) {
        // 如果链表是空的
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    /**
     * 顺序插入
     * 链表尾部插入
     **/
    public void insertNodeTail(int value){
        Node newNode = new Node(value, null);
        // 如果链表是空的
        if (head == null) {
            head = newNode;
        } else {
            Node q = head;
            while (q.next != null) {
                q = q.next;
            }
            //  newNode.next = q.next; 这一句，q.next可替换为null 都一样
            newNode.next = q.next;
            q.next = newNode;
        }
    }

    /**
     * 在某结点后插入
     **/
    public void insertNodeAfter(Node p, int value) {
        Node newNode = new Node(value, null);
        insertNodeAfter(p, newNode);
    }
    public void insertNodeAfter(Node p, Node newNode) {
        // 判断被插入的节点p是否存在
        if (p == null) {
            return;
        }

        newNode.next = p.next;
        p.next = newNode;
     }

    /**
     * 在某结点前插入
     **/
    public void insertNodeBefore(Node p, Node newNode) {
      if (p == null) {
          return;
      }
      // 判断是否为首结点
      if (head == null) {
          insertNodeToHead(newNode);
          return;
      }

      Node q = head;
      // 寻找p节点的前一个结点
      while(q != null && q.next != p) {
          q = q.next;
      }
      // 防止p节点不在链表中，也就是q节点是尾结点时，还未找到p结点的前一个结点
      if (q == null) {
          return;
      }
      newNode.next = p;
      q.next = newNode;
    }




}

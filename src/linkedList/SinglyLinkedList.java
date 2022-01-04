package linkedList;
/**
 * @author glows777
 * @description
 *      1）回文字符串判断的单链表
 *      2）实现单链表简单的操作
 *      3) 假设data是int类型
 */
public class SinglyLinkedList {

    public static void main(String[] args) {
        SinglyLinkedList link = new SinglyLinkedList();

        // 测试数据
        //int[] data = {1};
        //int[] data = {1,2};
        int[] data = {1,2,3,1};
        //int[] data = {1,2,5};
//        int[] data = {1,2,2,1};
//         int[] data = {1,2,5,2,1};
//        int[] data = {1,2,5,3,1};
        for (int datum : data) {
            //link.insertToHead(data[i]);
            link.insertNodeTail(datum);
        }

        System.out.println("原来的：");
        link.printAll();

        if (link.palindrome()){
            System.out.println("回文");
        } else {
            System.out.println("不是回文");
        }

    }

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

    public static Node createNode(int value) {
        return new Node(value, null);
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
    public void insertNodeBefore(Node p, int value) {
        Node newNode = new Node(value, null);
        insertNodeBefore(p, newNode);
    }

    /**
     * 删除指定结点
     **/
    public void deleteByNode(Node p) {
        if (p == null || head == null) {
            return;
        }
        if (p == head) {
            head = head.next;
            return;
        }

        Node q = head;
        while (q.next != null && q.next != p) {
            q = q.next;
        }
//        if ( q == null) {
//            return;
//        }
        // 或者 q.next = q.next,next;
        q.next = p.next;
    }
    /**
     * 删除指定值的结点
     **/
    public void deleteByValue(int value) {
        if (head == null) {
            return;
        }

        // p做查找时的临时，q作为data值为value的结点的前一个结点
        Node p = head;
        Node q = null;
        while (p != null && p.data != value) {
            q = p;
            p = p.next;
        }
        if (p == null) {
            return;
        }
        // q == null 代表要删除的是头结点
        if (q == null) {
            head = head.next;
        } else {
            q.next = q.next.next;
        }
    }

    /**
     * 打印所有结点
     **/
    public void printAll() {
        Node p = head;

        while(p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    /**
     * 反转链表
     * 带头结点 -> inverseLinkListHead -> p为原来整个链表的头结点
     * 无头结点的链表翻转 -> inverseLinkList
     *
     **/
    public Node inverseLinkListHead(Node p){
        //　Head　为新建的一个头结点
        Node Head = new Node(9999, null);

        Head.next = p;

        /*
        带头结点的链表翻转等价于
        从第二个元素开始重新头插法建立链表
        */
        Node Cur = p.next;
        p.next = null;
        Node next;

        while( Cur != null) {
            next = Cur.next;
            Cur.next = Head.next;
            Head.next = Cur;
            System.out.println("first " + Head.data);
            Cur = next;
        }
        return Head;
    }

    // 这个不太理解
    public Node inverseLinkList(Node p){
        Node pre = null;
        Node r = head;

        Node next;
        while (r != p) {
            next = r.next;
            r.next = pre;
            pre = r;
            r = next;
        }
        r.next = pre;
        return r;
    }


    /**
     * 判断左右结点是否每一个都相等
     **/
    public boolean judgeResult(Node left, Node right){

        Node l = left;
        Node r = right;
        boolean flag = true;

        while (l != null && r != null) {
            if (l.data == r.data) {
                l = l.next;
                r = r.next;
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }

    /**
     * 判断是不是回文数
     **/
    public boolean palindrome(){
        if (head == null) {
            return false;
        } else {
            System.out.println("==================    开始寻找中间结点   =========================");

            Node p = head;
            Node q = head;
             if ( p.next == null) {
                 return true;
             }
             // 关键步骤 -> 快慢指针
             while (q.next != null && q.next.next != null) {
                 p = p.next;
                 q = q.next.next;
             }
            System.out.println("=============================     找到了       ==================================");

             Node left;
             Node right;

             // p为奇数的中点
             if (q.next == null) {
                 right = p.next;
                 left = inverseLinkList(p).next;
//                 System.out.println("是奇数");
                 System.out.println("左边第一个节点" + left.data);
                 System.out.println("右边第一个节点" + right.data);
             } else {
                 // 偶数，两个各自开始
//                 System.out.println("是偶数");
                 right = p.next;
                 left = inverseLinkList(p);
                 System.out.println("左边第一个节点" + left.data);
                 System.out.println("右边第一个节点" + right.data);
             }
             return judgeResult(left, right);
        }
    }

    }

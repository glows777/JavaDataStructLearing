package linkedList;

/**
 * @author glows777
 * 主要练习5个链表的常见操作
 * 1）单链表反转
 * 2）链表中环的检测
 * 3）两个有序的链表合并
 * 4）删除链表倒数第 n 个结点
 * 5）求链表的中间结点
 */
public class LinkedListCommonExercise {

    public static void printAll(Node list) {
        Node p = list;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static Node createNode(int value) {
        return new Node(value, null);
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

    /**
     * 反转链表
     * 借助三个指针，这样不会丢失结点，同时又能原地修改
     **/
    public static Node reverse(Node list) {
        Node cur = list;
        Node pre = null;

        while (cur != null) {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 检查环
     * 快慢指针
     **/
    public static boolean checkCircle(Node list) {
        if (list == null) {
            return false;
        }

        Node fast = list.next;
        Node low = list;

        while (fast != null && fast.next != null) {

            // 后面测试顺序
            low = low.next;
            fast = fast.next.next;
            if (low == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * 合并有序列表
     * 创建第三条链表去存结果
     * 无头指针
     **/
    public static Node mergeSortedLists(Node la, Node lb) {
        if (la == null) {
            return lb;
        }
        if (lb == null) {
            return la;
        }
        Node p = la;
        Node q = lb;
        Node head;
        if (p.data < q.data) {
            head = p;
            p = p.next;
        } else {
            head = q;
            q = q.next;
        }
        Node r = head;

        while (p != null && q != null) {
            if (p.data < q.data) {
                r.next = p;
                p = p.next;
            } else {
                r.next = q;
                q = q.next;
            }
            r = r.next;
        }
        if (p != null) {
            r.next = p;
        } else {
            r.next = q;
        }
        return head;
    }
    /**
     * 优化合并链表
     * 利用哨兵优化简化实现难度
     * 哨兵占住头指针，这样后面推进即可，最后返回哨兵的下一位，即新链表的头结点
     **/
     public static class ListNode {
         int val;
        ListNode next;
        ListNode(int x) { val = x; }
     }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode soldier = new ListNode(0);
        ListNode p = soldier;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                p.next = l2;
                l2 = l2.next;
            } else {
                p.next = l1;
                l1 = l1.next;
            }
            p = p.next;
        }
        if (l1 != null) {
            p.next = l1;
        }
        if (l2 != null) {
            p.next = l2;
        }
        return soldier.next;
    }

    /**
     * 求中间结点
     * 双指针，快慢（快的一次2步，慢的一次1步），快的走完时，慢的刚好是中点
     **/
    public static Node findMiddleNode(Node list) {
        if(list == null) {
            return null;
        }

        Node fast = list;
        Node slow = list;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 删除导数第k个结点
     * 双指针，快指针先走k步，然后两个指针开始一起走，当快指针走完整个链表时，慢指针的位置就是删除的结点的前一个结点
     * 但是，如果刚好是删除第一个结点，那么不会进入循环，pre指针仍然是null，需要做特判
     **/
    public static Node deleteLastKth(Node list, int k) {

        Node fast = list;
        int i = 1;
        // 快指针先走k步
        while (i != k && fast != null) {
            fast = fast.next;
            i++;
        }
        if (fast == null) {
            return null;
        }
        Node slow = list;
        Node pre = null;
        while (fast != null) {
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }
        // 删除的是第一个结点
        if (pre == null) {
            list = list.next;
        } else {
            pre.next = pre.next.next;
        }
        return list;
    }

}

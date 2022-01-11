package stack;

/**
 * @author glows777
 */
public class StackBasedOnLinkedList {
    /**top指向栈顶元素*/
    private Node top = null;

    private static class Node {
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
     * 压栈
     */
    public void push(int val) {
        Node newNode = new Node(val, null);

        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    /**
     * 出栈
     * 返回栈顶的值，同时出栈
     */
    public int pop() {
        if (top == null) {
            // -1表示该栈为空
            return -1;
        }
        int val = top.data;
        top = top.next;
        return val;
    }

    /**
     * 打印栈的所有元素
     */
    public void printAll() {
        Node p = top;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }



}

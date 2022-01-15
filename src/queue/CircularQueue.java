package queue;

/**
 * @author glows777
 * @description 循环队列 数组实现
 * @description 队空为tail == head
 * @description 队满为(tail + 1)%n == head -> head和tail的更新条件是 (x+1)%n
 */
public class CircularQueue {
    /** @description 数组：items，数组大小：n */
    private String[] items;
    private int n = 0;
    /** @description head表示队头下标，tail表示队尾下标 */
    private int head = 0;
    private int tail = 0;

    /**@description 申请一个大小为capacity的数组 */
    public CircularQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }
    /**@description 入队 */
    public boolean enqueue(String item) {
        // 队列已满
        if ((tail + 1) % n == head) {
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }
    /**@description 出队 */
    public String dequeue() {
        // 队列为空
        if (tail == head) {
            return null;
        }

        String res = items[head];
        head = (head + 1) % n;
        return res;
    }
    /**@description 打印所有 */
    public void printAll() {
        if (n == 0) {
            return;
        }
        for (int i = head; i % n != head; i = (i + 1) % n) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }
}

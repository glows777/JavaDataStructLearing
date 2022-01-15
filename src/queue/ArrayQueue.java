package queue;

/**
 * @author glows777
 * @description 数组实现的队列 -> 最简易版
 */
public class ArrayQueue {
    // 数组：items，数组大小：n
    private String[] items;
    private int n = 0;
    // head表示队头下标，tail表示队尾下标
    private int head = 0;
    private int tail = 0;

    // 申请一个大小为capacity的数组
    public ArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }
    /** @description 入队 */
    public boolean enqueue(String item) {
        // 队列已满
        if (tail == n) {
            return false;
        }
        items[tail] = item;
        tail++;
        return true;
    }

    /** @description 出队 */
    public String dequeue() {
        // 表示队空
        if (head == tail) {
            return null;
        }
        String res = items[head];
        head++;
        return res;
    }

    public void printAll() {
        for (int i = head; i < tail; ++i) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }





}

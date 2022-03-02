package sort;

import java.util.Arrays;

/**
 * @author glows777
 * @description 冒泡，插入，选择排序的实现
 */
public class sort1 {
    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 2, 1, 5, 7, 6, 8};
//        bubbleSort(array, array.length);
        insertionSort(array, array.length);
//        selectionSort(array, array.length);
        System.out.println(Arrays.toString(array));
    }

    /** 冒泡排序 array表示数组，n表示数组大小*/
    public static void bubbleSort(int[] array, int n) {
        for(int i=0; i<n; i++) {
            // 用flag标志位表示是否有进行交换，没有的话，直接退出循环 -> 优化
            boolean flag = false;
            for(int j=0; j<n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    /** 插入排序*/
    public static void insertionSort(int[] array, int n) {
        for (int i=1;i < n; i++) {
            int value = array[i];
            int j = i -1;
            // 寻找插入位置
            for (;j >=0 ; j--) {
                if (array[j] > value) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            // 插入数据
            array[j + 1] = value;
        }
    }

    /** 选择排序*/
    public static void selectionSort(int[] array, int n) {
        if (n <= 1) return;
        for (int i=0; i < n -1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            int tmp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = tmp;
        }
    }
}

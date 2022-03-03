package sort;

import java.util.Arrays;

/**
 * @author glows777
 * @description 快排实现
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] test = new int[]{1, 9, 4, 3, 6, 2, 7, 8};
        quickSort(test, test.length);
        System.out.println(Arrays.toString(test));
    }


    // 快速排序，a是数组，n表示数组的大小
    public static void quickSort(int[] a, int n) {
        quickSortInternally(a, 0, n-1);
    }
    private static void quickSortInternally(int[] a,int l, int r) {
        if (l >= r) return;
        int pivot = partition(a, l, r);
        quickSortInternally(a, l, pivot - 1);
        quickSortInternally(a, pivot + 1, r);
    }
    private static int partition(int[] a, int l, int r) {
        int pivot = a[r];
        int i = l;
        int j = l;
        for(;j < r; j++) {
            if (a[j] < pivot) {
                if (i == j) {
                    i++;
                } else {
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                    i++;
                }
            }
        }
        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;
        return i;
    }
}
  
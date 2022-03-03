package sort;

import java.util.Arrays;

/**
 * @author glows777
 * @description 归并排序实现
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] test = new int[]{1, 5, 4, 6, 3, 2, 8, 0, 9, 7};
        mergeSort(test, test.length);
        System.out.println(Arrays.toString(test));
    }


    /** 归并排序算法, a是数组，n表示数组大小*/
    public static void mergeSort(int[] a, int n) {
        mergeSortInternally(a, 0, n-1);
    }

    private static void mergeSortInternally(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
//        int mid = (p + r) / 2; -> 可能会因为p+r过大而造成栈溢出
        int mid = l + (r - l) /2 ;
        mergeSortInternally(a, l, mid);
        mergeSortInternally(a, mid + 1, r);
        merge(a, l, mid, r);
    }

    private static void merge(int[] a, int l, int mid, int r) {
        int i = l;
        int j = mid + 1;
        int k = 0;
        int[] tmp = new int[r - l + 1];
        while (i <= mid && j <= r) {
            if(a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }
        // 判断哪一边的数组还有剩余 -> 先假设为前面的剩余，在判断后面部分是否剩余，没有剩余则前面剩余，有剩余，则重新赋值
        int start = i;
        int end = mid;
        if (j <= r) {
            start = j;
            end = r;
        }
        while (start <= end) {
            tmp[k++] = a[start++];
        }
        // 将tmp赋值给a的那一部分
        for (i = 0; i < r - l +1; i++) {
            a[l + i] = tmp[i];
        }
    }
}

package bSearch;

/**
 * @author glows777
 * @description 二分查找的四种变体
 */
public class BSearch {
    public static void main(String[] args) {
        int[] test = new int[]{1, 2, 3, 4, 4, 4, 4, 5, 6, 7, 8, 9, 10};
        int index = -1;
        index = searchFirst(test, test.length, 4);
//        index = searchLast(test, test.length, 4);
//        index = searchFirstBigger(test, test.length, 4);
//        index = searchLastSmaller(test, test.length, 4);
        System.out.println(index);
    }

    /**
     * 1. 查找第一个给定值的元素
     */
    public static int searchFirst(int[] a, int n, int value) {
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (a[mid] > value) {
                right = mid - 1;
            } else if (a[mid] < value) {
                left = mid + 1;
            } else {
                if (mid == 0 || a[mid - 1] != value) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 2. 查找最后一个给定值的位置
     */
    public static int searchLast(int[] a, int n, int value) {
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (a[mid] < value) {
                left = mid + 1;
            } else if (a[mid] > value) {
                right = mid - 1;
            } else {
                if (mid == n - 1 || a[mid + 1] != value) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }


    /**
     * 3. 查找第一个大于等于给定值的元素
     */
    public static int searchFirstBigger(int[] a, int n, int value) {
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (a[mid] >= value) {
                if (a[mid - 1] < value || mid == 0) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 4. 查找最后一个小于等于给定值的元素
     */
    public static int searchLastSmaller(int[] a, int n, int value) {
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (a[mid] <= value) {
                if (mid == n - 1 || a[mid + 1] > value) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}

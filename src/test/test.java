package test;

public class test {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0;
        int p2 = 0;
        int[] res = new int[m + n];
        int count = 0;
        while (p1 < m  || p2 < n ) {
            if (p1 == m) {
                res[count] = nums2[p2++];
            } else if (p2 == n) {
                res[count] = nums1[p1++];
            } else if (nums1[p1] > nums2[p2]) {
                res[count] = nums2[p2++];
            } else {
                res[count] = nums1[p1++];
            }
            count++;
        }
        for (int i = 0; i < m + n; i++) {
            nums1[i] = res[i];
            System.out.print(res[i] + " ");
        }

    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2, 5, 6};
        merge(nums1,3, nums2, 3);
    }
}

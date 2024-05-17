package easy;

public class Prob88 {
    /*
    给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，
    分别表示 nums1 和 nums2 中的元素数目。

    请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。

    注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，
    nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
     */

    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                nums[k++] = nums1[i++];
            } else {
                nums[k++] = nums2[j++];
            }
        }
        while (i < m) {
            nums[k++] = nums1[i++];
        }
        while (j < n) {
            nums[k++] = nums2[j++];
        }
        int t = 0;
        for (int num : nums) {
            nums1[t++] = num;
        }

        return nums1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = nums1.length - nums2.length;
        ;
        int n = nums2.length;
        nums1 = merge(nums1, m, nums2, n);
        for (int j : nums1) {
            System.out.print(j + " ");
        }
    }
}

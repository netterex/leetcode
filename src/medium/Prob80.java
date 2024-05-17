package medium;

public class Prob80 {
    /*
    给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，
    返回删除后数组的新长度。

    不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     */
    public static int removeDuplicates(int[] nums) {
        int p, q = 1;
        int count = 1;
        for (p = 1; p < nums.length; p++) {
            if (nums[p] != nums[p - 1]) { // 前后两个元素不相同时
                nums[q] = nums[p];
                q++;
                count = 1;
            } else if (nums[p] == nums[p - 1] && count < 2) { // 前后两个元素相同且出现次数少于两次时
                nums[q] = nums[p];
                q++;
                count++;
            } else { // 前后两个元素出现次数相同且出现次数超过两次
                count++;
            }
        }

        return q;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(removeDuplicates(nums));
    }
}

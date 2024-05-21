package medium;

public class Prob55 {
    /*
    给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。

    判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
     */
    public static boolean canJump(int[] nums) {
        int farthest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= farthest) {
                if (nums[i] + i > farthest) {
                    farthest = nums[i] + i;
                }
                if (farthest >= nums.length - 1) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {0};
        System.out.println(canJump(nums));
    }
}

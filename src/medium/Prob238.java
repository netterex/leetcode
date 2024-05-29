package medium;

public class Prob238 {
    /*
    给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积

    题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。

    请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
     */
    public static int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        answer[0] = 1;

        // 第一次for循环，计算nums中每个元素左侧所有元素之积
        for (int i = 1; i < nums.length; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        // t存储每个元素右侧所有元素之积
        int t = 1;
        // 第二次for循环，计算nums中每个元素右侧所有元素之积
        for (int i = nums.length - 2; i >= 0; i--) {
            t *= nums[i + 1];
            answer[i] = answer[i] * t;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] ans = productExceptSelf(nums);
        for (int an : ans) {
            System.out.print(an + " ");
        }
    }
}

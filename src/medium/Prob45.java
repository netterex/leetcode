package medium;

public class Prob45 {
    /*
    给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。

    每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，
    你可以跳转到任意 nums[i + j] 处:

    0 <= j <= nums[i]
    i + j < n
    返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
     */
    public static int jump(int[] nums) {
        int maxJump = 0;
        int end = 0;
        int step = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // 考虑当前索引位置能跳跃到的最远距离与目前最远距离的大小
            maxJump = Math.max(maxJump, i + nums[i]);
            if (maxJump >= nums.length - 1) {
                step++;
                break;
            }
            // 在到达每个最远位置之前，一定会跳跃一次
            if (i == end) {
                end = maxJump;
                step++;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1};
        System.out.println(jump(nums));
    }
}

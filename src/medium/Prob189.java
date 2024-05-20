package medium;

public class Prob189 {
    //给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。

    // 三次逆置
    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, k, nums.length - 1);
        reverse(nums, 0, k - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    // 环状替换
    /*public static void rotate(int[] nums, int k) {
        k %= nums.length;
        int count = 0;
        int isOver = 0;

        for (int start = 0; start < nums.length; start++) {
            int current = start;
            int temp = nums[current];
            do {
                int t = temp;
                temp = nums[(current + k) % nums.length];
                nums[(current + k) % nums.length] = t;
                current = (current + k) % nums.length;
                count++;
                if (count == nums.length) {
                    isOver = 1;
                    break;
                }
            } while (current != start);
            if (isOver == 1) {
                break;
            }
        }
    }*/

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}

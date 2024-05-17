package easy;

import java.util.Arrays;

public class Prob169 {
    /*
    给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。

    你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     */

    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        // return nums[nums.length / 2];
        int count = 1;
        int result = 0;

        if (nums.length == 1) {
            result = nums[0];
        } else {
            for (int i = 1; i < nums.length; i++) {
                result = nums[i];
                if (nums[i] == nums[i - 1]) {
                    count++;
                    if (count > nums.length / 2) {
                        result = nums[i];
                        break;
                    }
                } else {
                    count = 1;
                }
            }
        }

        return result;
    }

    public static int boyerMoore(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
//        System.out.println(majorityElement(nums));
        System.out.println(boyerMoore(nums));
    }
}

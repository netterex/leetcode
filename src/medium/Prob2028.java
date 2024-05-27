package medium;

import java.util.Arrays;

public class Prob2028 {
    /*
    现有一份 n + m 次投掷单个 六面 骰子的观测数据，骰子的每个面从 1 到 6 编号。观测数据中缺失了 n 份，
    你手上只拿到剩余 m 次投掷的数据。幸好你有之前计算过的这 n + m 次投掷数据的 平均值 。

    给你一个长度为 m 的整数数组 rolls ，其中 rolls[i] 是第 i 次观测的值。同时给你两个整数 mean 和 n 。

    返回一个长度为 n 的数组，包含所有缺失的观测数据，且满足这 n + m 次投掷的 平均值 是 mean 。
    如果存在多组符合要求的答案，只需要返回其中任意一组即可。如果不存在答案，返回一个空数组。

    k 个数字的 平均值 为这些数字求和后再除以 k 。

    注意 mean 是一个整数，所以 n + m 次投掷的总和需要被 n + m 整除。
     */
    public static int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = mean * (rolls.length + n);
        int sumN = sum - Arrays.stream(rolls).sum();
        if (sumN < n || sumN > 6 * n) { // 当缺失数组的和小于缺失数组的长度或者大于缺失数组长度的六倍时
            return new int[0];
        } else {
            int[] res = new int[n];
            int biggerCount = sumN % n;
            int smallerNum = sumN / n;
            for (int i = 0; i < n; i++) {
                if (biggerCount > 0) {
                    res[i] = smallerNum + 1;
                    biggerCount--;
                } else {
                    res[i] = smallerNum;
                }
            }
            return res;
        }

    }

    public static void main(String[] args) {
        int[] rolls = {3,2,4,3};
        int[] nums = missingRolls(rolls, 4, 2);
        for (int anInt : nums) {
            System.out.println(anInt);
        }
    }
}

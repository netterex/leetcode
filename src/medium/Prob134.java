package medium;

public class Prob134 {
    /*
    在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。

    你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。
    你从其中的一个加油站出发，开始时油箱为空。

    给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。
    如果存在解，则 保证 它是 唯一 的。
     */
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int start;
        boolean isSuccess = false;
        int position = 0;
        for (start = 0; start < gas.length; start++) {
            int i = start;
            int remaining = 0;
            int count = 0;
            while (count < gas.length) {
                remaining = remaining + gas[i] - cost[i];
                if (remaining >= 0) {
                    i = (i + 1) % gas.length;
                    count++;
                } else {
                    break;
                }
            }
            if (count == gas.length) {
                isSuccess = true;
                position = start;
                break;
            } else {
                start = start + count;
            }
        }
        if (isSuccess) {
            return position;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] gas = {4,5,2,6,5,3};
        int[] cost = {3,2,7,3,2,9};
        System.out.println(canCompleteCircuit(gas, cost));
    }
}

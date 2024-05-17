package medium;

import java.util.HashMap;
import java.util.Map;

public class Prob2244 {
    /*
    给你一个下标从 0 开始的整数数组 tasks ，其中 tasks[i] 表示任务的难度级别。
    在每一轮中，你可以完成 2 个或者 3 个 相同难度级别 的任务。

    返回完成所有任务需要的 最少 轮数，如果无法完成所有任务，返回 -1 。
     */
    public static int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        // 统计每个难度的出现次数
        for ( int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        int min = 0;
        for (int times : map.values()) {
            if (times == 1) { // 当只出现1次时，必定无法完成
                min = -1;
                break;
            } else if (times % 3 == 0) {
                min += times / 3;
            } else {
                min += times / 3 + 1;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] tasks = {2, 2, 3, 3, 2, 4, 4, 4, 4, 4};
        System.out.println(minimumRounds(tasks));
    }
}

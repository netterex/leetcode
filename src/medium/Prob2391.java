package medium;

public class Prob2391 {
    /*
    给你一个下标从 0 开始的字符串数组 garbage ，其中 garbage[i] 表示第 i 个房子的垃圾集合。
    garbage[i] 只包含字符 'M' ，'P' 和 'G' ，但可能包含多个相同字符，每个字符分别表示一单位的金属、纸和玻璃。
    垃圾车收拾 一 单位的任何一种垃圾都需要花费 1 分钟。

    同时给你一个下标从 0 开始的整数数组 travel ，其中 travel[i] 是垃圾车从房子 i 行驶到房子 i + 1 需要的分钟数。

    城市里总共有三辆垃圾车，分别收拾三种垃圾。每辆垃圾车都从房子 0 出发，按顺序 到达每一栋房子。
    但它们 不是必须 到达所有的房子。

    任何时刻只有 一辆 垃圾车处在使用状态。当一辆垃圾车在行驶或者收拾垃圾的时候，另外两辆车 不能 做任何事情。

    请你返回收拾完所有垃圾需要花费的 最少 总分钟数。
     */

    public static int garbageCollection(String[] garbage, int[] travel) {
        int i = 0;
        int last_m = 0, last_g = 0, last_p = 0;
        int m_count = 0, g_count = 0, p_count = 0;
        for (i = 0; i < garbage.length; i++) {
            if (garbage[i].contains("M")) { // 判断是否有M
                last_m = i;
                m_count += garbage[i].length() - garbage[i].replace("M", "").length();
            }
            if (garbage[i].contains("G")) { // 判断是否有G
                last_g = i;
                g_count += garbage[i].length() - garbage[i].replace("G", "").length();
            }
            if (garbage[i].contains("P")) { // 判断是否有P
                last_p = i;
                p_count += garbage[i].length() - garbage[i].replace("P", "").length();
            }
        }
        int min_time = m_count + g_count + p_count;
        for (i = 0; i < travel.length; i++) {
            if (last_m > i) {
                min_time += travel[i];
            }
            if (last_g > i) {
                min_time += travel[i];
            }
            if (last_p > i) {
                min_time += travel[i];
            }
        }
        return min_time;
    }

    public static void main(String[] args) {
        String [] garbage = new String[]{"G", "P", "GP", "GG"};
        int [] travel = {2, 4, 3};
        System.out.println(garbageCollection(garbage, travel));

    }
}

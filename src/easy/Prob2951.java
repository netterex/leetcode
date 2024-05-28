package easy;

import java.util.ArrayList;
import java.util.List;

public class Prob2951 {
    /*
    给你一个下标从 0 开始的数组 mountain 。你的任务是找出数组 mountain 中的所有 峰值。

    以数组形式返回给定数组中 峰值 的下标，顺序不限 。

    注意：

    峰值 是指一个严格大于其相邻元素的元素。
    数组的第一个和最后一个元素 不 是峰值。
     */
    public static List<Integer> findPeaks(int[] mountain) {
        List<Integer> peaks = new ArrayList<>();
        for (int i = 1; i < mountain.length - 1; i++) {
            if(mountain[i] > mountain[i-1] && mountain[i] > mountain[i+1]) {
                peaks.add(i);
            }
        }
        return peaks;
    }

    public static void main(String[] args) {
        int[] mountain = {2,4,4};
        List<Integer> peaks = findPeaks(mountain);
        System.out.println(peaks);
    }
}

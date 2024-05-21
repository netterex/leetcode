package easy;

public class Prob2769 {
    /*
    给你两个整数 num 和 t 。

    如果整数 x 可以在执行下述操作不超过 t 次的情况下变为与 num 相等，则称其为 可达成数字 ：

    每次操作将 x 的值增加或减少 1 ，同时可以选择将 num 的值增加或减少 1 。
    返回所有可达成数字中的最大值。可以证明至少存在一个可达成数字。
     */
    public static int theMaximumAchievableX(int num, int t) {
        return num + 2 * t;
    }

    public static void main(String[] args) {
        int num = 4;
        int t = 1;
        System.out.println(theMaximumAchievableX(num, t));
    }
}

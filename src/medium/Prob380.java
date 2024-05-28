package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Prob380 {
    /*
    实现RandomizedSet 类：

    RandomizedSet() 初始化 RandomizedSet 对象
    bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
    bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
    int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。
    每个元素应该有 相同的概率 被返回。
    你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。
     */
    static class RandomizedSet {
        private final HashSet<Integer> set;

        public RandomizedSet() {
            set = new HashSet<>();
        }

        public boolean insert(int val) {
            if (set.contains(val)) {
                return false;
            } else {
                set.add(val);
                return true;
            }
        }

        public boolean remove(int val) {
            if (set.contains(val)) {
                set.remove(val);
                return true;
            } else {
                return false;
            }
        }

        public int getRandom() {
            ArrayList<Integer> list = new ArrayList<>(set);
            int i = new Random().nextInt(set.size());
            return list.get(i);
        }
    }

    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        System.out.println(obj.insert(1));
        System.out.println(obj.remove(2));
        System.out.println(obj.insert(2));
        System.out.println(obj.getRandom());
        System.out.println(obj.remove(1));
        System.out.println(obj.insert(2));
        System.out.println(obj.getRandom());
    }
}

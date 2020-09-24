package array.two_sum.jim;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 *
 * https://leetcode-cn.com/problems/two-sum/
 *
 * @author Jim Chen
 * @date 2020-09-22
 */
public class App001 {

    public static void main(String[] args) {
        // 这种数据样例，在一遍hash时，逻辑是有问题的，对应输出的是4,6
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        int target = 10;

//        int[] nums = new int[]{2, 7, 11, 15};
//        int target = 9;

        System.out.println(Arrays.toString(twoSum(nums, target)));
        // 推荐，易懂
        System.out.println(Arrays.toString(twoSumWithTwoHash(nums, target)));

        System.out.println(Arrays.toString(twoSumWithOneHash(nums, target)));
    }

    /**
     * 1遍hash表
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    private static int[] twoSumWithOneHash(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            // TODO 结果可能有问题
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 2遍hash表
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    private static int[] twoSumWithTwoHash(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        return null;
    }

    /**
     * 固定数组中第一个数，再去找第二个数
     *
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * @param nums
     * @param target
     * @return
     */
    private static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

}

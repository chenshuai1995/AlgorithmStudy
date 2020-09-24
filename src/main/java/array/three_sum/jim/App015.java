package array.three_sum.jim;

import java.util.*;

/**
 * 15. 三数之和
 *
 * https://leetcode-cn.com/problems/3sum/
 *
 * @author Jim Chen
 * @date 2020-09-24
 */
public class App015 {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};

        System.out.println(threeSumWith3Loop(nums));

        System.out.println(threeSumWithHash(nums));

        // TODO 排序+双指针，没理解

    }

    /**
     * 三数之和的问题，可以转换成两数之和(a+b=0) -> a + b = -c(target)
     *
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n)
     *
     * @param nums
     * @return
     */
    private static List<List<Integer>> threeSumWithHash(int[] nums) {
        Set<List<Integer>> result = new LinkedHashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int target = -nums[i];
            Map<Integer, Integer> hashMap = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++) {
                int v = target - nums[j];
                Integer exist = hashMap.get(v);
                if (exist != null) {
                    List<Integer> list = Arrays.asList(nums[i], exist, nums[j]);
                    list.sort(Comparator.naturalOrder());
                    result.add(list);
                } else {
                    // 利用hashMap省掉一次loop，直接可以从hashMap中找
                    hashMap.put(nums[j], nums[j]);
                }
            }
        }
        return new ArrayList<>(result);
    }

    /**
     * 三重loop
     *
     * 时间复杂度：O(n^3)
     * 空间复杂度：O(n)
     *
     * @param nums
     * @return
     */
    private static List<List<Integer>> threeSumWith3Loop(int[] nums) {
        // TODO 为什么要排序？
        Arrays.sort(nums);

        Set<List<Integer>> lists = new LinkedHashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] == -nums[k]) {
                        lists.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return new ArrayList<>(lists);
    }


}

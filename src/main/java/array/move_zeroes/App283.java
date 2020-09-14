package array.move_zeroes;

import java.util.Arrays;

/**
 * 283. 移动零
 *
 * https://leetcode-cn.com/problems/move-zeroes/
 *
 * @author Jim Chen
 * @date 2020-09-14
 */
public class App283 {

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};

        // 暴力解法：每次判断是0，向后面元素交换位置
        moveZeroesWithForce(nums);

		moveZeroes(nums);

		// 双指针之2次循环
        moveZeroesWithTwoLoops(nums);

        // 双指针之1次循环
        moveZeroesWithOneLoop(nums);
    }

    /**
     * 双指针之1次循环
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param nums
     */
    private static void moveZeroesWithOneLoop(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            //当前元素!=0，就把其交换到左边，等于0的交换到右边
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    /**
     * 双指针之2次循环：
     * 1. 第一次循环，用j指针记录非0的个数，且nums[j]为非0元素
     * 2. 第二次循环，遍历剩下都是0的元素，赋值为0
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param nums
     */
    private static void moveZeroesWithTwoLoops(int[] nums) {
        // 第一次遍历的时候，j指针记录非0的个数，只要是非0的统统都赋给nums[j]
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }

        //非0元素统计完了，剩下的都是0了
        //所以第二次遍历把末尾的元素都赋为0即可
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }

        System.out.println(Arrays.toString(nums));
    }

    /**
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        int j = 0;// 新加入的元素存放的index位置
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    /**
     * 暴力算法：
     * 2层loop，外层loop是要循环的轮数，里面loop是每一轮中，要和后面的元素对比是否是0，是则交换位置
     *
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     *
     * @param nums
     */
    public static void moveZeroesWithForce(int[] nums) {
        for (int i = 0; i < nums.length; i++) { // 要循环多少轮

            for (int j = 0; j < nums.length; j++) { // 每一轮中，对比后面的元素，是0则交换位置
                if (nums[j] == 0 && j < nums.length - 1) {
                    // 交换
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }

        System.out.println(Arrays.toString(nums));
    }

}

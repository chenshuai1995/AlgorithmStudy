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

        /*
         * 1. 暴力解法：每次判断是0，向后面元素交换位置
         */

        moveZeroes(nums);

//		moveZeroes2(nums);
    }

    /**
     *
     * @param nums
     */
    public static void moveZeroes2(int[] nums) {
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
     * 每次遇到0，交换位置
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && i < nums.length -1) {
                // 交换

                int tmp = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] = tmp;
            }
        }

        System.out.println(Arrays.toString(nums));
    }

}

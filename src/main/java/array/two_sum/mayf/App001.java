package array.two_sum.mayf;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 001.两数之和
 * https://leetcode-cn.com/problems/two-sum/
 * @Author mayufeng
 * @CreateTime 2020/9/15 3:24 下午
 **/
public class App001 {

    public static void main(String[] args) {

        int [] nums = {4, 4, 11, 15 , 3 , 5};
        int target = 8;

        try {

            System.out.println(Arrays.toString(twoSum(nums,target)));

        } catch (Exception e) {

            System.err.println("can not found two index!!");

        }

    }

    /**
     * 使用hash操作进行获取
     * @param nums
     * @param target
     * @return
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     */
    public static int[] twoSum(int[] nums, int target) throws Exception {

        int[] indexArr = new int[2];

        HashMap map = new HashMap();

        for (int i = 0; i < nums.length; i++){

            map.put(nums[i],i);

            if (map.containsKey(target-nums[i])){

                if ((int) map.get(target-nums[i]) != i){

                    indexArr[1] = i;

                    indexArr[0] = (int) map.get(target-nums[i]);

                    return indexArr;

                }

            }

        }

        throw new Exception();

    }

}

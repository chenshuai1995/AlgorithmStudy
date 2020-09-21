package array.move_zeroes.mayf;

import java.util.Arrays;

/**
 * @Author mayufeng
 * @CreateTime 2020/9/13 3:19 下午
 **/
public class App283 {

    public static void main(String[] args) {

        int[] nums = {0,1,0,3,12,34234,888,0,0,0,0,28,0,0};

        int[] arrs = moveZeroes(nums);

        System.out.println(Arrays.toString(arrs));

    }

    /**
     * 一次循环数组，记录0出现次数zeroNum，并对不为0的数进行前移，前移偏量为zeroNum
     * @param nums
     * @return
     */
    public static int[] moveZeroes(int[] nums) {

        int zeroNum = 0;

        for (int i = 0; i < nums.length; i++){

            if (nums[i] == 0){

                zeroNum++;

            }else{

                nums[i-zeroNum] = nums[i];

            }

        }

        for (int i = nums.length-zeroNum; i < nums.length; i++){

            nums[i] = 0;

        }

        return nums;
    }

}

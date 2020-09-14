package com.algorithm.array.climbing_stairs.mayf;

/**
 * 70.爬楼梯
 * https://leetcode.com/problems/climbing-stairs/
 * @Author mayufeng
 * @CreateTime 2020/9/14 12:24 下午
 **/
public class App070 {

    public static void main(String[] args) {

        int maxNum = climbStairs(20);

        System.out.println(maxNum);

    }

    /**
     * 使用递阶方法进行计算
     * @param n 楼梯阶数
     * @return  maxNum 爬楼梯最多方法
     */
    public static int climbStairs(int n) {

        int maxNum = 0;

        int preStep = 1;    // 第N-2阶登楼梯方法数，默认值取1，为第0阶
        int nexStep = 1;    // 第N-1阶登楼梯方法数，默认值取1，为第1阶

        /**
         * 从第2阶楼梯开始，登楼梯最大方法数maxNum = nextStep + preStep
         */
        for (int i = 1; i < n; i++){

            // 计算第i+1阶爬楼梯方法数
            maxNum = preStep + nexStep;

            // 赋值给下一次计算
            preStep = nexStep;
            nexStep = maxNum;

        }

        return maxNum;

    }

}

package array.container_with_most_water.mayf;

/**
 * 11.盛最多水的容器
 * https://leetcode-cn.com/problems/container-with-most-water/
 *
 * @Author mayufeng
 * @CreateTime 2020/9/12 1:18 下午
 **/
public class App011 {

    public static void main(String[] args) {

        // 输入一个数组表示a1——an
        int [] heights = {1,8,6,2,5,4,8,3,8};

        // 双指针解法
        int maxArea = forceCalMaxArea(heights);

        System.out.println(maxArea);

    }

    /**
     * 循环遍历数组长度值，根据比对端点两边X值大小，移动值小的点
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     * @param heights
     * @return
     */
    public static int forceCalMaxArea(int[] heights){

        int maxArea = 0;
        int height = 0;

        int leftIndex = 0;
        int rightIndex = heights.length-1;
        int tempArea = 0;

        for ( ;rightIndex>leftIndex ;){

            height = heights[leftIndex]<heights[rightIndex]?heights[leftIndex++]:heights[rightIndex--];

            tempArea = height*(rightIndex-leftIndex+1);

            maxArea = Math.max(maxArea,tempArea);


        }

        return maxArea;

    }

}

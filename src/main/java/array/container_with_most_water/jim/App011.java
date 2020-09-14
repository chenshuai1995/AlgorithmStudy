package array.container_with_most_water.jim;

/**
 * 11. 盛最多水的容器
 *
 * https://leetcode-cn.com/problems/container-with-most-water/
 * https://leetcode.com/problems/container-with-most-water/
 *
 * @author Jim Chen
 * @date 2020-09-12
 */
public class App011 {

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};

        // 暴力解法
        System.out.println(maxAreaWithForce(height));

        // 双指针解法：推荐
        System.out.println(maxAreayWithTwoPointer(height));

        // 双指针解法：使用while循环替换上面的for循环
        System.out.println(maxAreayWithTwoPointer2(height));

        // 双指针解法：变形
        System.out.println(maxAreayWithTwoPointer3(height));
    }

    /**
     * 双指针解法：
     *
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param height
     * @return
     */
    private static int maxAreayWithTwoPointer(int[] height) {
        int maxArea = 0;
        for ( int l = 0, r = height.length - 1; l < r; ) {
            int minHeight = height[l] < height[r] ? height[l++] : height[r--];
            // 因为上面三目运算的时候，l+1，或者r-1了，所以，导致下面计算面积的时候，长度要+1
            int area = minHeight * (r - l + 1);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }

    /**
     * 双指针解法：
     * 使用while循环替换上面的for循环
     * @param height
     * @return
     */
    private static int maxAreayWithTwoPointer2(int[] height) {
        int maxArea = 0;
        int l = 0, r = height.length -1;

        while ( l < r ) {
            int minHeight = height[l] < height[r] ? height[l++] : height[r--];
            int area = minHeight * (r - l + 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    private static int maxAreayWithTwoPointer3(int[] height) {
        int maxArea = 0;
        int l = 0, r = height.length -1;

        while ( l < r ) {
            int minHeight = height[l] < height[r] ? height[l] : height[r];
            int area = minHeight * (r - l); // 上面指针不移动的话，这里就不用+ 1
            maxArea = Math.max(maxArea, area);

            if (height[l] < height[r]) {
                l ++;
            } else {
                r --;
            }
        }
        return maxArea;
    }

    /**
     * 暴力解法：
     * 1、利用2层for循环，第1层for循环固定左边界，第2层for循环右边界向后移动
     * 2、每次算出当前的区域area，和最大区域maxArea比较，返回最大区域
     *
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     *
     * @param height 高度数组
     * @return
     */
    private static int maxAreaWithForce(int[] height) {
        int maxArea = 0;
        for (int l = 0; l < height.length; l++) {
            for (int r = l + 1; r < height.length; r++) {
                int minHeight = Math.min(height[l], height[r]);
                int area = minHeight * (r - l);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

}

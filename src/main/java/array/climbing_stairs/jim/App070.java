package array.climbing_stairs.jim;

/**
 * 70. 爬楼梯
 * <p>
 * https://leetcode-cn.com/problems/climbing-stairs/
 *
 * @author Jim Chen
 * @date 2020-09-22
 */
public class App070 {

    public static void main(String[] args) {
        int n = 10;

        // 递归方式，思路简单，傻递归
        System.out.println(climbStairs(n));

        // 优化成循环
        System.out.println(climbStairsWithLoop(n));

        // 优化成一个循环中，只使用3个中间变量(推荐)
        System.out.println(climbStairsLoopWithoutTmpParams(n));
    }

    /**
     * 优化成一个循环中，只使用3个中间变量
     * @param n
     * @return
     */
    private static int climbStairsLoopWithoutTmpParams(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int first = 1;
        int second = 2;
        int sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = first + second;

            // 把最近的2个变量赋值给最近的2个临时变量
            first = second;
            second = sum;
        }

        return sum;
    }

    /**
     * 优化成循环
     * 但是a[]中存了很多不必要的中间变量，只需要3个就可以了
     *
     * 时间复杂度：O(n)
     * @param n
     * @return
     */
    private static int climbStairsWithLoop(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] a = new int[n + 1];
        a[1] = 1;
        a[2] = 2;
        for (int i = 3; i <= n; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }

        return a[n];
    }

    /**
     * 本质上，求斐波拉契数列的问题
     * f(n)=f(n-1)+f(n-2)
     *
     * 如何优化成尾递归？
     *
     * 时间复杂度：2^n
     *
     *
     * @param n
     * @return
     */
    private static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }


}

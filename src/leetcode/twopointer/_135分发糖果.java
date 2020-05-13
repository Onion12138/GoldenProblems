package leetcode.twopointer;

import java.util.Arrays;

/**
 * @author onion
 * @date 2020/4/26 -4:12 下午
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 *
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 *
 */
public class _135分发糖果 {
    public int candy(int[] ratings) {
        int sum = 0;
        int[] left2right = new int[ratings.length];
        int[] right2left = new int[ratings.length];
        Arrays.fill(left2right, 1);
        Arrays.fill(right2left, 1);
        for (int i = 1; i < ratings.length; i++)
            if (ratings[i] > ratings[i - 1])
                left2right[i] = left2right[i - 1] + 1;
        for (int i = ratings.length - 2; i >= 0; i--)
            if (ratings[i] > ratings[i + 1])
                right2left[i] = right2left[i + 1] + 1;
        for (int i = 0; i < ratings.length; i++)
            sum += Math.max(left2right[i], right2left[i]);
        return sum;
    }
}

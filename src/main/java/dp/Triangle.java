package dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 *
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 说明：
 *
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 */
public class Triangle {

    public static void main(String[] args) {
        List<Integer> tmp1 = new ArrayList<Integer>();
        tmp1.add(2);
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        triangle.add(tmp1);
        List<Integer> tmp2 = new ArrayList<Integer>();
        tmp2.add(3);
        tmp2.add(4);
        triangle.add(tmp2);
        List<Integer> tmp3 = new ArrayList<Integer>();
        tmp3.add(6);
        tmp3.add(5);
        tmp3.add(7);
        triangle.add(tmp3);
        List<Integer> tmp4 = new ArrayList<Integer>();
        tmp4.add(4);
        tmp4.add(1);
        tmp4.add(8);
        tmp4.add(3);
        triangle.add(tmp4);
        System.out.println(triangle);
        System.out.println(minimumTotal(triangle));
    }

    /**
     * 这道题的关键在于理清楚上下两层之间的关系，
     * 这里为了方便，直接用当前层的元素存储之前的计算结果，这样既节省空间也方便运算
     * 为方便描述，直接使用数组表示，只考虑一般情况，即不考虑边界问题，
     * 假设i为当前层，则i-1为上一层，j为当前层元素的下标
     * [
     *      [2],
     *     [3,4],
     *    [6,5,7],
     *   [4,1,8,3]
     * ]
     * 则之前的路径和可以表示为
     * 如果sum[i-1][j-1]小于sum[i-1][j]
     * 则sum[i][j] = sum[i-1][j-1]+sum[i][j]
     * 否则sum[i][j] = sum[i-1][j]+sum[i][j]
     * 以上为不考虑边界的一般公式
     * 下面考虑边界情况
     *
     * 如果j为当前行的第一个元素，则在上层只有一个元素可以到达此位置
     * 则sum[i][j] = sum[i-1][j]+sum[i][j]
     *
     * 如果j为当前行的最后一个元素，同理可得
     * sum[i][j] = sum[i-1][j-1]+sum[i][j]
     * @param triangle
     * @return
     */
    private static int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        if(row == 0 ){
            return 0;
        }
        if(row == 1){
            return triangle.get(0).get(0);
        }

        for(int i = 1;i<row;i++){
            for(int j=0;j<triangle.get(i).size();j++){
                if(j==0){
                    triangle.get(i).set(j,triangle.get(i-1).get(j)+triangle.get(i).get(j));
                }else if(j==triangle.get(i).size()-1){
                    triangle.get(i).set(j,triangle.get(i-1).get(j-1)+triangle.get(i).get(j));
                }else{
                    int left = triangle.get(i-1).get(j-1);
                    int right = triangle.get(i-1).get(j);
                    int min = left>right?right:left;
                    triangle.get(i).set(j, min+triangle.get(i).get(j));
                }
                System.out.println(triangle.get(i));
            }
        }
        return Collections.min(triangle.get(row-1));
    }
}

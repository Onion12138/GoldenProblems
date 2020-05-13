package leetcode.trick;

/**
 * @author onion
 * @date 2020/4/26 -2:30 下午
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 */
public class _73矩阵置零 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean col = false;
        boolean row = false;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                    if(i == 0)
                        row = true;
                    if(j == 0)
                        col = true;
                }
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(row){
            for(int i=0;i<n;i++)
                matrix[0][i] = 0;
        }
        if(col){
            for(int i=0;i<m;i++)
                matrix[i][0] = 0;
        }
    }
}

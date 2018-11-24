package leetcode;

public class p74_Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int low = 0;
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int high = rowLen * colLen - 1;
        int mid, i, j;
        while (low <= high) {
            mid = (low + high) / 2;
            i = mid / colLen;
            j = mid % colLen;
            if (matrix[i][j] > target) {
                high = mid - 1;
            } else if (matrix[i][j] < target) {
                low = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}

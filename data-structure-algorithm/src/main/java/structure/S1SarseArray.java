package structure;

import java.util.Arrays;

/**
 * 稀疏数组
 */
public class S1SarseArray {
    int[][] data;

    public S1SarseArray init(int[][] origin) {
        int rowNum = origin.length;
        int colNum = origin[0].length;
        int numCount = 0;
        for (int i = 0; i < origin.length; i++) {
            for (int j = 0; j < origin.length; j++) {
                if (origin[i][j] != 0) {
                    numCount++;
                }
            }
        }
        data = new int[numCount + 1][3];
        data[0][0] = rowNum;
        data[0][1] = colNum;
        data[0][2] = numCount;
        int currentDataRow = 1;//开始保存数据
        for (int i = 0; i < origin.length; i++) {
            for (int j = 0; j < origin.length; j++) {
                if (origin[i][j] != 0) {
                    data[currentDataRow][0] = i;
                    data[currentDataRow][1] = j;
                    data[currentDataRow][2] = origin[i][j];
                    currentDataRow++;
                }
            }
        }
        return this;
    }

    public int[][] getOrigin() {
        int rowNum = data[0][0];
        int colNum = data[0][1];
        int numCount = data[0][2];
        int[][] origin = new int[rowNum][colNum];
        for (int i = 1; i < numCount + 1; i++) {
            int row = data[i][0];
            int col = data[i][1];
            int value = data[i][2];
            origin[row][col] = value;
        }
        return origin;
    }

    public static void main(String[] args) {
        S1SarseArray init = new S1SarseArray().init(new int[][]{
                {0, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}
        });
        int[][] origin = init.getOrigin();
        System.out.println(Arrays.deepToString(origin));
    }

}

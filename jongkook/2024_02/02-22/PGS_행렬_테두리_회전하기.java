import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int rows, int cols, int[][] queries) {
        int len = queries.length;
        int[] answer = new int[len];
        int row = rows + 1;
        int col = cols + 1;

        int[][] newMatrix = new int[row][col];
        int[][] oldMatrix = setMatrix(row, col, newMatrix);

        for(int l = 0; l < len; l++){
            int y1 = queries[l][0];
            int x1 = queries[l][1];
            int y2 = queries[l][2];
            int x2 = queries[l][3];
            answer[l] = rotate(y1, x1, y2, x2, oldMatrix, newMatrix);
            clone(oldMatrix, newMatrix, row, col);
        }
        return answer;
    }

    int[][] setMatrix(int row, int col, int[][] newMatrix){
        int[][] matrix = new int[row][col];
        int value = 0;
        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                matrix[i][j] = ++value;
                newMatrix[i][j] = value;
            }
        }
        return matrix;
    }


    int rotate(int y1, int x1, int y2, int x2, int[][] oldMatrix, int[][] newMatrix){
        int min = Integer.MAX_VALUE;

        newMatrix[y1][x1] = oldMatrix[y1+1][x1];
        for(int x = x1; x < x2; x++) {
            int changeValue = oldMatrix[y1][x];
            newMatrix[y1][x+1] = changeValue;
            min = Math.min(min, changeValue);
        }

        for(int y = y1; y < y2; y++) {
            int changeValue = oldMatrix[y][x2];
            newMatrix[y+1][x2] = changeValue;
            min = Math.min(min, changeValue);
        }

        for(int x = x2; x > x1; x--) {
            int changeValue = oldMatrix[y2][x];
            newMatrix[y2][x-1] = changeValue;
            min = Math.min(min, changeValue);
        }
        System.out.println();
        for(int y = y2; y > y1; y--) {
            int changeValue = oldMatrix[y][x1];
            newMatrix[y-1][x1] = changeValue;
            min = Math.min(min, changeValue);
        }
        return min;
    }
    void clone(int[][] oldMatrix, int[][] newMatrix, int row, int col){
        for(int r = 0; r < row; r++)
            for(int c = 0; c < col; c++)
                oldMatrix[r][c] = newMatrix[r][c];

    }
}
package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_18808_스티커_붙이기 {
    static int col, row, N, littleCol, littleRow;
    static StringTokenizer st;
    static boolean[][] map;
    static boolean[][] currentShape;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new boolean[row][col];
        while(N-- > 0){
            st = new StringTokenizer(br.readLine());
            littleRow = Integer.parseInt(st.nextToken());
            littleCol = Integer.parseInt(st.nextToken());
            currentShape = new boolean[littleRow][littleCol];

            for(int r = 0; r < littleRow; r++){
                st = new StringTokenizer(br.readLine());
                for(int c = 0; c < littleCol; c++){
                    if(Integer.parseInt(st.nextToken()) == 0) continue;
                    currentShape[r][c] = true;
                }
            }
            find();
        }
        System.out.println(countShape());
    }

    static void find(){
        int rotateCnt = 4;
        for(int i = 0; i < rotateCnt; i++){
            if(i != 0 ) {
                currentShape = changeShape();
                littleRow = currentShape.length;
                littleCol = currentShape[0].length;
            }
            for(int r = 0; r < row - littleRow + 1; r++){
                for(int c = 0; c < col - littleCol + 1; c++){
                    if (mappingShape(r, c)) return;
                }
            }
        }
    }
    static boolean[][] changeShape(){
        boolean[][] rotateShape = new boolean[littleCol][littleRow];

        for(int r = 0; r < littleRow; r++){
            for(int c = 0; c < littleCol; c++){
                rotateShape[c][littleRow - r - 1] = currentShape[r][c];
            }
        }
        return rotateShape;
    }
    static boolean mappingShape(int pr, int pc){
        for(int r = pr; r < pr + littleRow; r++){
            for(int c = pc; c < pc + littleCol; c++){
                int currentShapeRow = r - pr;
                int currentShapeCol = c - pc;
                if(map[r][c] && currentShape[currentShapeRow][currentShapeCol]) return false;
            }
        }

        for(int r = pr; r < pr + littleRow; r++){
            for(int c = pc; c < pc + littleCol; c++){
                int currentShapeRow = r - pr;
                int currentShapeCol = c - pc;
                if(currentShape[currentShapeRow][currentShapeCol]) map[r][c] = true;

            }
        }
        return true;
    }

    static int countShape(){
        int result = 0;

        for(int r = 0; r < row; r++){
             for(int c = 0; c < col; c++){
                if(map[r][c]) result++;
            }
        }
        return result;
    }
}

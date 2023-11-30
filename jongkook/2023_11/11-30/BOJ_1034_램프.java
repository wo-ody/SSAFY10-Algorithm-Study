package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1034_램프 {
    static int row, col, max = Integer.MIN_VALUE;
    static int[][] lamp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        lamp = new int[col][row];

        for(int c = 0; c < col; c++){
            String s = br.readLine();
            for(int r = 0; r < row; r++){
                lamp[c][r] = s.charAt(r) - '0';
            }
        }
        int k = Integer.parseInt(br.readLine());

        for(int i = 0; i < col; i++){
            int zeroCount = 0;
            int sameCount = 0;

            for(int j = 0; j < row; j++) {
                if(lamp[i][j] == 0) zeroCount++;
            }

            if(zeroCount <= k && zeroCount % 2 == k % 2){
                for(int j = 0; j < row; j++){
                    if(same(lamp[i], lamp[j])) sameCount++;
                }
            }
            max = Math.max(sameCount, max);
        }
        System.out.println(max);

    }
    static void printArray(){
        for(int c = 0; c < col; c++){
            System.out.println(Arrays.toString(lamp[c]));
        }
    }
    static boolean same(int[] array, int[] array2){
        for(int r = 0; r < row; r++){
            if(array[r] != array2[r]) return false;
        }
        return true;
    }
}

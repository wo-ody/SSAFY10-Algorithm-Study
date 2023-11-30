import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class SWEA_1974_스도쿠_검증 {
    static int sudoku[][], T;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src\\input\\swea_1974_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            int result = 1;
            sudoku = new int[9][9];
            for(int i = 0; i < 9; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 9; j++){
                    sudoku[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i < 9; i++) {
                if(!check(i)) {
                    result = 0;
                    break;
                }
            }

            if(!checkSquare()) result = 0;

            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        System.out.println(sb.toString());
    }
    static boolean check(int start){
        int[] colList = new int[9];
        int[] rowList = new int[9];
        for(int c = 0; c < 9; c++){
            if(c % 3 == 0){

            }

            int col = sudoku[c][start];
            int row = sudoku[start][c];

            if(isDup(colList, col)) return false;
            if(isDup(rowList, row)) return false;

            colList[c] = col;
            rowList[c] = row;
        }
        return true;
    }

    static boolean isDup(int[] arr, int el){
        for (int j : arr) if (j == el) return true;
        return false;
    }

    static boolean checkSquare(){
        for(int i = 0; i < 9; i += 3){
            for(int j = 0; j < 9; j += 3){
                HashSet<Integer> set = new HashSet<>();
                for(int k = i; k < i+3; k++){
                    for(int p = j; p < j+3; p++){
                        set.add(sudoku[k][p]);
                    }
                }
                if(set.size() != 9) return false;
            }
        }
        return true;
    }
}

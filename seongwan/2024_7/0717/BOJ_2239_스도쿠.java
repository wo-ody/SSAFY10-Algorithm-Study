import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] board = new int[9][9];
    static List<int[]> blanks = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        //입력
        for (int i = 0; i < 9; i++) {
            String s = br.readLine();
            for (int j = 0; j < 9; j++) {
                board[i][j] = s.charAt(j) - '0';
                if (board[i][j] == 0) {
                    blanks.add(new int[]{i, j});
                }
            }
        }

        solve(0);
    }

    static boolean checkDo(int r, int c) {
        int temp = board[r][c];

        //가로,세로 확인
        for (int i = 0; i < 9; i++) {
            if (i != c && board[r][i] == temp) return false;
            if (i != r && board[i][c] == temp) return false;
        }

        //영역별 확인
        int startR = (r / 3) * 3;
        int startC = (c / 3) * 3;
        for (int i = startR; i < startR + 3; i++) {
            for (int j = startC; j < startC + 3; j++) {
                if (i == r && j == c)
                    continue;

                if (board[i][j] == temp)
                    return false;
            }
        }
        return true;
    }

    static boolean solve(int level) {
        if (level == blanks.size()) {
            print();
            return true;
        }

        int r = blanks.get(level)[0];
        int c = blanks.get(level)[1];

        for (int i = 1; i <= 9; i++) {
            board[r][c] = i;
            if (checkDo(r, c) && solve(level + 1)) return true;
            board[r][c] = 0;
        }
        return false;
    }

    static void print() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
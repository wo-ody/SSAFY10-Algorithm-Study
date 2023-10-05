import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9290_틱택토_이기기 {
    static char[][] tictactoe;
    static char unit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        tictactoe = new char[3][3];
        for(int t = 1; t <= T; t++){
            for(int i = 0; i < 3; i++) tictactoe[i] = br.readLine().toCharArray();
            unit = br.readLine().charAt(0);
            sb.append("Case ").append(t).append(":").append("\n");
            play();
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    sb.append(tictactoe[i][j]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
    static void play() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tictactoe[i][j] == '-'){
                    if(isWin(i, j)){
                        tictactoe[i][j] = unit;
                        return;
                    }
                    else tictactoe[i][j] = '-';
                }
            }
        }
    }
    static boolean isWin(int x, int y){
        tictactoe[x][y] = unit;
        for(int i = 0; i < 3; i++){
            int width = 0;
            int height = 0;
            for(int j = 0; j < 3; j++){
                // 가로 검사
                if(tictactoe[i][j] == unit) width++;
                // 세로 검사
                if(tictactoe[j][i] == unit) height++;
            }
            if(width == 3 || height == 3) return true;
        }

        // 대각선 검사
        int count = 0;
        for(int i = 0; i < 3; i++){
            if(tictactoe[i][i] == unit) count++;
        }
        if(count == 3) return true;

        count = 0;
        int line = 2;
        for(int i = 0; i < 3; i++){
            if(tictactoe[i][line] == unit) count++;
            line--;
        }
        return count == 3;
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[][] map;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while(true){
            String str = br.readLine();
            if(str.equals("end")) break;

            map = new char[3][3];
            int idx = 0;

            int o = 0;
            int x = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    map[i][j] = str.charAt(idx);
                    idx++;
                    if(map[i][j] == 'O') o++;
                    else if(map[i][j] == 'X') x++;
                }
            }
            // 함수
            simulation(o,x);
        }

        System.out.println(sb);

    }

    static int return_cnt(char ch){
        int cnt = 0;
        if(map[0][0] == ch && map[1][1] == ch && map[2][2] == ch) cnt++;
        if(map[0][2] == ch && map[1][1] == ch && map[2][0] == ch) cnt++;
        for (int i = 0; i < 3; i++) {
            if(map[i][0] == ch && map[i][1] == ch && map[i][2] == ch) cnt++;
            if(map[0][i] == ch && map[1][i] == ch && map[2][i] == ch) cnt++;
        }
        return cnt;
    }


    static void simulation(int o, int x){
        if(o == x){ // 무조건 o 가 한줄씩 있는것
            int o_cnt = return_cnt('O');
            int x_cnt = return_cnt('X');

            if(o_cnt == 1 && x_cnt == 0 && o >= 3) sb.append("valid").append('\n');
            else sb.append("invalid").append('\n');

        }
        else if(o + 1 == x){

            int o_cnt = return_cnt('O');
            int x_cnt = return_cnt('X');

            if(o + x == 9) {
                if(o_cnt == 0) sb.append("valid").append('\n');
                else sb.append("invalid").append('\n');
            }
            else {
                if(x_cnt == 1 && o_cnt == 0 && x >= 3) sb.append("valid").append('\n');
                else sb.append("invalid").append('\n');
            }
        }
        else{
            sb.append("invalid").append('\n');
        }
    }

}

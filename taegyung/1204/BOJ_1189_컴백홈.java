package BOJ;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1189_컴백홈 {
    static char [][] map;
    static int R,C,K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         R = Integer.parseInt(st.nextToken());
         C = Integer.parseInt(st.nextToken());
         K = Integer.parseInt(st.nextToken());

        // 이건 범위가 넓지 않으니까 탐색으로 가자
        map = new char[R][C];

        visited = new boolean[R][C];
        for(int i = R -1; i >= 0 ; i --){
            map[i] = br.readLine().toCharArray();

        }

        System.out.println(dfs(0,0,0));



    }
    static int [] dx = {-1,0,0,1};
    static int [] dy = {0,-1,1,0};

    static boolean [][] visited;
    static int dfs(int i,int j,int cnt){

        if(i == R-1 && j == C-1 && cnt == K-1){
            return 1;
        }
        int sum = 0;
        visited[i][j] = true;
        for(int d = 0; d<4;d++){
            int nx = i + dx[d];
            int ny = j + dy[d];

            if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[nx][ny] && map[nx][ny] != 'T'){

                sum += dfs(nx,ny,cnt+1);

            }
        }
        visited[i][j] = false;

        return sum;
    }


}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17070_파이프옮기기 {
    static int N;
    static int[][] map;
    static int[][][] memoi;     //대각선, 우, 하

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N+1][N+1];        //0 dummy
        memoi = new int[3][N+1][N+1];   //0 dummy

        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //초기 파이프 설정
        memoi[1][1][2] = 1;

        for(int y=1; y<=N; y++){
            for(int x=2; x<=N; x++){
                //대각선
                if(y<N && x<N && map[y+1][x+1]==0 && map[y][x+1]==0 && map[y+1][x]==0)
                    memoi[0][y+1][x+1] += memoi[0][y][x] + memoi[1][y][x] + memoi[2][y][x];
                //가로
                if(x<N && map[y][x+1]==0)
                    memoi[1][y][x+1] += memoi[0][y][x] + memoi[1][y][x];
                //세로
                if(y<N && map[y+1][x]==0)
                    memoi[2][y+1][x] += memoi[0][y][x] + memoi[2][y][x];
            }
        }

        System.out.println(memoi[0][N][N] + memoi[1][N][N] + memoi[2][N][N]);
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17070_파이프옮기기 {

    static int N;
    static int[][] board;
    static int[][] visited;
    static int ans = 0;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력 및 초기화
        N = Integer.parseInt(br.readLine());
        board =new int[N+1][N+1];
        visited = new int[N+1][N+1];

        for(int i = 1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(1, 2, 0); // 끝점만 봐주면 됨
        System.out.println(ans);

    }

    public static void dfs(int x, int y, int dir){
        // 기저조건
        if(x == N && y == N){
            ans++;
            return;
        }
        switch (dir){
            case 0: // 가로 : 가로로 한칸, 대각선
                if(y+1<=N && board[x][y+1] == 0){
                    dfs(x, y+1, 0);
                }
                break;
            case 1: // 세로 : 세로로 한칸, 대각선
                if(x+1<=N && board[x+1][y] == 0){
                    dfs(x+1, y, 1);
                }
                break;
            case 2: // 대각 : 가로로 한칸, 세로로 한칸, 대각선
                if(y+1<=N && board[x][y+1] == 0){
                    dfs(x, y+1, 0);
                }
                if(x+1<=N && board[x+1][y] == 0){
                    dfs(x+1, y, 1);
                }
                break;

        }
        // 대각은 모두 공통이므로 바깥에 써줌
        if(y+1 <=N && x+1<=N && board[x][y+1]== 0 && board[x+1][y]== 0 && board[x+1][y+1] == 0){
            dfs(x+1, y+1, 2);
        }
    }

}

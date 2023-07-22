import java.util.Scanner;
import java.util.Stack;

public class 알파벳 {
    static int r;
    static int c;
    static int[][] board;
    static boolean[] visited = new boolean[26];

    static int ans = 0;

    static int[] dx = {0,0,1,-1};
    static int[] dy = {1, -1, 0,0};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();

        board = new int[r][c];

        for(int i = 0; i<r; i++){
            String tmp = sc.next();
            for(int j = 0; j<c; j++){
                board[i][j] = tmp.charAt(j) - 'A';
            }
        }

        DFS(0, 0, 0);
        System.out.println(ans);

    }

    static void DFS(int x, int y, int cnt){
        if(visited[board[x][y]]){
            ans = Math.max(ans, cnt);
            return;
        } else{
            visited[board[x][y]] = true;
            for(int i = 0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(inRange(nx, ny)){
                    DFS(nx, ny, cnt+1);
                }
            }
            visited[board[x][y]] = false;
        }

    }

    static boolean inRange(int x, int y){
        if(x <0 || x >=r || y<0 ||y>=c){
            return false;
        }
        return true;
    }
}

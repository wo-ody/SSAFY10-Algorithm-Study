import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

static int n, m;
static int board[][];

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    
    // 원점으로부터 i, j까지의 영역의 합 계산, 기록
    board = new int[n+1][n+1];

    for(int i = 1; i<=n; i++) {
        st = new StringTokenizer(br.readLine());
        for(int j = 1; j<=n; j++) {
            board[i][j] = board[i-1][j]+board[i][j-1] - board[i-1][j-1]+Integer.parseInt(st.nextToken());
        }
    }
    

    StringBuilder sb =new StringBuilder();

    for(int i = 0; i<m; i++) {
        st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        
        int sum = 0;
        
        sb.append(board[x2][y2] - board[x1-1][y2] - board[x2][y1-1] + board[x1-1][y1-1]);
        sb.append("\n");
    }
    System.out.println(sb.toString());
}
}

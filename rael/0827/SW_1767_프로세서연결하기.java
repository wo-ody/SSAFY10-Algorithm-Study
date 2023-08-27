import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
class pair{
    int x, y;
    pair(int x, int y) { this.x = x; this.y = y; }
}
 
public class SW_1767_프로세서연결하기 {
    private static int T, N, size, min;
    private static int arr[][], dx[] = {-1, 1, 0, 0}, dy[] = {0, 0, -1, 1};
    private static pair core[];
    private static boolean chk[];
     
    public static void combination(int idx, int cnt, int R) {
        if(cnt == R) {
            dfs(0, 0);
            return;
        }
        for(int i = idx; i < size; i++) {
            chk[i] = true;
            combination(i + 1, cnt + 1, R);
            chk[i] = false;
        }
    }
     
    public static void dfs(int idx, int cnt) {
        if(idx == size) {
            min = Math.min(min, cnt); // 배열 끝까지 돌렸으면 이때의 최솟값 갱신
            return;
        }
        if(!chk[idx]) { // 부분 집합에 포함되는 애들만 다음 단계로 넘어갈 수 있다.
            dfs(idx + 1, cnt);
            return;
        }
        for(int i = 0; i < 4; i++) {
            int x = core[idx].x, y = core[idx].y, tmp = 0;
            boolean success = false;
            while(true) {
                x += dx[i]; y += dy[i];
                if(x < 0 || x >= N || y < 0 || y >= N) { // 범위 끝까지 갔으면 성공
                    success = true;
                    break;
                }
                if(arr[x][y] != 0) break; // 전선이나 코어를 만나면 실패
                arr[x][y] = 2; // 전선 표시
                tmp++; // 전선 길이 합
            }
            if(success) dfs(idx + 1, cnt + tmp);
            while(true) { // 원 상태로 돌려놓기
                x -= dx[i]; y -= dy[i];
                if(x == core[idx].x && y == core[idx].y) break;
                arr[x][y] = 0;
            }
        }
    }
     
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N]; core = new pair[12]; chk = new boolean[12];
            size = 0; min = Integer.MAX_VALUE;
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
                 
            for(int i = 1; i < N - 1; i++) {
                for(int j = 1; j < N - 1; j++) {
                    if(arr[i][j] == 1) core[size++] = new pair(i, j); // 가장자리 빼고
                }
            }
             
            for(int i = size; i >= 0; i--) {
                combination(0, 0, i);
                if(min < Integer.MAX_VALUE) break; // 최솟값이 갱신되어 있으면 결과가 나왔다는 뜻임
            }
             
            System.out.println("#" + t + " " + min);
        }
    }
}
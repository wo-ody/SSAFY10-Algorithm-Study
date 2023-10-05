import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bof16173 {

    static int[][] arr;
    static int n;
    static boolean last = false;
    static int[] dx = {0, 1}; //오른쪽이나 아래로만 움직일 수 있음.
    static int[] dy = {1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0);

        if(last){
            System.out.println("HaruHaru");
        } else {
            System.out.println("Hing");
        }
    }

    public static void dfs(int x, int y){
        if(arr[x][y] == 0) {
            return;
        }
        if(arr[x][y] == -1){
            last = true;
            return;
        }

        for (int i=0; i<2; i++){
            int nx = x + (arr[x][y] * dx[i]);
            int ny = y + (arr[x][y] * dy[i]);
            if(nx >= 0 && ny >= 0 && nx<n && ny<n){
                dfs(nx, ny);
            }
        }
    }
}

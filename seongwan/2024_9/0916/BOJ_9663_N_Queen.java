import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, ans;
    static boolean[] chkCol;
    static boolean[] chkDia;
    static boolean[] chkRedia;


    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        chkCol = new boolean[N];
        chkDia = new boolean[2 * N - 1];
        chkRedia = new boolean[2 * N - 1];

        for (int i = 0; i < N; i++) {
            dfs(0, i, 1);
        }

        System.out.println(ans);
    }

    static void dfs(int r, int c, int count) {
        if (count == N) {
            ans += 1;
            return;
        }

        chkCol[c] = true;
        chkDia[r + c] = true;
        chkRedia[N - 1 - r + c] = true;
        for (int j = 0; j < N; j++) {
            if (!chkCol[j] && !chkDia[r + 1 + j] && !chkRedia[N - 1 - (r + 1) + j]) {
                dfs(r + 1, j, count + 1);
            }
        }

        chkCol[c] = false;
        chkDia[r + c] = false;
        chkRedia[N - 1 - r + c] = false;
    }
}
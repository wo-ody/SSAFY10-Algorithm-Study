import java.io.*;
import java.util.*;
 
public class Main {
 
    static int[] x = {1, -1, 0, 0}, y = {0, 0, 1, -1};
    static int[][] dp, arr;
    static int n, m;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
 
        arr = new int[n + 1][m + 1];
 
        dp = new int[n + 1][m + 1];
 
        for (int i = 1; i <= n; i++) {
            String[] s1 = br.readLine().split(" ");
            for (int j = 1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(s1[j - 1]);
                dp[i][j] = -1;
            }
        }
 
        System.out.println(solve(n, m));
    }
 
    public static int solve(int a, int b) {
        if (a == 1 && b == 1) {
            return 1;
        }
        if (dp[a][b] != -1) {
            return dp[a][b];
        } else {
            dp[a][b]=0;
            for (int i = 0; i < 4; i++) {
                int ny = a + y[i];
                int nx = b + x[i];
                if (ny > 0 && ny <= n && nx > 0 && nx <= m) {
                    if (arr[a][b] < arr[ny][nx]) {
                        dp[a][b] += solve(ny, nx);
                    }
                }
            }
        }
        return dp[a][b];
    }
}

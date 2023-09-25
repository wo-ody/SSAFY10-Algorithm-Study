import java.io.*;

public class Main {
    
    private static final int DIR = 3, MAX_SIZE = 6, EMPTY = 10000000;
    
    private static int n, m;
    
    private static int[] dx = {1, 1, 1};
    private static int[] dy = {0, 1, -1};
    private static int[][] space = new int[MAX_SIZE][MAX_SIZE];
    private static int[][][] dp = new int[DIR][MAX_SIZE][MAX_SIZE];
    
    public static void main(String args[]) throws IOException {
        initialize();
        simulate();
        System.out.println(getMinFuel());
    }
    
    private static int getMinFuel() {
        int result = EMPTY;
        for (int i = 0; i < DIR; i++) {
            for (int j = 0; j < m; j++) {
                result = Math.min(result, dp[i][n-1][j]);
            }
        }
        return result;
    }
    
    private static void simulate() {
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int d = 0; d < DIR; d++) {
                    int bx = i - dx[d];
                    int by = j - dy[d];
                    if (!inRange(bx, by)) continue;
                    
                    dp[d][i][j] = Math.min(dp[d][i][j], dp[(d + 1) % DIR][bx][by] + space[i][j]);
                    dp[d][i][j] = Math.min(dp[d][i][j], dp[(d + 2) % DIR][bx][by] + space[i][j]);
                }
                
            }
        }
    }

    
    private static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
    
    private static void initialize() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] tmp = br.readLine().split(" ");
        n = Integer.parseInt(tmp[0]);
        m = Integer.parseInt(tmp[1]);
        
        for (int i = 0; i < n; i++) {
            tmp = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                space[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        
        for (int d = 0; d < DIR; d++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (i == 0) {
                        dp[d][i][j] = space[i][j];
                        continue;
                    }
                    dp[d][i][j] = EMPTY;
                }
            }
        }
    }
}

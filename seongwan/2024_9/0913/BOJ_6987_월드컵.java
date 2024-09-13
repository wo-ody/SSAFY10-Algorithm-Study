import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static long[] num = {1_000_000_000_000_000L, 1_000_000_000_000L, 1_000_000_000L, 1_000_000L, 1_000L, 1L};
    static int[][] match = {{0, 1}, {0, 2}, {0, 3}, {0, 4}, {0, 5}, {1, 2}, {1, 3}, {1, 4}, {1, 5}, {2, 3}, {2, 4}, {2, 5}, {3, 4}, {3, 5}, {4, 5}};
    static long result;

    public static void main(String[] args) throws Exception {
        for (int t = 0; t < 4; t++) {
            result = Long.parseLong(br.readLine().replace(" ", ""));
            System.out.print(dfs(0, 0) ? 1 : 0);
            System.out.print(" ");
        }
    }

    static boolean dfs(int n, long state) {
        if (n == 15)
            return state == result;

        if (state > result)
            return false;

        int teamA = match[n][0];
        int teamB = match[n][1];

        long win = state + 100 * num[teamA] + num[teamB];
        long draw = state + 10 * num[teamA] + 10 * num[teamB];
        long lose = state + num[teamA] + 100 * num[teamB];

        return dfs(n + 1, win) || dfs(n + 1, draw) || dfs(n + 1, lose);
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] dp;
    static String s1, s2;
    static Deque<Character> stack = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        s1 = br.readLine();
        s2 = br.readLine();
        int size1 = s1.length();
        int size2 = s2.length();

        dp = new int[size1 + 1][size2 + 1];
        for (int i = 1; i <= size1; i++) {
            for (int j = 1; j <= size2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int r = size1;
        int c = size2;

        while (true) {
            if (dp[r][c] == 0)
                break;

            if (dp[r][c] == dp[r - 1][c]) {
                r -= 1;
                continue;
            }

            if (dp[r][c] == dp[r][c - 1]) {
                c -= 1;
                continue;
            }

            stack.push(s1.charAt(r - 1));
            r -= 1;
            c -= 1;
        }

        for (int i = 0; i < dp[size1][size2]; i++) {
            sb.append(stack.pop());
        }

        System.out.println(dp[size1][size2]);
        if (dp[size1][size2] != 0)
            System.out.println(sb);
    }
}
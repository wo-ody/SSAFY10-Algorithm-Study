public class Main {
    static int T, N;
    static StringBuilder sb = new StringBuilder();
    static int[][] dp;
    static int[] sum;

    public static void main(String[] args) throws Exception {
        Reader in = new Reader();

        T = in.nextInt();
        for (int t = 0; t < T; t++) {
            N = in.nextInt();

            dp = new int[N + 1][N + 1];
            sum = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                sum[i] = sum[i - 1] + in.nextInt();
            }

            for (int term = 1; term < N; term++) {
                for (int i = 1; i < N; i++) {
                    int end = i + term;
                    if (end > N)
                        break;

                    for (int j = i; j < end; j++) {
                        int value = dp[i][j] + dp[j + 1][end] + sum[end] - sum[i - 1];
                        dp[i][end] = dp[i][end] == 0 ? value : Math.min(dp[i][end], value);
                    }
                }
            }

            sb.append(dp[1][N]).append("\n");
        }
        System.out.println(sb);
    }

    static class Reader {
        final int SIZE = 1 << 13;
        byte[] buffer = new byte[SIZE];
        int index, size;

        int nextInt() throws Exception {
            int n = 0;
            byte c;
            boolean isMinus = false;
            while ((c = read()) <= 32) {
                if (size < 0) return -1;
            }
            if (c == 45) {
                c = read();
                isMinus = true;
            }
            do n = (n << 3) + (n << 1) + (c & 15);
            while (isNumber(c = read()));
            return isMinus ? ~n + 1 : n;
        }

        boolean isNumber(byte c) {
            return 47 < c && c < 58;
        }

        byte read() throws Exception {
            if (index == size) {
                size = System.in.read(buffer, index = 0, SIZE);
                if (size < 0) buffer[0] = -1;
            }
            return buffer[index++];
        }
    }
}
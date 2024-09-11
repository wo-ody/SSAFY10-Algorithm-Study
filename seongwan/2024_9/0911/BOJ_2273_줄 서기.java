public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[][] mat;
    static boolean chk;

    public static void main(String[] args) throws Exception {
        Reader in = new Reader();
        N = in.nextInt();
        M = in.nextInt();

        mat = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            int from = in.nextInt();
            int to = in.nextInt();
            mat[from][to] = 1;
        }

        floyd();
        check();
        System.out.println(chk ? -1 : sb);
    }

    static void check() {
        for (int i = 1; i <= N; i++) {
            int start = 1;
            int end = N;

            for (int j = 1; j <= N; j++) {
                //비교가 이상한 상황 -> 양 쪽 다 크다고 하는 경우
                if (mat[i][j] == 1 && mat[j][i] == 1) {
                    chk = true;
                    return;
                }

                if (mat[i][j] == 1)
                    end--;

                if (mat[j][i] == 1)
                    start++;
            }

            sb.append(start).append(" ").append(end).append("\n");
        }
    }

    static void floyd() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (mat[i][k] == 1 && mat[k][j] == 1)
                        mat[i][j] = 1;
                }
            }
        }
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
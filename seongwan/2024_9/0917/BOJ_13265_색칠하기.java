import java.util.ArrayList;
import java.util.List;

public class Main {
    static int T, n, m;
    static StringBuilder sb = new StringBuilder();
    static List<Integer>[] adlist;
    static int[] chk;//0-미방문 1-A색 2-B색
    static boolean possible;

    public static void main(String[] args) throws Exception {
        Reader in = new Reader();
        T = in.nextInt();
        for (int t = 0; t < T; t++) {
            possible = true;

            n = in.nextInt();
            m = in.nextInt();

            adlist = new List[n + 1];
            chk = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                adlist[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                int from = in.nextInt();
                int to = in.nextInt();

                adlist[from].add(to);
                adlist[to].add(from);
            }

            for (int i = 1; i <= n; i++) {
                if (chk[i] == 0) {
                    chk[i] = 1;
                    dfs(i);

                    if (!possible)
                        break;
                }
            }
            sb.append(possible ? "possible" : "impossible").append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int node) {
        if (!possible)
            return;

        for (Integer next : adlist[node]) {
            if (chk[next] == 0) {
                chk[next] = chk[node] == 1 ? 2 : 1;
                dfs(next);
            } else {
                if (chk[node] == chk[next])
                    possible = false;
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
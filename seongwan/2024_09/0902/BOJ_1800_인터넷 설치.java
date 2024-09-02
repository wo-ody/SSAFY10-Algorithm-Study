import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<int[]>[] adlist;
    static int N, P, K;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        adlist = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            adlist[i] = new ArrayList<>();
        }

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adlist[from].add(new int[]{to, w});
            adlist[to].add(new int[]{from, w});
        }

        System.out.println(dijk());
    }

    static int dijk() {
        //node,w,count
        PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1]);
        int ans = 0;
        boolean[][] visit = new boolean[N + 1][K + 1];
        pq.add(new int[]{1, 0, K});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int w = cur[1];
            int count = cur[2];

            if (visit[node][count])
                continue;

            if (node == N)
                return w;

            visit[node][count] = true;
            for (int[] next : adlist[node]) {
                int nextNode = next[0];

                if (!visit[nextNode][count]) {
                    pq.add(new int[]{nextNode, Math.max(w, next[1]), count});
                }

                if (count > 0 && !visit[nextNode][count - 1]) {
                    pq.add(new int[]{nextNode, w, count - 1});
                }
            }
        }
        return -1;
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static List<int[]>[] adlist;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adlist = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            adlist[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adlist[from].add(new int[]{to, w});
            adlist[to].add(new int[]{from, w});
        }

        sb.append(N - 1).append("\n");
        dijk();
        System.out.println(sb);
    }

    static void dijk() {
        //node, preNode, w
        PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[2] - e2[2]);
        boolean[] visit = new boolean[N + 1];
        int count = 0;

        pq.add(new int[]{1, 0, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int pre = cur[1];
            int w = cur[2];

            if (visit[node])
                continue;

            visit[node] = true;
            count++;

            if (pre != 0)
                sb.append(pre).append(" ").append(node).append("\n");

            if (count == N)
                return;

            for (int[] next : adlist[node]) {
                int nextNode = next[0];
                if (visit[nextNode])
                    continue;
                pq.add(new int[]{nextNode, node, w + next[1]});
            }
        }
    }
}

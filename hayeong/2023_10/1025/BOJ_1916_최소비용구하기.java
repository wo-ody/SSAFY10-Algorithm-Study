import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1916_최소비용구하기 {
    static final int INF = Integer.MAX_VALUE;
    static int N, M;
    static List<List<Edge>> adjList = new ArrayList<>();
    static int start, dest;
    static int[] cost;
    static boolean[] visit;

    static class Edge {
        int v, c;

        Edge(int v, int c) {
            this.v = v;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        cost = new int[N + 1];
        visit = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
            cost[i] = INF;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adjList.get(from).add(new Edge(to, cost));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        dest = Integer.parseInt(st.nextToken());

        dijkstra();

        System.out.println(cost[dest]);
    }

    static void dijkstra() {
        cost[start] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.c - e2.c);
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (visit[cur.v]) continue;

            visit[cur.v] = true;
            for (Edge ne : adjList.get(cur.v)) {
                if (cost[cur.v] + ne.c < cost[ne.v]) {
                    cost[ne.v] = cost[cur.v] + ne.c;
                    ne.c = cost[ne.v];
                    pq.add(ne);

                }
            }
        }
    }


}

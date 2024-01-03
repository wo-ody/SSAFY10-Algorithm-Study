import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_9370_미확인도착지 {
    public static final int INF = Integer.MAX_VALUE;
    public static int T, n, m, t, s, g, h;

    public static ArrayList<ArrayList<Edge>> graph;

    public static int[] costList;

    static class Edge implements Comparable<Edge> {
        int v, c;

        Edge(int v, int c) {
            this.v = v;
            this.c = c;
        }

        @Override
        public int compareTo(Edge o) {
            return this.c - o.c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int j = 0; j < T; j++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();

            // 그래프 초기화
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            // 그래프 생성
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                graph.get(start).add(new Edge(end, cost));
                graph.get(end).add(new Edge(start, cost));
            }


            int[] dests = new int[t];
            for (int i = 0; i < t; i++) {
                dests[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(dests);

            StringBuilder sb= new StringBuilder();
            for (int d : dests) {
                long res1 = dijkstra(s, g) + dijkstra(g, h) + dijkstra(h, d);
                long res2 = dijkstra(s, h) + dijkstra(h, g) + dijkstra(g, d);
                long res3 = dijkstra(s, d);

                if (Math.min(res1, res2) == res3) {
                    sb.append(d+" ");
                }
            }


            System.out.println(sb.toString());
        }
    }

    static int dijkstra(int start, int end) {
        costList = new int[n + 1];
        Arrays.fill(costList, INF);
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        pq.add(new Edge(start, 0));
        costList[start] = 0;

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int now = edge.v;
            int dist = edge.c;

            if (costList[now] < dist) continue;


            for (Edge ne : graph.get(now)) {
                int cost = costList[now] + ne.c;

                if (cost < costList[ne.v]) {
                    costList[ne.v] = cost;
                    pq.offer(new Edge(ne.v, cost));
                }
            }
        }
        return costList[end];
    }
}

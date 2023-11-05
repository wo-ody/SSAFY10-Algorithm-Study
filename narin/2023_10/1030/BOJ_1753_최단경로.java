import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node {
        int vertex, weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    private static int V, E, K; // V 정점의 개수, E 간선의 개수, K 시작 정점의 번호
    private static List<Node>[] list;
    private static boolean[] isVisited;
    private static int[] dist;
    private static int INF = 100_000_000;

    private static void dijkstra(int start) {
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2)->o1.weight-o2.weight);
        q.add(new Node(start, 0));
        dist[start] = 0;

        while(!q.isEmpty()){
            Node now = q.poll();

            if(!isVisited[now.vertex]){
                isVisited[now.vertex] = true;
            }

            for(Node next : list[now.vertex]){
                if(!isVisited[next.vertex] && dist[next.vertex]>now.weight+next.weight){
                    dist[next.vertex] = now.weight+next.weight;
                    q.add(new Node(next.vertex, dist[next.vertex]));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        list = new ArrayList[V + 1];
        dist = new int[V + 1];
        isVisited = new boolean[V+1];

        Arrays.fill(dist, INF);

        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[u].add(new Node(v, w));
        }

        dijkstra(K);

        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF)
                sb.append("INF").append("\n");
            else
                sb.append(dist[i]).append("\n");
        }

        System.out.println(sb);
    }
}

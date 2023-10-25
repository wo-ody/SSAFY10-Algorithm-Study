import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class BOJ_1753 {
    // 다익스트라

    static final int INF = Integer.MAX_VALUE;
    static int V, E, K;
    static int[] dist;
    static boolean[] visited;
    static List<List<Node>> adjList = new ArrayList<>();

    static class Node{
        int v, c;
        Node(int v, int c){
            this.v = v;
            this.c = c;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        dist = new int[V+1];
        visited =new boolean[V+1];

        for(int i = 0; i<=V; i++){
            adjList.add(new ArrayList<Node>());
            dist[i] = INF;
        }
        for(int i = 0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adjList.get(from).add(new Node(to, cost));
        }

        dijkstra();

        for(int i = 1; i<=V; i++){
            if(dist[i] == INF) System.out.println("INF");
            else System.out.println(dist[i]);
        }
    }

    static void dijkstra(){
        dist[K] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2)->n1.c-n2.c);
        pq.add(new Node(K, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(visited[cur.v]) continue;

            visited[cur.v] = true;
            for(Node ne : adjList.get(cur.v)){
                if(dist[cur.v] + ne.c < dist[ne.v] ){
                    dist[ne.v] = dist[cur.v] + ne.c;
                    ne.c = dist[ne.v];
                    pq.add(ne);
                }
            }
        }
    }

}

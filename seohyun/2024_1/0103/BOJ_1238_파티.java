import java.io.*;
import java.util.*;

public class Main {
    static int N,M,X;
    static ArrayList<Node>[] adj;

    static int[] dist;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adj[a].add(new Node(b,cost));
        }

        dist = new int[N+1];
        Arrays.fill(dist,0);


        for (int i = 1; i <= N ; i++) {
            int[] dis = dijkstra(i);

            if(i == X){ // 복귀
                for (int j = 1; j <= N ; j++) {
                    dist[j] += dis[j];
                }
            }
            else{
                if(dis[X] == 60000000) continue;
                dist[i] += dis[X];
            }
        }

        // X -> X 는 0으로 만들기
        dist[X] = 0;
        Arrays.sort(dist);

        System.out.println(dist[N]);

    }

    static int[] dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->o1.cost - o2.cost);
        boolean[] visited = new boolean[N+1];
        int[] dist = new int[N+1];
        Arrays.fill(dist,60000000);

        pq.add(new Node(start,0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(!visited[cur.v]) visited[cur.v] = true;

            for(Node nxt : adj[cur.v]){
                if(!visited[nxt.v] && dist[nxt.v] > cur.cost + nxt.cost){
                    dist[nxt.v] = cur.cost + nxt.cost;
                    pq.add(new Node(nxt.v, dist[nxt.v]));
                }
            }

        }

        return dist;

    }

    static class Node{
        int v,cost;
        Node(int v,int cost){
            this.v = v;
            this.cost = cost;
        }
    }
}

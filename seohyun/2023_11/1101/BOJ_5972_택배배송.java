import java.io.*;
import java.util.*;
public class Main {
    static int N,M;
    static ArrayList<Node>[] graph;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b,c));
            graph[b].add(new Node(a,c));
        }

        System.out.println(dijkstra());

    }
    static int simulation(){
        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> o1.cost - o2.cost));
        boolean[] visited = new boolean[N+1];

        int cnt = 0;

        pq.add(new Node(1,0));
        visited[1] = true;

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(!visited[cur.v]) cnt += cur.cost;


            for(Node nxt : graph[cur.v]){
                if(visited[nxt.v]) continue;

                pq.add(nxt);
                visited[nxt.v] = true;
            }

        }

        return cnt;

    }

    static int dijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> o1.cost - o2.cost));
        boolean[] visited = new boolean[N+1];
        int[] dist = new int[N+1];
        Arrays.fill(dist, 987654321);

        pq.add(new Node(1,0));
        dist[1] = 0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(!visited[cur.v]) visited[cur.v] = true;

            for(Node nxt : graph[cur.v]){
                if(!visited[nxt.v] && dist[nxt.v] > dist[cur.v] + nxt.cost ){
                    pq.add(new Node(nxt.v , cur.cost + nxt.cost));
                    dist[nxt.v] = cur.cost + nxt.cost;
                }
            }
        }

        return dist[N];
    }

    static class Node{
        int v,cost;
        Node(int v, int cost){
            this.v = v;
            this.cost = cost;
        }
    }
}

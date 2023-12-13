package boj;

import java.io.*;
import java.util.*;

public class boj_1753_최단경로 {
    static int V,E,K;
    static ArrayList<Node>[] adj;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        adj = new ArrayList[V+1];
        for (int i = 0; i <= V; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adj[v].add(new Node(u, cost));
        }

        int[] dist = dijkstra();
        for (int i = 1; i <= V; i++) {
            if(dist[i] == 300000) sb.append("INF").append('\n');
            else sb.append(dist[i]).append('\n');
        }
        System.out.println(sb);
    }

    static int[] dijkstra(){
        int[] dist = new int[V+1];
        Arrays.fill(dist,300000);
        boolean[] visited = new boolean[V+1];
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> o1.cost - o2.cost);

        pq.add(new Node(K,0));
        dist[K] = 0;
        

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(!visited[cur.v]) visited[cur.v] = true;

            for(Node nxt : adj[cur.v]){
                if(visited[nxt.v]) continue;
                if(dist[nxt.v] > cur.cost + nxt.cost){
                    dist[nxt.v] = cur.cost + nxt.cost;
                    pq.add(new Node(nxt.v,dist[nxt.v]));
                    
                }
            }
        }
        return dist;
    }

    static class Node{
        int v, cost;
        Node(int v, int cost){
            this.v = v;
            this.cost = cost;
        }
    }
}

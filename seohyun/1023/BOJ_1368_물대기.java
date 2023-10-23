package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_1368_물대기 {
    static int N;
    static int[] self;
    static int[][] adj;

    static int result;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        self = new int[N];
        adj = new int[N][N];

        for (int i = 0; i < N; i++) {
            self[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                adj[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result = Integer.MAX_VALUE;
        simulation();

        System.out.println(result);

    }

    static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> o1.cost - o2.cost);
        boolean[] visited = new boolean[N];
        int[] distance = new int[N];
        Arrays.fill(distance, Integer.MAX_VALUE);

        pq.add(new Node(start, self[start]));
        distance[start] = self[start];

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(visited[cur.v]) continue;
            visited[cur.v] = true;

            for (int i = 0; i < N; i++) { // 입력값 보니 다 연결되있네 ..?
                if(i == cur.v || visited[i]) continue;
                int newd = Math.min(self[i], adj[cur.v][i]);
                if(distance[i] > newd){
                    distance[i] = newd;
                    pq.add(new Node(i,newd));
                }
            }
        }

        int sum = 0;
        for(int su : distance){
            if(su == Integer.MAX_VALUE) return;
            sum += su;
        }

        result = Math.min(result,sum);
        //System.out.println(result);
    }
    static void simulation(){

        for (int i = 0; i < N; i++) {
            dijkstra(i);
        }
    }

    static class Node{
        int v,cost;
        Node(int v, int cost){
            this.v = v;
            this.cost = cost;
        }
    }
}

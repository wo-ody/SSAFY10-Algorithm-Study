import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,Q;
    static ArrayList<Node>[] graph;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to,weight));
            graph[to].add(new Node(from,weight));
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            //BFS
            sb.append(BFS(k,v)).append("\n");
        }

        System.out.println(sb);
    }

    static int BFS(int k, int v){
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N+1];
        int result = 0;

        q.add(v);
        visited[v] = true;

        while(!q.isEmpty()){
            int cur = q.poll();

            for (Node nxt : graph[cur]){
                if(visited[nxt.end]) continue;
                if(nxt.weight >= k){
                    result++;
                    q.add(nxt.end);
                    visited[nxt.end] = true;
                }
            }
        }

        return result;
    }

    static class Node{
        int end, weight;
        Node(int end, int weight){
            this.end = end;
            this.weight = weight;
        }
    }
}

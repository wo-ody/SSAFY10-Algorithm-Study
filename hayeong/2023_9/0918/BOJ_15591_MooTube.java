import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_15591_MooTube {
    static int N, Q;
    static List<ArrayList<Node>> graph = new ArrayList<>();
    static class Node {
        int v;
        int c;
        Node(int v, int c){
            this.v = v;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        for(int i = 0; i<=N; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            int cost =Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, cost));
            graph.get(b).add(new Node(a, cost));
        }

        for(int i = 0; i<Q; i++){
            st= new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int result = bfs(k, v);
            System.out.println(result);
        }

    }

    static int bfs(int k, int v){
        boolean[] visited = new boolean[N+1];
        Queue<Integer> q = new ArrayDeque<>();
        visited[v] = true;
        q.add(v);
        int tmp = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(Node n : graph.get(cur)){
                if(visited[n.v]) continue;
                if(n.c >= k){
                    tmp++;
                    q.add(n.v);
                    visited[n.v] = true;
                }
            }
        }
        return tmp;
    }
}

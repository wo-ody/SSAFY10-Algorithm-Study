import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1260_DFS와BFS {

    static int N, M, V;
    static boolean[] visit;
    static List<List<Integer>> graph = new ArrayList<>();

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        visit = new boolean[N+1];
        for(int i = 0; i<= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        for(int i = 0; i<=N; i++){
            Collections.sort(graph.get(i));
        }

        DFS(V);

        sb.append("\n");
        visit = new boolean[N+1];

        BFS(V);

        System.out.println(sb.toString());
    }

    static void DFS(int num){
        if(!visit[num]){
            visit[num] = true;
            sb.append(num +" ");
            for(int i : graph.get(num)){
                DFS(i);
            }
        }
    }

    static void BFS(int idx){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(idx);
        visit[idx] = true;
        sb.append(idx+" ");

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i : graph.get(cur)){
                if(!visit[i]){
                    visit[i] = true;
                    sb.append(i+" ");
                    q.add(i);
                }
            }
        }
    }
}

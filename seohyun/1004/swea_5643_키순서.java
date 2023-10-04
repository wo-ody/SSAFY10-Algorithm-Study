import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
    static int T,N,M;
    static ArrayList<Integer>[] adj;
    
    static Set<Integer>[] stuset;
    static StringBuilder sb  = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            
            adj = new ArrayList[N+1];
            stuset = new HashSet[N+1];
            for (int i = 0; i <= N; i++) adj[i] = new ArrayList<>();
            for (int i = 0; i <= N; i++) stuset[i] = new HashSet<>();
            
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                adj[a].add(b);
            }
            
            
            //
            sb.append("#").append(tc).append(" ").append(simulation()).append("\n");
        }
        System.out.println(sb);

    }
    
    static void BFS(int num) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N+1];
        
        q.add(num);
        visited[num] = true;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            stuset[cur].add(num); // 여기 위치까지 해야 자기 자신도 들어감
            stuset[num].add(cur);
            for(int nxt : adj[cur]) {
                if(visited[nxt]) continue;
                q.add(nxt);
                visited[nxt] = true;
            }
        }
    }
    
    static int simulation() {
        
        for (int i = 1; i <= N; i++) {
             BFS(i);
        }
        
        //Set 검사해서 답 리턴
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if(stuset[i].size() == N) cnt++;
        }
        
        return cnt;
    }

}

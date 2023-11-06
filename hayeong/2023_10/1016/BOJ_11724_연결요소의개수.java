import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11724_연결요소의개수 {
    static int N, M, ans;
    static boolean[] visit;

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visit = new boolean[N+1];
        for(int i = 0; i<=N; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            graph.get(to).add(from);
            graph.get(from).add(to);
        }

        for(int i= 1; i<=N; i++){
            if(!visit[i]){
                dfs(i);
                ans++;
            }
        }
        System.out.println(ans);
    }

    static void dfs(int idx){
        if(!visit[idx]){
            visit[idx] = true;
            for(int i : graph.get(idx)){
                if(!visit[i])
                    dfs(i);
            }
        }
    }
}

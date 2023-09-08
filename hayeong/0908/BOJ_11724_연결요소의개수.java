import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11724_연결요소의개수 {
    static int N, M;
    static boolean[] visited;
    static int cnt = 0;
    static List<List<Integer>> graph =new ArrayList<>();
    public static void main(String[] args) throws IOException {
        // 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        // 그래프 생성
        for(int i = 0; i<=N; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        for(int i = 1; i<=N; i++){
            if(visited[i]) continue;
            dfs(i);
            cnt++;
        }

        System.out.println(cnt);
    }

    static void dfs(int num){
        if(visited[num]){
            return;
        }

        visited[num] = true;
        List<Integer> adjList = graph.get(num);
        for(int i : adjList){
            dfs(i);
        }
    }
}

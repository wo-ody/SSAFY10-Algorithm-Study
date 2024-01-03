
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_13023_ABCDE {
    static int N, M, ans;
    static boolean[] visited;
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        for(int i = 0; i<N; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i<M; i++){
            st= new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        for(int i = 0; i<N; i++){
            visited = new boolean[N];
            visited[i] = true;
            dfs(i, 1);
            if(ans == 1){
                System.out.println(1);
                return;
            }
        }
        System.out.println(ans);
    }

    static void dfs(int num, int depth){
        if(depth == 5){
            ans =1;
            return;
        }
        visited[num] = true;
        List<Integer> adjList = graph.get(num);
        for(Integer i : adjList){
            if(!visited[i]){
                visited[i] = true;
                dfs(i, depth+1);
                visited[i] = false;
            }
        }
    }
}

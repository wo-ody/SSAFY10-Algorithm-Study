import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_13023_ABCDE {
    static int N, M;
    static boolean arrive;
    static boolean[] visit;
    static List<List<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i<N; i++){
            graph.add(new ArrayList<>());
        }

        visit = new boolean[N];

        for(int i= 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        for(int i = 0; i<N; i++){
            DFS(i, 1);
            if(arrive) break;
        }

        if(arrive) System.out.println(1);
        else System.out.println(0);
    }

    static void DFS(int idx, int depth){
        if(depth == 5 || arrive) {
            arrive = true;
            return;
        }
        visit[idx] = true;
        for(int i : graph.get(idx)){
            if(visit[i]) continue;
            DFS(i, depth+1);
        }
        visit[idx] = false;
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 결혼식_5567 {
    static int n, m; // 총 사람수, 관계 수
    static boolean[] visited; // 방문체크
    static int cnt = 0; // 초대할 사람 수
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // 인접리스트로 그래프 생성

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 초기화 및 입력
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        // 그래프 생성(인접리스트)
        int a = 0;
        int b = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // 상근이는 1번이므로 방문체크해주고
        visited[1] = true;
        dfs(1, 0);// 상근이부터 dfs

        // 방문체크 true인 수가 상근이의 친구 + 친구의 친구 수
        for (int i = 2; i <= n; i++) {
            if (visited[i]) cnt++;
        }
        System.out.println(cnt);

    }


    // depth == 0 상근이의 친구 체크
    // depth == 1 상근이친구의 친구 체크
    static void dfs(int idx, int depth) {
        if (depth == 2) {
            return;
        }
        ArrayList<Integer> adjList = graph.get(idx);
        for (int i = 0; i < adjList.size(); i++) {
            visited[adjList.get(i)] = true;
            dfs(adjList.get(i), depth + 1);
        }

    }
}

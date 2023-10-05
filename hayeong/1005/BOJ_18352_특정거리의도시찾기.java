import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_18352_특정거리의도시찾기 {

    static int N, M, K, X;
    static List<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        // 그래프 생성
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        // visited 배열 초기화
        visited = new int[N + 1];
        Arrays.fill(visited, -1);

        // 그래프 생성
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
        }

        bfs();
        for (int i = 1; i <= N; i++) {
            if (visited[i] == K) {
                sb.append(i + "\n");
            }
        }
        if (sb.length() == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }
    }

    public static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        visited[X] = 0;
        q.add(X);
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int adj : graph.get(cur)) {
                if (visited[adj] != -1) continue;
                visited[adj] = visited[cur] + 1;
                q.add(adj);
            }
        }
    }
}

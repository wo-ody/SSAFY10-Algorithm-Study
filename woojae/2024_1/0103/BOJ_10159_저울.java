import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int[][] forwardGraph;
    static int[][] backGraph;
    static int[][] visited;

    public static void main(String[] args) throws IOException {  // swea 키 순서랑 동일한 문제
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        forwardGraph = new int[n + 1][n + 1];  // 인접 리스트로 표현하면 메모리 터짐
        backGraph = new int[n + 1][n + 1];
        visited = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            forwardGraph[from][to] = 1;
            backGraph[to][from] = 1;
        }

        for (int i = 1; i <= n; i++) {
            bfs(forwardGraph, i);
            bfs(backGraph, i);
        }

        for (int i = 1; i <= n; i++)
            sb.append(n - Arrays.stream(visited[i]).sum()).append("\n");

        System.out.println(sb);
    }

    static void bfs(int[][] graph, int i) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(i);
        visited[i][i] = 1;

        while (!q.isEmpty()) {
            int start = q.poll();

            for (int next = 1; next <= n; next++)
                if (graph[start][next] == 1 && visited[i][next] == 0) {  // 연결되어있으면서 아직 방문하지 않았다면
                    visited[i][next] = 1;
                    q.add(next);
                }
        }
    }
}

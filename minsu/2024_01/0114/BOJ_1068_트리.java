import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean visited[];
    static int delete;
    static int parent[];
    static int ans;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int n = Integer.parseInt(br.readLine()); // 노드의 개수
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        parent = new int[n + 1];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();
        int root = -1;
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int p = Integer.parseInt(stk.nextToken());
            if (p == -1) {
                // i 노드가 바로 루트 노드
                root = i; // 루트 노드 정보를 저장함
            } else {
                // p 가 i 노드의 부모 노드임
                graph[i].add(p);
                graph[p].add(i); // 서로 연결
            }
        }
        delete = Integer.parseInt(br.readLine());
        if (delete == root) {
            System.out.println(0);
            return;
        } else dfs(root);
        System.out.println(ans);
    }

    static void dfs(int v) {
        visited[v] = true;
        int nodes = 0;
        for (int cur : graph[v]) {
            // 연결 노드 탐색
            if (cur != delete && !visited[cur]) {
                nodes++;
                dfs(cur);
            }
        }
        if (nodes == 0) {
            ans++; // 자식 노드가 하나도 없으면 리프 노드임
        }
    }
}

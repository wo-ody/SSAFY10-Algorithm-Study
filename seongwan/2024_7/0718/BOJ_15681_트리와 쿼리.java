import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, R, Q;
    static List<Integer>[] tree;
    static int[] count;
    static boolean[] check;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        tree = new List[N + 1];
        count = new int[N + 1];
        check = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        //간선 정보 입력
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            tree[from].add(to);
            tree[to].add(from);
        }

        dfs(R);

        for (int i = 0; i < Q; i++) {
            sb.append(count[Integer.parseInt(br.readLine())]).append("\n");
        }

        System.out.println(sb);
    }

    static int dfs(int node) {
        check[node] = true;
        int temp = 1;
        for (Integer next : tree[node]) {
            if (!check[next])
                temp += dfs(next);
        }

        return count[node] = temp;
    }
}
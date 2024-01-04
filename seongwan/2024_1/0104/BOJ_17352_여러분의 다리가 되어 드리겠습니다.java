import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static StringTokenizer st;
    static boolean[] visit;

    static List<Integer>[] adlist;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        visit = new boolean[N + 1];
        adlist = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            adlist[i] = new ArrayList<>();

        }

        for (int i = 0; i < N - 2; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adlist[from].add(to);
            adlist[to].add(from);
        }


        dfs(1);

        for (int i = 2; i <= N; i++) {
            if (!visit[i]) {
                System.out.printf("%d %d", 1, i);
                break;
            }
        }
    }

    static void dfs(int from) {
        visit[from] = true;
        for (int to : adlist[from]) {
            if (!visit[to])
                dfs(to);
        }
    }
}
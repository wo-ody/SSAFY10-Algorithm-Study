import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] need;
    static int[] ans;
    static StringBuilder sb = new StringBuilder();
    static Deque<Integer> queue = new ArrayDeque<Integer>();

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());

        need = new int[N];
        ans = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            need[i] = Integer.parseInt(st.nextToken());
            queue.add(i);
        }

        int time = 1;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            need[now]--;
            if (need[now] == 0) {
                ans[now] = time;
            } else {
                queue.add(now);
            }

            time++;
        }

        for (int i = 0; i < N; i++) {
            sb.append(ans[i]).append(" ");
        }

        System.out.println(sb);
    }
}

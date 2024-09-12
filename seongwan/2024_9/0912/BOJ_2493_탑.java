import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] input;
    static int[] ans;
    //[0]=값 [1]=위치
    static Deque<int[]> stack = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());

        input = new int[N + 1];
        ans = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        stack.push(new int[]{input[N], N});
        for (int i = N - 1; i >= 1; i--) {
            while (!stack.isEmpty() && stack.peek()[0] < input[i]) {
                int[] cur = stack.pop();
                ans[cur[1]] = i;
            }
            stack.push(new int[]{input[i], i});
        }

        for (int i = 1; i <= N; i++) {
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);
    }
}
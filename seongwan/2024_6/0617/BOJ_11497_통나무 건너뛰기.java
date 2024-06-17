import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T, N;
    static int[] input;
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            input = new int[N];

            int ans = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                input[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(input);

            int mid = input[N - 1];
            int left = input[(N / 2 - 1) * 2];
            int right = input[(N / 2 - 1) * 2 + 1];

            ans = Math.max(ans, mid - right);
            ans = Math.max(ans, mid - left);

            for (int i = N / 2 - 2; i >= 0; i--) {
                int nextRight = input[2 * i + 1];
                int nextLeft = input[2 * i];

                ans = Math.max(ans, right - nextRight);
                ans = Math.max(ans, left - nextLeft);

                right = nextRight;
                left = nextLeft;
            }

            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }
}

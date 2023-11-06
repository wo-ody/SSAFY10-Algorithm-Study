import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_10986_나머지합 {
    static int N, M;
    static long[] sum;
    static long ans;
    static long[] remain;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        remain = new long[M];
        sum = new long[N];
        st = new StringTokenizer(br.readLine());
        sum[0] = Integer.parseInt(st.nextToken());

        for (int i = 1; i < N; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int remainder = (int) (sum[i] % M);
            if (remainder == 0) ans++;
            remain[remainder]++;
        }

        for (int i = 0; i < M; i++) {
            if (remain[i] > 1)
                ans += (remain[i] * (remain[i] - 1) / 2);
        }


        System.out.println(ans);
    }
}

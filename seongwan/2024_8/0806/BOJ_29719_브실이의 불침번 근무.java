import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static final int C = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int ans = pow(M, N) - pow(M - 1, N);
        System.out.println(ans < 0 ? ans + C : ans);
    }

    static int pow(long num, int p) {
        long result = 1;

        while (p > 0) {
            if ((p & 1) == 1)
                result = result * num % C;
            p >>= 1;
            num = num * num % C;
        }
        return (int) result;
    }
}
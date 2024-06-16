import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] tip;
    static long ans;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());

        tip = new int[N];
        for (int i = 0; i < N; i++) {
            tip[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(tip);

        for (int i = 1; i <= N; i++) {
            int temp = tip[N - i] - (i - 1);

            ans += Math.max(temp, 0);
        }

        System.out.println(ans);
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] input = new int[n];

        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }

        long ans = 0;
        for (int i = 0; i < k; i++) {
            ans += input[i];
        }

        long temp = ans;
        for (int i = k; i < n; i++) {
            temp = temp - input[i - k] + input[i];
            ans = Math.max(ans, temp);
        }

        System.out.println(ans);
    }
}
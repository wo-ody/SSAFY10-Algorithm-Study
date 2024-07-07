import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] team = new long[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            long time = 0;
            for (int j = 0; j < count; j++) {
                time += Integer.parseInt(st.nextToken());
            }

            team[i] = time;
        }

        Arrays.sort(team);

        long[] sum = new long[N];
        sum[0] = team[0];
        for (int i = 1; i < N; i++) {
            sum[i] = sum[i - 1] + team[i];
        }

        long ans = 0;
        for (int i = 0; i < N; i++) {
            ans += sum[i];
        }

        System.out.println(ans);
    }
}

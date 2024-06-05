import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] dis;
    static int[] gasStation;
    static int[] check;
    static long ans;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        dis = new int[N];
        gasStation = new int[N];
        check = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i < N; i++) {
            dis[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        check[0] = N - 1;
        gasStation[0] = Integer.parseInt(st.nextToken());
        int temp = gasStation[0];
        int tempIdx = 0;

        for (int i = 1; i < N; i++) {
            gasStation[i] = Integer.parseInt(st.nextToken());

            if (temp > gasStation[i]) {
                check[tempIdx] = i;
                tempIdx = i;
                temp = gasStation[i];
            }
        }
        check[tempIdx] = N - 1;

        int before = 0;
        int after = check[0];

        while (true) {
            for (int i = before + 1; i <= after; i++) {
                ans += (long) dis[i] * gasStation[before];
            }
            before = after;
            after = check[before];

            if (before == N - 1)
                break;
        }

        System.out.println(ans);
    }
}
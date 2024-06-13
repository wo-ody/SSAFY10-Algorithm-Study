import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 0;
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int J = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int ans = 0;

            int[] boxes = new int[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                boxes[i] = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
            }

            Arrays.sort(boxes);

            for (int i = N - 1; i >= 0; i--) {
                if (J <= 0)
                    break;

                ans++;
                J -= boxes[i];
            }

            sb.append(ans).append("\n");
        }
        
        System.out.println(sb);
    }
}
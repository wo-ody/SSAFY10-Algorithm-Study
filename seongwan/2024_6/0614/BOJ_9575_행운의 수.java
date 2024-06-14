import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            Set<Integer> set = new HashSet<>();
            int ans = 0;

            int N = Integer.parseInt(br.readLine());
            int[] A = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine());
            int[] B = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            int K = Integer.parseInt(br.readLine());
            int[] C = new int[K];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                C[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    for (int k = 0; k < K; k++) {
                        set.add(A[i] + B[j] + C[k]);
                    }
                }
            }

            for (Integer num : set) {
                boolean check = false;
                while (num > 0) {
                    int temp = num % 10;
                    if (temp != 5 && temp != 8) {
                        check = true;
                        break;
                    }

                    num /= 10;
                }

                if (!check)
                    ans++;
            }

            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }
}
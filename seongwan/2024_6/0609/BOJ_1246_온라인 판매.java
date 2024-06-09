import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, ans, price;
    static StringTokenizer st;
    static int[] input;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        input = new int[M];
        for (int i = 0; i < M; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(input);

        int dis = M - N;

        for (int i = Math.max(0, dis); i < M; i++) {

            if (input[i] * (M - i) > price) {
                ans = input[i];
                price = input[i] * (M - i);
            }
        }

        System.out.println(ans + " " + price);
    }
}
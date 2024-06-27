import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static double[] input;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        input = new double[N];

        for (int i = 0; i < N; i++) {
            input[i] = Double.parseDouble(br.readLine());
        }

        Arrays.sort(input);

        System.out.printf("%.2f\n", cut());
        System.out.printf("%.2f", adjust());
    }

    static double cut() {
        double sum = 0;
        for (int i = K; i < N - K; i++) {
            sum += input[i];
        }

        return sum / (N - 2 * K);
    }

    static double adjust() {
        double sum = 0;
        for (int i = K; i < N - K; i++) {
            sum += input[i];
        }

        sum += input[K] * K;
        sum += input[N - 1 - K] * K;

        return sum / N;
    }
}
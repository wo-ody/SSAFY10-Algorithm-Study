import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[][] input;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        input = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
        }

        double front = 0;
        for (int i = 0; i < N - 1; i++) {
            front += (double) input[i][0] * input[i + 1][1];
        }
        front += (double) input[N - 1][0] * input[0][1];

        double back = 0;
        for (int i = 0; i < N - 1; i++) {
            back += (double) input[i][1] * input[i + 1][0];
        }
        back += (double) input[N - 1][1] * input[0][0];

        System.out.printf("%.1f", Math.abs(front - back) / 2);
    }
}
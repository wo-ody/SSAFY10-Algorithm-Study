import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1654_랜선자르기 {
    static int K, N;
    static int[] line;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        line = new int[K];
        long max= 0;
        for (int i = 0; i < K; i++) {
            line[i] = Integer.parseInt(br.readLine());
            if(max < line[i]){
                max = line[i];
            }
        }

        long start = 0;
        long end = max+1;
        long mid = 0;
        while (start < end) {
            mid = (start + end) / 2;

            long cnt = 0;
            for (int i = 0; i < K; i++) {
                cnt += line[i] / mid;
            }
            if (cnt < N) {
                end = mid;

            } else {
                start = mid + 1;
            }

        }
        System.out.println(start-1);
    }
}

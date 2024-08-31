import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, K, D;
    static StringTokenizer st;
    static int[][] rule;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        rule = new int[K][3];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            rule[i][0] = Integer.parseInt(st.nextToken());
            rule[i][1] = Integer.parseInt(st.nextToken());
            rule[i][2] = Integer.parseInt(st.nextToken());
        }

        System.out.println(search());
    }

    static int search() {
        int left = 1;
        int right = N;
        while (left <= right) {
            int mid = (left + right) / 2;

            long cnt = 0;
            for (int i = 0; i < K; i++) {
                int start = rule[i][0];
                int end = rule[i][1];
                int term = rule[i][2];

                //mid번호의 상자에겐 의미가 없는 규칙
                if (start > mid)
                    continue;

                //다 채워야하는 규칙
                if (mid >= end) {
                    cnt += (end - start) / term + 1;
                } else {
                    cnt += (mid - start) / term + 1;
                }
            }

            if (cnt >= D) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

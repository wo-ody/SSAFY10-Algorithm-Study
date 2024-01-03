import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_8983_사냥꾼 {
    static int M, N, L, ans;
    static int[] shooter;

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        shooter = new int[M];
        for (int i = 0; i < M; i++) {
            shooter[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(shooter);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            search(a, b);
        }
        System.out.println(ans);

    }

    static void search(int a, int b) {
        int start = 0, end = M, mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            if (mid >= M) return;

            int dist = Math.abs(shooter[mid] - a) + b;
            if (L < dist && a < shooter[mid]) {
                end = mid - 1;
            } else if (L < dist && a >= shooter[mid]) {
                start = mid + 1;
            } else if (L >= dist) {
                ans++;
                return;
            }
        }
    }
}

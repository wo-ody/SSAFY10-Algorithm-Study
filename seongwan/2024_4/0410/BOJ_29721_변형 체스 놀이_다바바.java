import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int[] dy = {0, 0, -2, 2};
    static int[] dx = {2, -2, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        HashSet<Long> set = new HashSet<>();
        int[][] dabbaba = new int[K][2];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            dabbaba[i][0] = x;
            dabbaba[i][1] = y;
            set.add((x - 1) * (long) N + y);
        }

        for (int i = 0; i < K; i++) {
            for (int j = 0; j < 4; j++) {
                int nx = dabbaba[i][0] + dx[j];
                int ny = dabbaba[i][1] + dy[j];
                if (nx <= 0 || ny <= 0 || nx > N || ny > N) continue;
                set.add((nx - 1) * (long) N + ny);
            }
        }
        System.out.println(set.size() - K);
    }
}
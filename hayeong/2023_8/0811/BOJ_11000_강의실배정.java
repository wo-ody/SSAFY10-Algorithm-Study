import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 걍의실배정_11000 {
    static int N;
    static int[][] lesson;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        lesson = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            lesson[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }
        Arrays.sort(lesson, (l1, l2) -> l1[0] - l2[0]);
        int ans = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(lesson[0][1]);
        for (int i = 1; i < N; i++) {
            if (pq.peek() <= lesson[i][0]) {
                pq.poll();
            }

            pq.offer(lesson[i][1]);

        }
        System.out.println(pq.size());

    }
}

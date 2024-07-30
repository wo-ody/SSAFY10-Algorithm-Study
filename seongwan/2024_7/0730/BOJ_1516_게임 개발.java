import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] time;
    static int[] pre;
    static List<Integer>[] postList;
    static int[] ans;
    static PriorityQueue<Integer> pq = new PriorityQueue<>((e1, e2) -> time[e1] - time[e2]);

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        time = new int[N + 1];
        pre = new int[N + 1];
        postList = new List[N + 1];
        ans = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            postList[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());

            while (true) {
                int preNum = Integer.parseInt(st.nextToken());

                if (preNum == -1)
                    break;

                pre[i]++;
                postList[preNum].add(i);
            }
        }

        for (int i = 1; i <= N; i++) {
            if (pre[i] == 0)
                pq.add(i);
        }

        int sum = 0;
        while (!pq.isEmpty()) {
            int temp = pq.poll();

            sum += time[temp];
            ans[temp] = sum;

            for (Integer i : pq) {
                time[i] -= time[temp];
            }

            for (Integer i : postList[temp]) {
                pre[i]--;
                if (pre[i] == 0)
                    pq.add(i);
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(ans[i]).append("\n");
        }
        System.out.println(sb);
    }
}
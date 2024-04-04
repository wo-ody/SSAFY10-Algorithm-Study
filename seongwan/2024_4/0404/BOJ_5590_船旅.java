import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//다익스트라를 이용
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, k;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static List<int[]>[] adlist;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        adlist = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            adlist[i] = new ArrayList<>();
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());

            if (cmd == 1) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                adlist[from].add(new int[]{to, weight});
                adlist[to].add(new int[]{from, weight});
            }

            if (cmd == 0) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                sb.append(dijk(from, to)).append("\n");
            }
        }
        System.out.println(sb);
    }

    static int dijk(int from, int to) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1]);
        for (int[] next : adlist[from]) {
            pq.add(next);
        }
        boolean[] visit = new boolean[n + 1];

        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int cur = temp[0];

            if (visit[cur])
                continue;

            int weight = temp[1];

            if (cur == to)
                return weight;

            visit[cur] = true;

            for (int[] next : adlist[cur]) {
                int nn = next[0];
                if (visit[nn])
                    continue;
                pq.add(new int[]{nn, weight + next[1]});
            }
        }
        return -1;
    }
}
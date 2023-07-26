/**
 * 7.24 김창희
 * BOJ_1005_ACMCraft
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            st = new StringTokenizer(br.readLine());

            List<List<Integer>> graph = new ArrayList<>();
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] cost = new int[n + 1];
            int[] e = new int[n + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < n + 1; i++) cost[i] = Integer.parseInt(st.nextToken());
            for (int i = 0; i < n + 1; i++) graph.add(new ArrayList<>());

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph.get(x).add(y);
            }

            for (int i = 1; i < n + 1; i++) {
                for (int node : graph.get(i)) e[node]++;
            }

            Queue<Integer> q = new LinkedList<>();
            int[] result = new int[n + 1];
            int w = Integer.parseInt(br.readLine());
            for (int i = 1; i < n + 1; i++) {
                if (e[i] == 0) {
                    result[i] = cost[i];
                    q.offer(i);
                }
            }

            while (!q.isEmpty()) {
                int x = q.poll();
                for (int i : graph.get(x)) {
                    e[i]--;
                    if (e[i] == 0) q.offer(i);
                    result[i] = Math.max(result[i], result[x] + cost[i]);
                }
            }
            answer.append(result[w]).append("\n");
        }
        System.out.println(answer);
    }
}

/*
 *  08.11 김창희
 *  BOJ_2623_음악프로그램
 *
 *  [풀이]
 *  1. 사이클이 존재 할 수 있는 위상정렬 문제
 *  2. 우선순위로 출력되는 노드들을 따로 저장하여 사이클이 발생했는지 판단한다.
 *  3. 사이틀이 발생할 경우 정답이 될 수 없다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n + 1; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int prev = Integer.parseInt(st.nextToken());
            for (int j = 1; j < k; j++) {
                int next = Integer.parseInt(st.nextToken());
                graph.get(prev).add(next);
                prev = next;
            }
        }

        int[] e = new int[n + 1];
        for (List<Integer> list : graph) {
            for (int i = 0; i < list.size(); i++) {
                e[list.get(i)]++;
            }
        }

        String answer = topologicalSort(e, n);
        System.out.println(answer);

    }

    public static String topologicalSort(int[] e, int n) {
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i < n + 1; i++) {
            if (e[i] == 0) q.offer(i);
        }

        List<Integer> list = new ArrayList<>();
        while (!q.isEmpty()) {
            int x = q.poll();
            list.add(x);
            for (int nx : graph.get(x)) {
                if (--e[nx] == 0) q.offer(nx);
            }
        }

        if (list.size() < n) return "0";

        StringBuilder result = new StringBuilder();
        for (int x : list) result.append(x).append("\n");
        return result.toString();
    }
}

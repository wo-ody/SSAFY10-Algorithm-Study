import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static List<Integer>[] adlist;
    static int[] ans;
    static List<Integer> startList = new ArrayList<>();
    static List<Integer> endList = new ArrayList<>();
    static int[] ingree;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        adlist = new List[N + 1];
        ans = new int[N + 1];
        ingree = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            adlist[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adlist[from].add(to);
            adlist[to].add(from);
        }


        for (int i = 1; i <= N; i++) {
            ingree[i] = adlist[i].size();
            if (ingree[i] >= 3)
                startList.add(i);
            if (ingree[i] == 1)
                endList.add(i);
        }

        checkCycle();

        int size = startList.size();
        for (int i = size - 1; i >= 0; i--) {
            int now = startList.get(i);
            if (ingree[now] != 2)
                startList.remove(i);
        }
        
        for (Integer i : startList) {
            bfs(i);
        }

        for (int i = 1; i <= N; i++) {
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);
    }

    static void checkCycle() {
        Deque<Integer> queue = new ArrayDeque<>();
        boolean[] visit = new boolean[N + 1];
        for (Integer i : endList) {
            visit[i] = true;
            queue.add(i);
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (Integer i : adlist[now]) {
                if (!visit[i]) {
                    ingree[i]--;
                    if (ingree[i] == 1) {
                        visit[i] = true;
                        queue.add(i);
                    }
                }
            }
        }
    }

    static void bfs(int i) {
        Deque<Integer> queue = new ArrayDeque<>();
        boolean[] visit = new boolean[N + 1];
        queue.add(i);
        visit[i] = true;
        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int now = queue.poll();
                ans[now] = distance;

                for (Integer next : adlist[now]) {
                    if (ingree[next] != 2 && !visit[next]) {
                        visit[next] = true;
                        queue.add(next);
                    }
                }
            }
            distance++;
        }
    }
}

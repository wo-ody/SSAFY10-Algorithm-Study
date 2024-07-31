import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int T, K, M, P, ans;
    static Deque<Integer> queue = new ArrayDeque<>();
    static int[] strahler;
    static int[] pre;
    static List<Integer>[] postList;
    static int[] visit;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());

            ans = 1;
            strahler = new int[M + 1];
            pre = new int[M + 1];
            visit = new int[M + 1];
            postList = new List[M + 1];
            for (int i = 1; i <= M; i++) {
                postList[i] = new ArrayList<>();
            }

            for (int i = 0; i < P; i++) {
                st = new StringTokenizer(br.readLine());
                int preNum = Integer.parseInt(st.nextToken());
                int postNum = Integer.parseInt(st.nextToken());

                pre[postNum]++;
                postList[preNum].add(postNum);
            }

            for (int i = 1; i <= M; i++) {
                if (pre[i] == 0) {
                    queue.add(i);
                    strahler[i] = 1;
                }
            }

            while (!queue.isEmpty()) {
                int temp = queue.poll();

                for (Integer i : postList[temp]) {
                    pre[i]--;

                    if (strahler[i] < strahler[temp]) {
                        strahler[i] = strahler[temp];
                        visit[i]++;
                    } else if (strahler[i] == strahler[temp]) {
                        if (visit[i] == 0) {
                            visit[i]++;
                        } else {
                            strahler[i]++;
                            ans = strahler[i];
                            visit[i] = 0;
                        }
                    }

                    if (pre[i] == 0) {
                        queue.add(i);
                    }
                }
            }

            sb.append(K).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
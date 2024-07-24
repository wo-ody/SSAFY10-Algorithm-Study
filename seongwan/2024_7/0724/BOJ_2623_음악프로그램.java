import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, count;
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] preCount;
    static List<Integer>[] postList;
    static Deque<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        preCount = new int[N + 1];
        postList = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            postList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int pre = Integer.parseInt(st.nextToken());

            for (int j = 0; j < num - 1; j++) {
                int post = Integer.parseInt(st.nextToken());

                preCount[post]++;
                postList[pre].add(post);
                pre = post;
            }
        }

        for (int i = 1; i <= N; i++) {
            if (preCount[i] == 0)
                queue.add(i);
        }

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            count++;

            sb.append(temp).append("\n");

            for (Integer i : postList[temp]) {
                preCount[i]--;

                if (preCount[i] == 0) {
                    queue.add(i);
                }
            }
        }

        if (count != N)
            System.out.println(0);
        else
            System.out.println(sb);
    }
}
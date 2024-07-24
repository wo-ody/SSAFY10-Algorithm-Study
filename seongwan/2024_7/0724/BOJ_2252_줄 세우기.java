import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] count;
    static List<Integer>[] nextList;
    static Deque<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        count = new int[N + 1];
        nextList = new List[N + 1];

        for (int i = 1; i <= N; i++) {
            nextList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int pre = Integer.parseInt(st.nextToken());
            int post = Integer.parseInt(st.nextToken());

            count[post]++;
            nextList[pre].add(post);
        }

        for (int i = 1; i <= N; i++) {
            if (count[i] == 0)
                queue.add(i);
        }

        while (!queue.isEmpty()) {
            int temp = queue.poll();

            for (Integer i : nextList[temp]) {
                count[i]--;
                if (count[i] == 0)
                    queue.add(i);
            }

            sb.append(temp).append(" ");
        }

        System.out.println(sb);
    }
}
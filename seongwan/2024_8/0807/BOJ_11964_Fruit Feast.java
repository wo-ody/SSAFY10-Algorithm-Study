import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    //과일 A,B, 물 먹기 1번의 경우를 bfs로 돌면서 최대 포만감을 찾아서 출력
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int A, B, T, ans;

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        bfs();

        System.out.println(ans);
    }

    static void bfs() {
        Deque<int[]> queue = new ArrayDeque<>();
        boolean[][] visit = new boolean[5000001][2];

        queue.add(new int[]{A, 0});
        queue.add(new int[]{B, 0});
        visit[A][0] = true;
        visit[B][0] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            int fill = now[0];
            int isDrink = now[1];

            ans = Math.max(ans, fill);

            //A를 먹는 경우
            if (fill + A <= T && !visit[fill + A][isDrink]) {
                visit[fill + A][isDrink] = true;
                queue.add(new int[]{fill + A, isDrink});
            }

            //B를 먹는 경우
            if (fill + B <= T && !visit[fill + B][isDrink]) {
                visit[fill + B][isDrink] = true;
                queue.add(new int[]{fill + B, isDrink});
            }

            //물을 한 번도 안 마신 경우
            if (isDrink == 0) {
                if (!visit[fill / 2][1]) {
                    visit[fill / 2][1] = true;
                    queue.add(new int[]{fill / 2, 1});
                }
            }
        }
    }
}
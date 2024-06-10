import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static boolean[] check;
    static long ans;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());

        check = new boolean[N + 1];
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(br.readLine());

            if (temp <= N && !check[temp])
                check[temp] = true;
            else
                pq.add(temp);
        }

        for (int i = 1; i <= N; i++) {
            if (!check[i]) {
                ans += Math.abs(i - pq.poll());
            }
        }

        System.out.println(ans);
    }
}
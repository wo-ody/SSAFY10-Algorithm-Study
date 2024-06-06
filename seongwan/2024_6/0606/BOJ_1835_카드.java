import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static Deque<Integer> deque = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());

        for (int i = N; i >= 1; i--) {
            deque.addFirst(i);

            for (int j = 0; j < i; j++) {
                deque.addFirst(deque.pollLast());
            }
        }

        for (int i = 0; i < N; i++) {
            sb.append(deque.poll()).append(" ");
        }

        System.out.println(sb);
    }
}
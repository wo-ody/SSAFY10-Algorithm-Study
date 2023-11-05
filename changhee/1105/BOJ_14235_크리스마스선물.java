import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o2,o1));
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());

            if (x == 0) {
                if (pq.isEmpty()) answer.append(-1).append("\n");
                else answer.append(pq.poll()).append("\n");
            } else {
                for (int j = 0; j < x; j++) {
                    pq.offer(Integer.parseInt(st.nextToken()));
                }
            }
        }

        System.out.print(answer);
    }
}

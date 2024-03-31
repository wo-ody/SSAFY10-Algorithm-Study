import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1927_최소힙 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                sb.append(pq.isEmpty()?0:pq.poll()).append("\n");
            }else {
                pq.add(num);
            }
        }
        System.out.println(sb);
    }
}

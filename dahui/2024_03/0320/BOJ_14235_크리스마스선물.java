import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_14235_크리스마스선물 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			if (num == 0) {
				if (pq.isEmpty()) sb.append(-1).append("\n");
				else sb.append(pq.poll()).append("\n");
			}else {
				for (int j = 0; j < num; j++) {
					pq.add(Integer.parseInt(st.nextToken()));
				}
			}
		}
		System.out.println(sb);
	}
}

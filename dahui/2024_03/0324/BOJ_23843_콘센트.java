import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_23843_콘센트 {
	public static void main(String[] args) throws Exception{
		//오름차순
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
		//내림차순
		PriorityQueue<Integer> pq2 = new PriorityQueue<>(((o1, o2) -> o2 - o1));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			pq2.add(Integer.parseInt(st.nextToken()));
		}
		for (int i = 0; i < M; i++) {
			pq.add(0);
		}
		for (int i = 0; i < N; i++) {
			int num = pq.poll();
			int plus = pq2.poll();
			pq.add(num + plus);
		}
		int ans = 0;
		while(!pq.isEmpty()) ans = pq.poll();
		System.out.println( ans );

	}
}

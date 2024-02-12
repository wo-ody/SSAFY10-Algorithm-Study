import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//현재 있는 카드 중 제일 작은 값 2개를 계속 합체하는 방식이
//제일 작은 점수를 만드는 법이므로
//pq에 카드 값들을 다 넣은 후 2개를 poll 해서 합친 뒤 합친 값 2개를 다시 pq에 넣는 식으로 진행
//m번만큼 진행 후 pq의 값 전체를 다 더해서 답을 찾음
//값이 21억을 넘을 수 있으므로 long으로 진행
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		PriorityQueue<Long> pq = new PriorityQueue<>();
		//입력 카드 값 넣기
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			pq.add(Long.parseLong(st.nextToken()));
		}

		//카드 합체
		for (int i = 0; i < M; i++) {
			long card1 = pq.poll();
			long card2 = pq.poll();
			long sum = card1 + card2;
			pq.add(sum);
			pq.add(sum);
		}

		long ans = 0;
		while (!pq.isEmpty()) {
			ans += pq.poll();
		}
		System.out.println(ans);
	}
}
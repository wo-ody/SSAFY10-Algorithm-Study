import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

//pq에 1번을 제외한 나머지의 예상 득표수를 넣고 득표수를 기준으로 내림차순으로 정렬
//pq에서 뽑아서 득표수를 낮추고 본인 득표수를 올리고를 반복
//pq에서 뽑은 득표수가 본인보다 낮다면 당선 그 때까지의 최소값을 출력
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, dasom, ans;
	static PriorityQueue<Integer> pq = new PriorityQueue<>((e1, e2) -> e2 - e1);

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());

		//본인 밖에 없다면 그대로 당선
		if (N == 1) {
			System.out.println(0);
			return;
		}

		int dasom = Integer.parseInt(br.readLine());
		for (int i = 2; i <= N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}

		while (true) {
			int temp = pq.poll();
			if (temp < dasom) {
				break;
			} else {
				//상대의 득표수를 뺏고 다시 pq에 넣어서 비교
				temp--;
				dasom++;
				ans++;
				pq.add(temp);
			}
		}
		System.out.println(ans);
	}
}
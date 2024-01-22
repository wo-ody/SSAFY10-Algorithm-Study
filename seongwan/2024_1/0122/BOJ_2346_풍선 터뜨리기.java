import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

//덱에 넣어놓고 꺼냈을 때 양수라면 first에서 N-1까지 last로 넣고 N번째를 꺼내 출력하고
//음수라면 last에서 N-1만큼 빼고 first로 넣고 N번째를 꺼내 출력하는 식을 반복한다
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static Deque<int[]> deque = new ArrayDeque<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			deque.add(new int[] { i + 1, Integer.parseInt(st.nextToken()) });
		}

		while (true) {
			int[] temp = deque.poll();
			sb.append(temp[0] + " ");
			if (deque.isEmpty())
				break;
			if (temp[1] > 0) {
				for (int i = 0; i < temp[1] - 1; i++) {
					int[] rocate = deque.poll();
					deque.add(rocate);
				}
			} else {
				for (int i = 0; i < Math.abs(temp[1]); i++) {
					int[] rocate = deque.pollLast();
					deque.addFirst(rocate);
				}
			}
		}
		System.out.println(sb);
	}
}
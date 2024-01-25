import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

//사람들을 큐에 담고 통과시키면서 순서가 아닌 사람은 스택에 담음
//순서인 사람 확인을 할 때 큐와 스택 제일 앞을 체크
//스택에 밑에 있는 번호보다 높은 번호가 쌓이게 될 때 Sad 출력
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	//원래 라인인 큐
	static Deque<Integer> line = new ArrayDeque<>();
	//사이의 공간인 스택
	static Deque<Integer> space = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			line.add(Integer.parseInt(st.nextToken()));
		}

		for (int i = 1; i < N + 1; i++) {
			int temp = 0;
			//스택의 제일 위 번호부터 확인
			if (!space.isEmpty()) {
				temp = space.pop();
				if (temp == i) {
					continue;
				} else {
					space.push(temp);
				}
			}
			while (true) {
				temp = line.poll();
				if (temp == i) {
					break;
				} else {
					//스택에 밑에 더 작은 값이 있게 된다면
					if (!space.isEmpty() && space.peek() < temp) {
						System.out.println("Sad");
						return;
					} else {
						space.push(temp);
					}
				}
			}
		}
		System.out.println("Nice");
	}
}
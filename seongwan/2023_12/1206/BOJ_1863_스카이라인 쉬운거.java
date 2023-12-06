import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, ans;
	static Deque<Integer> stack = new ArrayDeque();

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			int num = Integer.parseInt(st.nextToken());

			if (num == 0) {// 0이 나온 상황
				stack.clear();
			} else {// 나머지 상황
				if (stack.isEmpty()) {// 스택이 비어 있는 경우
					stack.push(num);
					ans++;
				} else {
					while (true) {
						if (stack.isEmpty()) {
							ans++;
							stack.push(num);
							break;
						}
						int temp = stack.pop();
						if (num > temp) {// 전에 들어온 숫자보다 큰 상황
							ans++;
							stack.push(temp);
							stack.push(num);
							break;
						} else if (num == temp) {// 전에 들어왔던 숫자와 같은 상황
							stack.push(temp);
							break;
						}
					}
				}
			}
		}

		System.out.println(ans);
	}
}
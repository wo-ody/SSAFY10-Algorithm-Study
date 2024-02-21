import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

//스택에 해당 수의 인덱스와 값을 담아가면서
//넣는 수의 값이 스택의 위에 있는 수의 값보다 크게 나왔을 때
//해당 수를 꺼내고 스택에 있는 수의 인덱스에 해당 값을 출력하고
//넣는 수의 값이 스택위의 수의 값보다 더 작아질 때까지 반복
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		Deque<int[]> stack = new ArrayDeque<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] answer = new int[N];

		for (int i = 0; i < N; i++) {
			int[] temp = new int[] {i, Integer.parseInt(st.nextToken())};

			//스택 위의 있는 수 현재 넣는 수의 값보다 더 클 때까지 비교 반복
			while (!stack.isEmpty()) {
				int[] compare = stack.peek();
				//스택의 위에 있는 수보다 더 큰 수가 나온 상황
				if (compare[1] < temp[1]) {
					answer[compare[0]] = temp[1];
					stack.pop();
				}//스택 위의 있는 수가 더 큰 상황
				else {
					break;
				}
			}

			//비교가 끝난 후에는 스택에 그대로 값 입력
			stack.push(temp);
		}

		//비교가 다 끝났음에도 오큰수가 나오지 않은 상황
		while (!stack.isEmpty()) {
			int[] temp = stack.pop();
			answer[temp[0]] = -1;
		}

		for (int i : answer) {
			sb.append(i + " ");
		}
		
		System.out.println(sb);
	}
}
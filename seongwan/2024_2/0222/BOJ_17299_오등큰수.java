import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

//처음에 입력을 받으면서 숫자별 빈도수를 체크해서 맵에서 저장한다.
//그 후에 받은 수를 순서대로 스택에 인덱스와 함께 값을 넣는다.
//스택이 비어있었다면 그냥 넣고 스택에 수가 있다면 그 값의 빈도수와
//넣을 수의 빈도수를 체크해서 빈도수가 더 큰 수가 들어오는 상황이면
//스택의 제일 위에 있던 수의 인덱스에 그 값을 넣고 스택에서 뺀다
//이 과정을 반복하며 스택에 남은 수들의 인덱스에는 -1을 출력
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		Map<Integer, Integer> frequency = new HashMap<>();
		int[] input = new int[N];
		int[] ans = new int[N];

		//수를 배열에 입력받으면서 빈도 수를 체크
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			input[i] = temp;
			if (frequency.containsKey(temp)) {
				frequency.put(temp, frequency.get(temp) + 1);
			} else {
				frequency.put(temp, 1);
			}
		}

		Deque<int[]> stack = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			int[] temp = new int[] {i, input[i]};

			while (!stack.isEmpty()) {
				int[] compare = stack.peek();

				//스택 위의 수보다 현재 스택에 들어갈 값의 빈도 수가 더 많다면
				if (frequency.get(compare[1]) < frequency.get(temp[1])) {
					ans[compare[0]] = temp[1];
					stack.pop();
				}//들어갈 수의 빈도 수가 더 적다면
				else {
					break;
				}
			}
			stack.push(temp);
		}

		//수를 다 탐색했음에도 스택에 남아있는 경우(빈도 수가 더 큰 오른쪽 수가 없는 경우)
		while (!stack.isEmpty()) {
			int[] temp = stack.pop();
			ans[temp[0]] = -1;
		}

		for (int num : ans) {
			sb.append(num + " ");
		}
		
		System.out.println(sb);
	}
}
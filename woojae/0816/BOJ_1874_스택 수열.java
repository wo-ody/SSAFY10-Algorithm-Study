import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)  // 수열 생성
			arr[i] = Integer.parseInt(br.readLine());
		int cur = 0;

		Stack<Integer> s = new Stack<Integer>();
		for (int i = 1; i <= n; i++) {
			s.push(i);  // 오름차순에 맞춰 값 삽입
			sb.append("+").append("\n");  // 삽입 심볼 삽입
			while (!s.isEmpty() && s.peek() == arr[cur]) {  // 스택이 비어있지 않고 마지막 값이 수열과 일치할 경우
				s.pop();  // 해당 값 제거
				sb.append("-").append("\n");  // 제거 심볼 삽입
				cur++;  // 다음 수열 값으로 갱신
				// while문을 사용하여 갱신된 수열 값과 스택의 마지막 값 비교를 실시간으로 검사
			}
		}
		System.out.println(s.isEmpty() ? sb : "NO");  // 스택이 비어있지 않은 경우 수열을 만들 수 없음
	}
}

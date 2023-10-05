import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[] arr;
		while (true) {
			arr = br.readLine().toCharArray();
			int len = arr.length;
			String answer = "yes";
			if (arr[0] == '.')
				break;
			Stack<Character> s = new Stack<Character>();
			for (int i = 0; i < len; i++) {
				if (arr[i] == '(' || arr[i] == '[')  // 여는 괄호들만 push
					s.push(arr[i]);
				else if (arr[i] == ')' || arr[i] == ']') {  // 닫는 괄호일 경우
					if (s.isEmpty()) {  // 비어있는 상태에서 넣는 경우는 균형 위배
						answer = "no";
						break;
					}
					else if((s.peek() == '(' && arr[i] == ')') || (s.peek() == '[' && arr[i] == ']'))
						s.pop();  // 균형을 이루는 경우만 제거
					else {  // 그 외 짝이 안 맞는 경우
						answer = "no";
						break;
					}
				}
				else if(arr[i] == '.')  // 종료 심볼이 들어왔을 때, 균형을 이루지 않는 상태
					answer = s.empty() ? "yes" : "no";
			}
			sb.append(answer).append("\n");  // 케이스가 끝날 때마다 결과 저장
		}
		System.out.println(sb);
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> arr = new Stack<Integer>();
		int answer = 0;
		int current = 0;
		int k = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < k; i++) {
			current = Integer.parseInt(br.readLine());
			if (current != 0) {  // 현재 입력으로 들어온 값이 0이 아니라면
				arr.add(current);  // 스택에 추가
                answer += current;  // 정답 갱신
            }
			else
				answer -= arr.pop();  // 0이라면 최근 값 제거 후 정답 갱신
				// 0이 나올 때 제거될 수가 있다는 것을 보장
		}
		System.out.println(answer);
	}
}



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

public class Main {

	public static void main(String[] args) throws NoSuchElementException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> stack = new ArrayDeque<Integer>(); // stack ArrayDeque로 정의
		int K = Integer.parseInt(br.readLine());

		for (int i = 0; i < K; i++) {
			int a = Integer.parseInt(br.readLine());
			if (a != 0) {
				stack.push(a); // 0이 아닐 시 값을 스택에 넣는다

			} else {
				stack.pop(); // 0일 때 스택에서 최근에 넣은 값 제거
			}

		}
		int sum = 0;
		for (Integer i : stack) {
			sum += i; // 스택 전체 요소를 더함.
		}
		System.out.println(sum);
	}

}
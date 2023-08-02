import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			String ps = sc.next(); // 괄호 문자열

			if (isVPS(ps)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

	// 주어진 문자열이 VPS인지를 판단하는 함수
	static boolean isVPS(String ps) {
		Deque<Character> stack = new ArrayDeque<>();

		for (int i = 0; i < ps.length(); i++) {
			char c = ps.charAt(i);

			if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				if (stack.isEmpty()) {
					return false; // 여는 괄호 없이 닫는 괄호가 나온 경우
				}
				stack.pop();
			}
		}

		return stack.isEmpty(); // 모든 괄호 쌍이 맞게 닫혔는지 확인
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int ans;
	static Deque<Integer> stack = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		boolean mode = false;//마이너스가 나온 시점부터 나온 숫자는 모두 뺄셈 처리를 하기 위한 체크용

		String s = br.readLine();
		for (int i = 0; i < s.length(); i++) {
			if (!mode && s.charAt(i) == '-') {
				mode = true;

				int temp = 0;
				int size = stack.size();
				for (int j = 0; j < size; j++) {
					temp += stack.pop() * pow(10, j);
				}

				ans += temp;
			} else if (!mode && s.charAt(i) == '+') {
				int temp = 0;
				int size = stack.size();
				for (int j = 0; j < size; j++) {
					temp += stack.pop() * pow(10, j);
				}

				ans += temp;
			} else if (mode && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
				int temp = 0;
				int size = stack.size();
				for (int j = 0; j < size; j++) {
					temp += stack.pop() * pow(10, j);
				}

				ans -= temp;
			} else {
				stack.push(s.charAt(i) - '0');
			}
		}
		int temp = 0;
		int size = stack.size();
		for (int j = 0; j < size; j++) {
			temp += stack.pop() * pow(10, j);
		}

		if (mode)
			ans -= temp;
		else
			ans += temp;

		System.out.println(ans);

	}

	static int pow(int n, int m) {
		int value = 1;
		for (int i = 0; i < m; i++) {
			value *= n;
		}
		return value;
	}
}
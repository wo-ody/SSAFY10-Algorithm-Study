import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			Stack<Character> stack = new Stack();
			String str = br.readLine();
			String result = "yes";

			if (str.charAt(0) == '.')
				break;

			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (c == '(' || c == '[') {
					stack.push(c);
				} else if (c == ')') {
					if (stack.isEmpty() || stack.pop() != '(') {
						result = "no";
						break;
					}
				} else if (c == ']') {
					if (stack.isEmpty() || stack.pop() != '[') {
						result = "no";
						break;
					}
				}
			}

			if (!stack.isEmpty()) {
				result = "no";
			}

			System.out.println(result);
		}
	}
}

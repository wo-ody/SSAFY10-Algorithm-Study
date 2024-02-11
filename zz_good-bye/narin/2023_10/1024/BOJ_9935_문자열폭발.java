import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = br.readLine();
		String target = br.readLine();

		Stack<Character> stack = new Stack<>();
		int len = target.length();

		for (int s = 0; s < str.length(); s++) {
			stack.push(str.charAt(s));
			boolean same = false;

			if (stack.size() >= len) {

				if (stack.peek() == target.charAt(len - 1)) {
					int count = 0;

					for (int j = 0; j < len; j++) {
						if (stack.get(stack.size() - len + j) == target.charAt(j)) {
							count++;
						}
					}

					if (count == len)
						same = true;

				}

				if (same) {
					for (int i = 0; i < len; i++) {
						stack.pop();
					}
				}
			}
		}

		if (stack.isEmpty()) {
			sb.append("FRULA");
		} else {
			for (int i = 0; i < stack.size(); i++) {
				sb.append(stack.get(i));
			}
		}

		System.out.println(sb);

	}
}

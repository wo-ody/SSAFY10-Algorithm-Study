import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Character> stack = new ArrayDeque<>();
		Deque<Character> tempStack = new ArrayDeque<>();

		boolean[] visit = new boolean[26];

		String s = br.readLine();
		int ans = 0;

		for (int i = 0; i < s.length(); i++) {
			char temp = s.charAt(i);

			if (!visit[temp - 'A']) {
				stack.push(temp);
				visit[temp - 'A'] = true;
			} else {
				while (true) {
					char stackChar = stack.pop();
					if (stackChar == temp)
						break;

					ans++;
					tempStack.push(stackChar);
				}

				int size = tempStack.size();
				for (int j = 0; j < size; j++) {
					stack.push(tempStack.pop());
				}
			}
		}
		System.out.println(ans);
	}
}
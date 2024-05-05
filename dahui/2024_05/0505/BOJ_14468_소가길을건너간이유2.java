import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class BOJ_14468_소가길을건너간이유2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String cows = br.readLine();
		int ans = 0;
		boolean[] alpha = new boolean[26];
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < cows.length(); i++) {
			char c = cows.charAt(i);
			int num = c - 'A';
			if (!alpha[num]) {
				stack.push(c);
				alpha[num] = true;
			}
			else {
				Stack<Character> stack2 = new Stack<>();
				while(true) {
					char c2 = stack.pop();
					if (c2 == c) break;
					stack2.push(c2);
					ans++;
				}
				while(!stack2.isEmpty()) {
					stack.push(stack2.pop());
				}
			}
		}
		System.out.println(ans);

	}
}

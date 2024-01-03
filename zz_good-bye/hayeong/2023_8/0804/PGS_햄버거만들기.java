import java.util.Stack;

public class Solution {
	static int cnt = 0;
	static String order = "1231";

	public static int solution(int[] ingredient) {
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < ingredient.length; i++) {
			stack.add(ingredient[i]);

			if (stack.size() >= 4) {
				StringBuilder sb = new StringBuilder();
				int fourth = stack.pop();
				int third = stack.pop();
				int second = stack.pop();
				int first = stack.pop();
				sb.append(first);
				sb.append(second);
				sb.append(third);
				sb.append(fourth);
        
				if (!sb.toString().equals(order)) {
					stack.add(first);
					stack.add(second);
					stack.add(third);
					stack.add(fourth);
				} else {
					cnt++;
				}
			}
		}
		return cnt;
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	private static String result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			result = "YES";
			String str = br.readLine();
			Stack<Character> ps = new Stack<>();
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (c == '(') {
					ps.add(c);
				} else {
					if (!ps.isEmpty()) {
						ps.pop();
					} else {
						result = "NO";
						break;
					}
				}
			}

			if (!ps.isEmpty()) {
				result = "NO";
			}

			sb.append(result + "\n");
		}
		System.out.println(sb);
	}
}

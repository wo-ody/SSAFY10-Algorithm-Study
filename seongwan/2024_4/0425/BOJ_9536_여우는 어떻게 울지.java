import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int T;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String s = br.readLine();
			Set<String> set = new HashSet<>();

			while (true) {
				st = new StringTokenizer(br.readLine());
				if (st.countTokens() == 5)
					break;

				st.nextToken();
				st.nextToken();
				set.add(st.nextToken());
			}

			st = new StringTokenizer(s);
			int count = st.countTokens();
			for (int i = 0; i < count; i++) {
				String tmp = st.nextToken();
				if (!set.contains(tmp))
					sb.append(tmp).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
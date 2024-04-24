import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_9536_여우는어떻게울지 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		HashSet<String> set = new HashSet<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < T; i++) {
			String str = br.readLine();
			while (true) {
				String str1 = br.readLine();
				if (str1.equals("what does the fox say?"))
					break;

				StringTokenizer st = new StringTokenizer(str1, " ");
				st.nextToken();
				st.nextToken();
				String sound = st.nextToken();
				set.add(sound);
			}
			StringTokenizer st1 = new StringTokenizer(str, " ");

			while (st1.hasMoreTokens()) {
				String s = st1.nextToken();
				if (!set.contains(s)) {
					sb.append(s).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

}

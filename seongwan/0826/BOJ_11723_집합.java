import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int M, x;
	static Set<Integer> set = new HashSet<>();
	static String s;
	static boolean chk;

	public static void main(String[] args) throws Exception {
		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			s = st.nextToken();
			x = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0;
			oper(s, x);
		}
		System.out.println(sb);

	}

	static void oper(String s, int x) {
		if (s.equals("add"))
			set.add(x);
		else if (s.equals("remove"))
			set.remove(x);
		else if (s.equals("check"))
			sb.append(set.contains(x) ? 1 : 0).append("\n");
		else if (s.equals("toggle"))
			if (set.contains(x))
				set.remove(x);
			else
				set.add(x);
		else if (s.equals("all"))
			for (int i = 1; i <= 20; i++) {
				set.add(i);
			}
		else if (s.equals("empty"))
			set.clear();
	}

}

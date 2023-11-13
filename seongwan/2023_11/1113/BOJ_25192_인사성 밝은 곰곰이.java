import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, ans;
	static Set<String> set = new HashSet<>();

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());

		br.readLine();

		for (int i = 0; i < N - 1; i++) {
			String s = br.readLine();
			if (s.equals("ENTER")) {
				ans += set.size();
				set.clear();
				continue;
			}
			set.add(s);
		}
		ans += set.size();
		System.out.println(ans);
	}
}
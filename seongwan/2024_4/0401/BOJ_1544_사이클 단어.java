import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static Set<String> set = new HashSet<>();

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());

		set.add(br.readLine());

		for (int i = 0; i < N - 1; i++) {
			String s = br.readLine();
			//순서를 바꿔보지 않아도 이미 있는 단어면 continue
			if (set.contains(s))
				continue;

			boolean check = false;
			for (int j = 0; j < s.length() - 1; j++) {
				String temp = s.substring(j + 1) + s.substring(0, j + 1);
				if (set.contains(temp)) {
					check = true;
					break;
				}
			}
			if (!check)
				set.add(s);
		}
		System.out.println(set.size());
	}
}
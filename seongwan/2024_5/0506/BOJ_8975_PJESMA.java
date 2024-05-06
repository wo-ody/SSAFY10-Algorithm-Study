import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<String> set = new HashSet<String>();

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}

		int M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			String temp = br.readLine();
			set.remove(temp);

			if (set.size() == N / 2) {
				System.out.println(i + 1);
				return;
			}
		}
	}
}
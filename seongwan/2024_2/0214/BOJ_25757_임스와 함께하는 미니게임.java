import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		char game = st.nextToken().charAt(0);

		Set<String> user = new HashSet<>();
		for (int i = 0; i < N; i++) {
			user.add(br.readLine());
		}

		switch (game) {
			case 'Y':
				System.out.println(user.size());
				break;
			case 'F':
				System.out.println(user.size() / 2);
				break;
			case 'O':
				System.out.println(user.size() / 3);
		}
	}
}
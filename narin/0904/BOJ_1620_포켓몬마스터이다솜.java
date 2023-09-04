import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	private static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		HashMap<String, Integer> name = new HashMap<>();
		String[] num = new String[N + 1];

		for (int i = 1; i <= N; i++) {
			String temp = br.readLine();
			name.put(temp, i);
			num[i] = temp;
		}

		for (int i = 0; i < M; i++) {
			String temp = br.readLine();
			if (temp.charAt(0) >= 'A' && temp.charAt(0) <= 'Z') {
				sb.append(name.get(temp) + "\n");
			} else {
				sb.append(num[Integer.parseInt(temp)] + "\n");
			}
		}

		System.out.println(sb);
	}
}

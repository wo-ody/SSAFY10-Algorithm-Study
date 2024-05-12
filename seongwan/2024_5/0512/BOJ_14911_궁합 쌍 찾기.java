import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		Set<Long> set = new HashSet<>();
		int ans = 0;

		int N = st.countTokens();

		int[] input = new int[N];

		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(input);

		int sum = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if (input[i] + input[j] == sum) {
					long temp = (long)input[i] * 1000000 + input[j];
					if (set.contains(temp))
						break;
					set.add(temp);
					sb.append(input[i]).append(" ").append(input[j]).append("\n");
					ans++;
				}
			}
		}
		sb.append(ans);
		System.out.println(sb);
	}
}
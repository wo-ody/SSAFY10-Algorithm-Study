import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, K, ans;
	static char[] input;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		visit = new boolean[N];
		input = br.readLine().toCharArray();

		for (int i = 0; i < N; i++) {
			if (visit[i])
				continue;
			char temp = input[i];
			for (int j = i - K; j <= i + K; j++) {
				if (j < 0 || j >= N || visit[j])
					continue;
				if (input[j] != temp) {
					ans++;
					visit[i] = true;
					visit[j] = true;
					break;
				}
			}
		}
		System.out.println(ans);
	}
}
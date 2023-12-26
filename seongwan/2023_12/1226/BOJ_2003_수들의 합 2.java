import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, ans;
	static int[] sum;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		sum = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
		} // 누적합을 구함

		for (int i = 0; i <= N - 1; i++) {
			for (int j = i + 1; j <= N; j++) {
				if (sum[j] - sum[i] == M) {
					ans++;
					break;// M이 나온 순간 앞으로의 합은 계속 커지므로 답이 나올 수 없음
				}
			}
		}
		System.out.println(ans);
	}
}
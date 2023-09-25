import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int n, m;
	static int[] arr;
	static int[][] range;
	static int[] cum_sum;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		range = new int[m + 1][2];
		for(int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			range[i][0] = Integer.parseInt(st.nextToken());
			range[i][1] = Integer.parseInt(st.nextToken());
		}
		solve();
		System.out.println(sb);

	}
	
	static void solve() {
		cum_sum = new int[n + 1];
		for(int i = 1; i <= n; i++) 
			cum_sum[i] = cum_sum[i - 1] + arr[i];
		
		for (int r = 1; r <= m; r++) {
			int i = range[r][0];
			int j = range[r][1];
			sb.append(i == 1 ? cum_sum[j] : i == j ? arr[j] : cum_sum[j] - cum_sum[i - 1]).append("\n");
		}
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1719_택배 {
	static int[][][] ans;
	static int n,m;
	static int[] time;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		ans = new int[n+1][n+1][2];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				ans[i][j][0] = Integer.MAX_VALUE/2;
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());

			ans[a][b][0] = t;
			ans[a][b][1] = b;
			ans[b][a][0] = t;
			ans[b][a][1] = a;
		}

		for (int i = 1; i <= n; i++) {
			floyd(i);
		}

		for (int i = 1; i <= n ; i++) {
			for (int j = 1; j <= n; j++) {
				if (i==j) sb.append("-");
				else sb.append(ans[i][j][1]);
				sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static void floyd(int s) {
		for (int i = 1; i <= n ; i++) {
			for (int j = 1; j <= n ; j++) {
				if (s == i || i == j || s == j) continue;
				if (ans[i][j][0] > ans[i][s][0] + ans[s][j][0]) {
					ans[i][j][0] = ans[i][s][0] + ans[s][j][0];
					ans[i][j][1] = ans[i][s][1];
				}
			}
		}
	}
}

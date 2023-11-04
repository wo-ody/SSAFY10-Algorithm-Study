import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N, M;
	private static String result;
	private static int[][] city;
	private static int[] plan;
	private static boolean[] isVisited;

	private static void dfs(int index) {
		isVisited[index] = true;

		for (int i = 1; i <= N; i++) {
			if (city[index][i] == 1 && !isVisited[i]) {
				dfs(i);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		city = new int[N + 1][N + 1];
		plan = new int[M];
		isVisited = new boolean[N + 1];

		result = "YES";

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			plan[i] = Integer.parseInt(st.nextToken());
		}

		dfs(plan[0]);

		for (int i = 0; i < M; i++) {
			if (!isVisited[plan[i]]) {
				result = "NO";
			}
		}

		System.out.println(result);
	}
}

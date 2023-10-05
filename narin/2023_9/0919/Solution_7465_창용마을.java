import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	private static int T, N, M, count;
	private static List<Integer>[] rel;
	private static boolean[] isVisited;

	private static void dfs(int index) {

		isVisited[index] = true;

		for (int i = 0; i < rel[index].size(); i++) {
			if (!isVisited[rel[index].get(i)]) {
				dfs(rel[index].get(i));
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			count = 0;

			rel = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++) {
				rel[i] = new ArrayList<>();
			}

			isVisited = new boolean[N + 1];

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				rel[x].add(y);
				rel[y].add(x);
			}

			for (int i = 1; i <= N; i++) {
				if (!isVisited[i]) {
					dfs(i);
					count++;
				}
			}

			sb.append(count).append("\n");
		}

		System.out.println(sb);
	}
}

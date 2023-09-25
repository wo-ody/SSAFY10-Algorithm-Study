import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	private static int N, M, count;
	private static ArrayList<Integer>[] connect;

	private static boolean[] isVisited;

	private static void dfs(int n) {
		isVisited[n] = true;

		for (int i = 0; i < connect[n].size(); i++) {
			if (!isVisited[connect[n].get(i)]) {
				isVisited[connect[n].get(i)] = true;
				dfs(connect[n].get(i));
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		count = 0;

		connect = new ArrayList[N + 1];
		isVisited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			connect[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			connect[a].add(b);
			connect[b].add(a);
		}

		for (int i = 1; i <= N; i++) {
			if (!isVisited[i]) {
				dfs(i);
				count++;
			}

		}

		System.out.println(count);
	}
}

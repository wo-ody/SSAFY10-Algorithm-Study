import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static int N, M, result;
	private static List<Integer>[] computer;
	private static boolean[] isVisited;

	private static void dfs(int index) {
		isVisited[index] = true;

		for (int i = 0; i < computer[index].size(); i++) {
			if (!isVisited[computer[index].get(i)]) {
				result++;
				dfs(computer[index].get(i));
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		computer = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			computer[i] = new ArrayList<>();
		}

		isVisited = new boolean[N + 1];
		result = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			computer[from].add(to);
			computer[to].add(from);

		}

		dfs(1);

		System.out.println(result);
	}
}

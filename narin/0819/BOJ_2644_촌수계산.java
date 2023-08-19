import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static int n, m;
	private static int num1, num2, result;
	private static List<Integer>[] relation;
	private static boolean[] isVisited;

	private static void dfs(int index, int count) {
		isVisited[index] = true;

		if (index == num2) {
			result = count;
			return;
		}

		for (int i : relation[index]) {
			if (!isVisited[i]) {
				dfs(i, count + 1);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		num1 = Integer.parseInt(st.nextToken());
		num2 = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(br.readLine());
		relation = new ArrayList[n + 1];
		isVisited = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			relation[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			relation[x].add(y);
			relation[y].add(x);
		}

		dfs(num1, 0);

		if (result == 0) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}
	}
}

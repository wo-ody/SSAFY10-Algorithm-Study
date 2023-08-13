import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static ArrayList<Integer> list[];
	static int[] parent;
	static boolean[] isVisited;

	private static void dfs(int index) {
		isVisited[index] = true;
		for (int i : list[index]) {
			if (!isVisited[i]) {
				parent[i] = index;
				dfs(i);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		isVisited = new boolean[N + 1];
		list = new ArrayList[N + 1];
		parent = new int[N + 1];

		for (int i = 0; i < N + 1; i++) {
			list[i] = new ArrayList<>();
		}

		for (int n = 0; n < N - 1; n++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list[a].add(b);
			list[b].add(a);
		}

		dfs(1);

		for (int i = 2; i < parent.length; i++) {
			System.out.println(parent[i]);
		}
	}

}

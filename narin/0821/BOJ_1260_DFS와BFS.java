import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static int N, M, V;
	private static List<Integer>[] num;
	private static boolean[] isVisited;

	private static void dfs(int index) {
		isVisited[index] = true;
		System.out.print(index + " ");

		for (int i = 0; i < num[index].size(); i++) {
			if (!isVisited[num[index].get(i)]) {
				dfs(num[index].get(i));
			}
		}
	}

	private static void bfs(int index) {
		Queue<Integer> q = new ArrayDeque<>();
		isVisited[index] = true;
		q.add(index);
		while (!q.isEmpty()) {
			int temp = q.poll();
			for (int i = 0; i < num[temp].size(); i++) {
				if (!isVisited[num[temp].get(i)]) {
					isVisited[num[temp].get(i)] = true;
					q.add(num[temp].get(i));
				}
			}
			System.out.print(temp + " ");
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		num = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			num[i] = new ArrayList<>();
		}

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			num[a].add(b);
			num[b].add(a);
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(num[i]);
		}

		isVisited = new boolean[N + 1];
		dfs(V);
		System.out.println();
		isVisited = new boolean[N + 1];
		bfs(V);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int cnt;
	static int[] checked;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        StringTokenizer strTo;

		strTo = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(strTo.nextToken());
		int m = Integer.parseInt(strTo.nextToken());
		int r = Integer.parseInt(strTo.nextToken());

		checked = new int[n + 1];

		// 그래프 초기화
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		// list에 값 저장
		for (int i = 0; i < m; i++) {
			strTo = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(strTo.nextToken());
			int v = Integer.parseInt(strTo.nextToken());

			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		for (int i = 1; i <= n; i++) {
			Collections.sort(graph.get(i));
		}

		cnt = 1;
		dfs(r);

		for (int i = 1; i < checked.length; i++) {
			sb.append(checked[i]).append("\n");
		}
		System.out.println(sb);

	}

	private static void dfs(int node) {

		checked[node] = cnt;

		for (int i = 0; i < graph.get(node).size(); i++) {
			int newNode = graph.get(node).get(i);
			if (checked[newNode] == 0) {
				cnt++;
				dfs(newNode);
			}
		}

	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static int n, result, node; // 가장 먼 노드를 저장
	private static List<Tree>[] tree;
	private static boolean[] isVisited;

	static class Tree {
		int idx, weight;

		// 연결된 곳과 가중치를 받아온다.
		public Tree(int idx, int weight) {
			this.idx = idx;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Tree [idx=" + idx + ", weight=" + weight + "]";
		}

	}

	private static void dfs(int index, int dis) {
		isVisited[index] = true;

		if (result < dis) {
			// 최댓값이면 result 값과 node의 위치 변경
			result = dis;
			node = index;
		}
		for (int i = 0; i < tree[index].size(); i++) {
			if (!isVisited[tree[index].get(i).idx]) {
				// 재귀호출 시, 현재 가리키는 값과 누적 가중치+현재 가중치 를 입력 받는다.
				dfs(tree[index].get(i).idx, dis + tree[index].get(i).weight);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		n = Integer.parseInt(br.readLine());

		tree = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			tree[i] = new ArrayList<>();
		}

		result = Integer.MIN_VALUE;

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			// 양방향에 가중치 입력
			tree[a].add(new Tree(b, w));
			tree[b].add(new Tree(a, w));
		}

		isVisited = new boolean[n + 1];
		// 시작점부터 가장 먼 곳까지의 거리 구하기
		dfs(1, 0);

		isVisited = new boolean[n + 1];
		// 가장 먼 곳에서 먼 곳 구하기
		dfs(node, 0);

		System.out.println(result);

	}
}

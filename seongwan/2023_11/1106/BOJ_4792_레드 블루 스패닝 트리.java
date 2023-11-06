import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	// 파랑색을 우선으로 스패닝트리를 만들었을 때 파랑 간선의 수>=k>=빨강색을 우선으로 스패닝트리를 만들었을 때 파랑 간선의 수
	// 를 만족하면 가능으로 1표시 불가능은 0표시
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m, k;
	static int[] parents;
	static List<int[]> Blue = new ArrayList<>();
	static List<int[]> Red = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		while (true) {
			Blue.clear();
			Red.clear();
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			if (n == 0) {
				System.out.println(sb);
				return;
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				String color = st.nextToken();
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				if (color.equals("B"))
					Blue.add(new int[] { from, to });
				else
					Red.add(new int[] { from, to });
			}
			if (k >= redmst() && k <= bluemst())
				sb.append(1 + "\n");
			else
				sb.append(0 + "\n");
		}

	}

	static int bluemst() {// k보다 같거나 커야함
		make();
		int cnt = 0;
		int blue = 0;
		for (int[] node : Blue) {
			if (union(node[0], node[1])) {
				blue++;
				cnt++;
				if (cnt == n - 1)
					return blue;
			}
		}
		for (int[] node : Red) {
			if (union(node[0], node[1])) {
				cnt++;
				if (cnt == n - 1)
					return blue;
			}
		}
		return -1;// mst를 만들지 못한 경우
	}

	static int redmst() {// k보다 같거나 작아야함
		make();
		int cnt = 0;
		int blue = 0;
		for (int[] node : Red) {
			if (union(node[0], node[1])) {
				cnt++;
				if (cnt == n - 1)
					return blue;
			}
		}
		for (int[] node : Blue) {
			if (union(node[0], node[1])) {
				blue++;
				cnt++;
				if (cnt == n - 1)
					return blue;
			}
		}
		return Integer.MAX_VALUE;// mst를 만들지 못한 경우
	}

	static void make() {
		parents = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}
	}

	static int find(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot)
			return false;
		parents[bRoot] = aRoot;
		return true;

	}

}
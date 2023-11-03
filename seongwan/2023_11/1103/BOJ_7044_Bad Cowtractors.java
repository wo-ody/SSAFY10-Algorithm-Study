import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M;
	static int[][] edgelist;
	static int parents[];
	static boolean end;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		edgelist = new int[M][3];
		parents = new int[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			edgelist[i] = new int[] { from, to, cost };
		}

		Arrays.sort(edgelist, (e1, e2) -> e2[2] - e1[2]);// 간선 가중치 기준 내림차순 정렬
		make();

		int result = 0;// MST 비용
		int count = 0;// 연결된 간선 개수
		for (int[] e : edgelist) {
			if (union(e[0], e[1])) {
				result += e[2];
				if (++count == N - 1) {
					end = true;
					break;
				}
			}
		}
		if (!end)
			System.out.println(-1);
		else
			System.out.println(result);
	}

	static void make() {
		parents = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
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
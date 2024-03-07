import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//세그먼트 트리를 이용하여 교차점의 개수를 구한다.
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] tree;
	static int[] edge;

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			long ans = 0;
			tree = new int[4 * M];

			//간선 입력
			edge = new int[K];
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				edge[j] = a * 1_000_000 + b;
			}

			Arrays.sort(edge);

			for (int j = 0; j < K; j++) {
				int a = edge[j] / 1_000_000;
				int b = edge[j] % 1_000_000;
				if (a != 1) {
					ans += query(1, 1, M, b + 1);
				}
				update(1, 1, M, b);
			}
			sb.append("Test case " + (i + 1) + ": " + ans + "\n");
		}
		System.out.println(sb);
	}

	static void update(int node, int left, int right, int idx) {
		//범위와 상관 없는 경우
		if (idx < left || idx > right) {
			return;
		}
		if (left == right) {
			tree[node] += 1;
			return;
		}

		int mid = (left + right) / 2;
		update(node << 1, left, mid, idx);
		update(node << 1 | 1, mid + 1, right, idx);

		tree[node] = tree[node << 1] + tree[node << 1 | 1];
	}

	static int query(int node, int left, int right, int qleft) {
		//범위와 상관 없는 경우
		if (qleft > right) {
			return 0;
		}
		//완전히 범위에 속하는 경우
		if (qleft <= left) {
			return tree[node];
		}

		int mid = (left + right) / 2;
		int lR = query(node << 1, left, mid, qleft);
		int RR = query(node << 1 | 1, mid + 1, right, qleft);

		return lR + RR;
	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//세그먼트 트리를 이용하여 교차점의 개수를 구함
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] tree;
	static int[] idx;

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			long ans = 0;
			tree = new int[4 * n];
			idx = new int[n + 1];

			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				idx[Integer.parseInt(st.nextToken())] = j + 1;
			}

			st = new StringTokenizer(br.readLine());
			//순서대로 돌면서 해당 값의 인덱스를 저장
			for (int j = 0; j < n; j++) {
				int temp = idx[Integer.parseInt(st.nextToken())];
				ans += query(1, 1, n, temp + 1);
				update(1, 1, n, temp);
			}

			sb.append(ans + "\n");
		}
		System.out.println(sb);
	}

	static void update(int node, int left, int right, int idx) {
		//범위와 상관 없는 경우
		if (idx < left || idx > right) {
			return;
		}
		if (left == right) {
			tree[node] = 1;
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
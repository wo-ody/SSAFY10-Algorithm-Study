import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//세그먼트 트리를 사용한다.
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] input;
	static int[] tree;

	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		input = new int[N + 1];
		tree = new int[4 * N];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		init(1, 1, N);
		
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());

			//update
			if (cmd == 1) {
				int idx = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());
				update(1, 1, N, idx, value);
			}
			//query
			else {
				int qleft = Integer.parseInt(st.nextToken());
				int qright = Integer.parseInt(st.nextToken());

				sb.append(query(1, 1, N, qleft, qright) + "\n");
			}
		}
		System.out.println(sb);
	}

	static void init(int node, int left, int right) {
		if (left == right) {
			tree[node] = input[left];
			return;
		}

		int mid = (left + right) / 2;
		init(node * 2, left, mid);
		init(node * 2 + 1, mid + 1, right);

		tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
	}

	static void update(int node, int left, int right, int idx, int value) {
		if (left > idx || right < idx) {
			return;
		}

		if (left == right) {
			tree[node] = value;
			return;
		}

		int mid = (left + right) / 2;
		update(node * 2, left, mid, idx, value);
		update(node * 2 + 1, mid + 1, right, idx, value);

		tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
	}

	static int query(int node, int left, int right, int qleft, int qright) {
		//탐색 범위가 쿼리 범위랑 상관이 없는 경우
		if (qright < left || qleft > right) {
			return Integer.MAX_VALUE;
		}

		if (qleft <= left && qright >= right) {
			return tree[node];
		}

		int mid = (left + right) / 2;
		int leftResult = query(node * 2, left, mid, qleft, qright);
		int rightResult = query(node * 2 + 1, mid + 1, right, qleft, qright);

		return Math.min(leftResult, rightResult);
	}
}
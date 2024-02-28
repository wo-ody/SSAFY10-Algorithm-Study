import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//세그먼트 트리를 사용한다.
//long형을 사용한다
//x>y인 경우도 있으므로 math.min,max로 비교 후 query를 실행한다.
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] input;
	static long[] tree;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		input = new int[N + 1];
		tree = new long[4 * N];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		init(1, 1, N);

		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());

			//query
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int qleft = Math.min(x, y);
			int qright = Math.max(x, y);
			sb.append(query(1, 1, N, qleft, qright) + "\n");

			//update
			int idx = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			update(1, 1, N, idx, value);

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

		tree[node] = tree[node * 2] + tree[node * 2 + 1];
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

		tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}

	static long query(int node, int left, int right, int qleft, int qright) {
		//탐색 범위가 쿼리 범위랑 상관이 없는 경우
		if (qright < left || qleft > right) {
			return 0;
		}

		if (qleft <= left && qright >= right) {
			return tree[node];
		}

		int mid = (left + right) / 2;
		long leftResult = query(node * 2, left, mid, qleft, qright);
		long rightResult = query(node * 2 + 1, mid + 1, right, qleft, qright);

		return leftResult + rightResult;
	}
}
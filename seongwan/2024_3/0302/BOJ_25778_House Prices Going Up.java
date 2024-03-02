import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//세그먼트 트리를 사용하여 구간합을 노드에 저장
//long형으로 트리를 구성
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] input;
	static long[] tree;

	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());

		input = new int[N + 1];
		tree = new long[4 * N];

		for (int i = 1; i <= N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}

		init(1, 1, N);

		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			char cmd = st.nextToken().charAt(0);

			//update
			if (cmd == 'U') {
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
		init(node << 1, left, mid);
		init(node << 1 | 1, mid + 1, right);

		tree[node] = tree[node << 1] + tree[node << 1 | 1];
	}

	static void update(int node, int left, int right, int idx, int value) {
		if (left > idx || right < idx) {
			return;
		}

		if (left == right) {
			tree[node] += value;
			return;
		}

		int mid = (left + right) / 2;
		update(node << 1, left, mid, idx, value);
		update(node << 1 | 1, mid + 1, right, idx, value);

		tree[node] = tree[node << 1] + tree[node << 1 | 1];
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
		long leftResult = query(node << 1, left, mid, qleft, qright);
		long rightResult = query(node << 1 | 1, mid + 1, right, qleft, qright);

		return leftResult + rightResult;
	}
}
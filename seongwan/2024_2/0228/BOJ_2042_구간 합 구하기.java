import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//세그먼트 트리를 이용해 처리하면 됨
//수의 범위는 long
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static long[] input;

	static long[] tree;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		input = new long[N + 1];
		tree = new long[4 * N];
		for (int i = 1; i <= N; i++) {
			input[i] = Long.parseLong(br.readLine());
		}

		init(1, 1, N);

		//쿼리 진행
		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());

			//update
			if (cmd == 1) {
				int idx = Integer.parseInt(st.nextToken());
				long value = Long.parseLong(st.nextToken());
				update(1, 1, N, idx, value);
			}
			//구간 합 구하기
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

		tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}

	static void update(int node, int left, int right, int idx, long value) {
		//상관이 없는 범위
		if (idx < left || idx > right) {
			return;
		}

		//바꿀 idx를 만난 경우
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
		if (qright < left || qleft > right) {
			return 0;
		}

		//쿼리의 범위에 탐색 범위가 완전히 속하는 경우
		if (left >= qleft && right <= qright) {
			return tree[node];
		}

		int mid = (left + right) / 2;
		long leftResult = query(node * 2, left, mid, qleft, qright);
		long rightResult = query(node * 2 + 1, mid + 1, right, qleft, qright);

		return leftResult + rightResult;
	}
}
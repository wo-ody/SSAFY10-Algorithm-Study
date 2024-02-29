import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//세그먼트 트리로 해결
//br.readLine()!=null인 동안 진행
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] input;
	static int[] tree;

	public static void main(String[] args) throws Exception {
		String str = "";

		//EOF
		while ((str = br.readLine()) != null && !str.isEmpty()) {
			st = new StringTokenizer(str);
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			input = new int[N + 1];
			tree = new int[4 * N];

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				int num = Integer.parseInt(st.nextToken());

				//양수,음수,0의 정보만 남겨놓음
				if (num >= 1)
					num = 1;
				else if (num <= -1) {
					num = -1;
				}
				input[i] = num;
			}

			init(1, 1, N);

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				char cmd = st.nextToken().charAt(0);

				//변경
				if (cmd == 'C') {
					int idx = Integer.parseInt(st.nextToken());
					int value = Integer.parseInt(st.nextToken());
					//양수인 경우
					if (value >= 1)
						value = 1;
					else if (value <= -1) {
						value = -1;
					}

					update(1, 1, N, idx, value);
				}
				//구간 곱
				else {
					int qleft = Integer.parseInt(st.nextToken());
					int qright = Integer.parseInt(st.nextToken());
					int result = query(1, 1, N, qleft, qright);

					//양수인 경우
					if (result == 1)
						sb.append("+");
						//음수인 경우
					else if (result == -1) {
						sb.append("-");
					}
					//0인 경우
					else {
						sb.append(0);
					}
				}
			}
			sb.append("\n");
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

		tree[node] = tree[node * 2] * tree[node * 2 + 1];
	}

	static void update(int node, int left, int right, int idx, int value) {
		//idx가 속하지 않는 범위
		if (idx < left || idx > right) {
			return;
		}

		if (left == right) {
			tree[node] = value;
			return;
		}

		int mid = (left + right) / 2;
		update(node * 2, left, mid, idx, value);
		update(node * 2 + 1, mid + 1, right, idx, value);

		tree[node] = tree[node * 2] * tree[node * 2 + 1];
	}

	static int query(int node, int left, int right, int qleft, int qright) {
		if (qleft > right || qright < left) {
			return 1;
		}

		if (qleft <= left && qright >= right) {
			return tree[node];
		}

		int mid = (left + right) / 2;
		int leftResult = query(node * 2, left, mid, qleft, qright);
		int rightResult = query(node * 2 + 1, mid + 1, right, qleft, qright);

		return leftResult * rightResult;
	}
}
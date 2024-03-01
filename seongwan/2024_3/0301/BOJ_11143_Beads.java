import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//세그먼트 트리를 사용해 구간합을 저장한다.
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] tree;

	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int B = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			int Q = Integer.parseInt(st.nextToken());

			tree = new int[4 * B];

			for (int j = 0; j < P + Q; j++) {
				st = new StringTokenizer(br.readLine());
				char cmd = st.nextToken().charAt(0);

				//상자에 구슬 넣기
				if (cmd == 'P') {
					int idx = Integer.parseInt(st.nextToken());
					int value = Integer.parseInt(st.nextToken());

					update(1, 1, B, idx, value);
				}
				//상자에 있는 구슬 수 출력
				else {
					int qleft = Integer.parseInt(st.nextToken());
					int qright = Integer.parseInt(st.nextToken());

					sb.append(query(1, 1, B, qleft, qright) + "\n");
				}
			}
		}
		System.out.println(sb);
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
		update(node * 2, left, mid, idx, value);
		update(node * 2 + 1, mid + 1, right, idx, value);

		tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}

	static int query(int node, int left, int right, int qleft, int qright) {
		//탐색 범위가 쿼리 범위랑 상관이 없는 경우
		if (qright < left || qleft > right) {
			return 0;
		}

		if (qleft <= left && qright >= right) {
			return tree[node];
		}

		int mid = (left + right) / 2;
		int leftResult = query(node * 2, left, mid, qleft, qright);
		int rightResult = query(node * 2 + 1, mid + 1, right, qleft, qright);

		return leftResult + rightResult;
	}
}
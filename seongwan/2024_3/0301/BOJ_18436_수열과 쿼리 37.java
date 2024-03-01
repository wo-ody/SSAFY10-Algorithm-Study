import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//세그먼트 트리를 사용한다.
//짝수의 개수만 저장 후 홀수의 개수는 범위의 개수에서 짝수를 빼는 식으로 구한다.
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
			int num = Integer.parseInt(st.nextToken());
			//짝수인 경우
			if (num % 2 == 0)
				num = 1;
				//홀수인 경우
			else
				num = 0;
			input[i] = num;
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

				//바꿀 값이 짝수인 경우
				if (value % 2 == 0)
					value = 1;
					//홀수인 경우
				else
					value = 0;

				update(1, 1, N, idx, value);
			}
			//query
			else {
				int qleft = Integer.parseInt(st.nextToken());
				int qright = Integer.parseInt(st.nextToken());

				int result = query(1, 1, N, qleft, qright);

				//짝수의 개수
				if (cmd == 2)
					sb.append(result + "\n");
					//홀수의 개수
				else
					sb.append((qright - qleft + 1) - result + "\n");
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
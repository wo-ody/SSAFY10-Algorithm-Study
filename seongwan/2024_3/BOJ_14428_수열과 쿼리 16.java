import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//세그먼트 트리를 이용해 구현
//노드에 값과 인덱스를 같이 주고 값이 같다면 인덱스가 적은 걸
//노드에 기록하는 식으로 진행
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] input;
	static int[][] tree;

	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		input = new int[N + 1];
		tree = new int[4 * N][2];

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

				sb.append(query(1, 1, N, qleft, qright)[1] + "\n");
			}
		}
		System.out.println(sb);
	}

	static void init(int node, int left, int right) {
		if (left == right) {
			tree[node] = new int[] {input[left], left};
			return;
		}

		int mid = (left + right) / 2;
		init(node * 2, left, mid);
		init(node * 2 + 1, mid + 1, right);

		//값이 더 작은 경우
		if (tree[node * 2][0] < tree[node * 2 + 1][0])
			tree[node] = tree[node * 2];
		else if (tree[node * 2][0] > tree[node * 2 + 1][0])
			tree[node] = tree[node * 2 + 1];
			//값이 같은 경우
		else {
			if (tree[node * 2][1] < tree[node * 2 + 1][1])
				tree[node] = tree[node * 2];
			else if (tree[node * 2][1] > tree[node * 2 + 1][1])
				tree[node] = tree[node * 2 + 1];
		}
	}

	static void update(int node, int left, int right, int idx, int value) {
		if (left > idx || right < idx) {
			return;
		}

		if (left == right) {
			tree[node] = new int[] {value, left};
			return;
		}

		int mid = (left + right) / 2;
		update(node * 2, left, mid, idx, value);
		update(node * 2 + 1, mid + 1, right, idx, value);

		//값이 더 작은 경우
		if (tree[node * 2][0] < tree[node * 2 + 1][0])
			tree[node] = tree[node * 2];
		else if (tree[node * 2][0] > tree[node * 2 + 1][0])
			tree[node] = tree[node * 2 + 1];
			//값이 같은 경우
		else {
			if (tree[node * 2][1] < tree[node * 2 + 1][1])
				tree[node] = tree[node * 2];
			else if (tree[node * 2][1] > tree[node * 2 + 1][1])
				tree[node] = tree[node * 2 + 1];
		}
	}

	static int[] query(int node, int left, int right, int qleft, int qright) {
		//탐색 범위가 쿼리 범위랑 상관이 없는 경우
		if (qright < left || qleft > right) {
			return new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE};
		}

		if (qleft <= left && qright >= right) {
			return tree[node];
		}

		int mid = (left + right) / 2;
		int[] leftResult = query(node * 2, left, mid, qleft, qright);
		int[] rightResult = query(node * 2 + 1, mid + 1, right, qleft, qright);

		//값이 더 작은 경우
		if (leftResult[0] < rightResult[0])
			return leftResult;
		else if (leftResult[0] > rightResult[0])
			return rightResult;

		//값이 같은 경우
		if (leftResult[1] < rightResult[1])
			return leftResult;

		return rightResult;
	}
}
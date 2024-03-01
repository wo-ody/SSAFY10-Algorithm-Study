import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//세그먼트 트리를 사용한다.
//각 노드에 구간의 최솟값과 최댓값을 저장 후
//출력할 때 구간의 최댓값과 최솟값의 차이를 보여준다.
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] input;
	static int[][] tree;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		input = new int[N + 1];
		tree = new int[4 * N][2];

		for (int i = 1; i <= N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}

		init(1, 1, N);

		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int qleft = Integer.parseInt(st.nextToken());
			int qright = Integer.parseInt(st.nextToken());

			int[] result = query(1, 1, N, qleft, qright);
			sb.append(result[1] - result[0] + "\n");
		}

		System.out.println(sb);
	}

	static void init(int node, int left, int right) {
		if (left == right) {
			tree[node] = new int[] {input[left], input[left]};
			return;
		}

		int mid = (left + right) / 2;
		init(node * 2, left, mid);
		init(node * 2 + 1, mid + 1, right);

		tree[node][0] = Math.min(tree[node * 2][0], tree[node * 2 + 1][0]);
		tree[node][1] = Math.max(tree[node * 2][1], tree[node * 2 + 1][1]);
	}

	static int[] query(int node, int left, int right, int qleft, int qright) {
		if (qleft > right || qright < left) {
			return new int[] {Integer.MAX_VALUE, 0};
		}

		if (left >= qleft && right <= qright) {
			return tree[node];
		}

		int mid = (left + right) / 2;
		int[] leftResult = query(node * 2, left, mid, qleft, qright);
		int[] rightResult = query(node * 2 + 1, mid + 1, right, qleft, qright);

		int[] result = {Math.min(leftResult[0], rightResult[0]), Math.max(leftResult[1], rightResult[1])};
		return result;
	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//세그먼트 트리 구조를 이용해 풀 수 있음
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] tree;
	static int[] input;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		//0은 더미
		input = new int[N + 1];
		tree = new int[4 * N][2];

		for (int i = 1; i <= N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}

		init(1, 1, N);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int qleft = Integer.parseInt(st.nextToken());
			int qright = Integer.parseInt(st.nextToken());
			int[] result = query(1, 1, N, qleft, qright);
			sb.append(result[0] + " " + result[1] + "\n");
		}

		System.out.println(sb);
	}

	static void init(int node, int left, int right) {
		//리프노드인 상황
		if (left == right) {
			tree[node][0] = input[left];
			tree[node][1] = input[right];
			return;
		}

		int mid = (left + right) / 2;

		init(node * 2, left, mid);
		init(node * 2 + 1, mid + 1, right);

		//두 자식 노드 중 최소,최대값 저장
		tree[node][0] = Math.min(tree[node * 2][0], tree[node * 2 + 1][0]);
		tree[node][1] = Math.max(tree[node * 2][1], tree[node * 2 + 1][1]);
	}

	static int[] query(int node, int left, int right, int qleft, int qright) {
		//쿼리의 범위 밖을 탐색하려는 경우
		if (left > qright || right < qleft) {
			return new int[] {Integer.MAX_VALUE, 0};
		}

		//탐색 범위가 쿼리 범위안에 완전하게 있는 경우
		if (qleft <= left && qright >= right) {
			return tree[node];
		}

		int mid = (left + right) / 2;
		int[] leftResult = query(node * 2, left, mid, qleft, qright);
		int[] rightResult = query(node * 2 + 1, mid + 1, right, qleft, qright);

		return new int[] {Math.min(leftResult[0], rightResult[0]), Math.max(leftResult[1], rightResult[1])};
	}
}
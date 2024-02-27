import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//세그먼트 트리 구조를 이용해 풀 수 있음
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] tree;
	static int[] input;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		//0은 더미
		input = new int[N + 1];
		tree = new int[4 * N];

		for (int i = 1; i <= N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}

		init(1, 1, N);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int qleft = Integer.parseInt(st.nextToken());
			int qright = Integer.parseInt(st.nextToken());
			int result = query(1, 1, N, qleft, qright);
			sb.append(result + "\n");
		}

		System.out.println(sb);
	}

	static void init(int node, int left, int right) {
		//리프노드인 상황
		if (left == right) {
			tree[node] = input[left];
			return;
		}

		int mid = (left + right) / 2;

		init(node * 2, left, mid);
		init(node * 2 + 1, mid + 1, right);

		//두 자식 노드 중 최솟값 저장
		tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
	}

	static int query(int node, int left, int right, int qleft, int qright) {
		//쿼리의 범위 밖을 탐색하려는 경우
		if (left > qright || right < qleft) {
			return Integer.MAX_VALUE;
		}

		//탐색 범위가 쿼리 범위안에 완전하게 있는 경우
		if (qleft <= left && qright >= right) {
			return tree[node];
		}

		int mid = (left + right) / 2;
		int leftResult = query(node * 2, left, mid, qleft, qright);
		int rightResult = query(node * 2 + 1, mid + 1, right, qleft, qright);

		return Math.min(leftResult, rightResult);
	}
}
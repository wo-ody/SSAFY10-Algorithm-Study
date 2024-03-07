import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//순열의 각 자리에 1로 초기화 후 세그먼트 트리를 이용해 구간의 합을 저장한다.
//오른쪽부터의 구간합이 i보다 큰 수인 A[i]-1이 되는 자리에 큰 수부터 차례대로 넣으면
//원래의 순열이 나옴
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] input;
	static int[] tree;
	static int[] ans;

	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());

		input = new int[N + 1];
		ans = new int[N + 1];
		tree = new int[4 * N];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		init(1, 1, N);

		for (int i = N; i >= 1; i--) {
			int result = query(1, 1, N, input[i] + 1);
			ans[result] = i;
			update(1, 1, N, result);
		}

		for (int i = 1; i <= N; i++) {
			sb.append(ans[i]).append(" ");
		}
		System.out.println(sb);
	}

	static void init(int node, int left, int right) {
		if (left == right) {
			tree[node] = 1;
			return;
		}

		int mid = (left + right) / 2;
		init(node << 1, left, mid);
		init(node << 1 | 1, mid + 1, right);

		tree[node] = tree[node << 1] + tree[node << 1 | 1];
	}

	static void update(int node, int left, int right, int idx) {
		if (left > idx || right < idx) {
			return;
		}

		if (left == right) {
			tree[node] = 0;
			return;
		}

		int mid = (left + right) / 2;
		update(node << 1, left, mid, idx);
		update(node << 1 | 1, mid + 1, right, idx);

		tree[node] = tree[node << 1] + tree[node << 1 | 1];
	}

	static int query(int node, int left, int right, int value) {
		//리프 노드에 도달한 경우 인덱스 출력
		if (left == right) {
			return left;
		}

		int rv = tree[node << 1 | 1];
		int mid = (left + right) / 2;
		int result;

		//오른쪽으로부터의 구간합을 구하기 위해 오른쪽으로 더 탐색을 해야할 때
		if (rv >= value) {
			result = query(node << 1 | 1, mid + 1, right, value);
		}
		//오른쪽의 값보다 초과한 값의 인덱스를 구해야 하므로 오른쪽 값을 제외한 값을 왼쪽에서 탐색
		else {
			result = query(node << 1, left, mid, value - rv);
		}
		return result;
	}
}
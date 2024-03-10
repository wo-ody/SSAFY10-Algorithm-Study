import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//세그먼트 트리를 이용해 가장 작은 값의 인덱스와 구간합을 저장한 뒤 해당 값을 기준으로 구간의 합과 최소값의 곱을 저장 후
//해당 인덱스를 기준으로 좌,우의 곱을 계속 구하는 식으로 계속 이어나가며
//곱의 최대를 기록하면 됨
//곱은 long형
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] tree;
	static long[] sumtree;
	static int[] input;
	static int N;
	static long ans;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());

		input = new int[N + 1];
		tree = new int[4 * N];
		sumtree = new long[4 * N];
		input[0] = Integer.MAX_VALUE;

		//점수 정보 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		init(1, 1, N);
		find(1, N);

		System.out.println(ans);
	}

	static void init(int node, int left, int right) {
		if (left == right) {
			tree[node] = left;
			sumtree[node] = input[left];
			return;
		}

		int mid = (left + right) / 2;
		init(node << 1, left, mid);
		init(node << 1 | 1, mid + 1, right);

		tree[node] = input[tree[node << 1]] < input[tree[node << 1 | 1]] ? tree[node << 1] : tree[node << 1 | 1];
		sumtree[node] = sumtree[node << 1] + sumtree[node << 1 | 1];
	}

	static int query(int node, int left, int right, int qleft, int qright) {
		if (left > qright || right < qleft) {
			return 0;
		}

		if (qleft <= left && right <= qright) {
			return tree[node];
		}

		int mid = (left + right) / 2;
		int lr = query(node << 1, left, mid, qleft, qright);
		int rr = query(node << 1 | 1, mid + 1, right, qleft, qright);

		return input[lr] < input[rr] ? lr : rr;
	}

	static long squery(int node, int left, int right, int qleft, int qright) {
		if (left > qright || right < qleft) {
			return 0;
		}

		if (qleft <= left && right <= qright) {
			return sumtree[node];
		}

		int mid = (left + right) / 2;
		long lr = squery(node << 1, left, mid, qleft, qright);
		long rr = squery(node << 1 | 1, mid + 1, right, qleft, qright);

		return lr + rr;
	}

	static void find(int qleft, int qright) {
		if (qleft > qright) {
			return;
		}

		int idx = query(1, 1, N, qleft, qright);
		long sum = squery(1, 1, N, qleft, qright);
		long score = sum * input[idx];

		ans = Math.max(ans, score);

		find(qleft, idx - 1);
		find(idx + 1, qright);
	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//세그먼트 트리로 풀면 됨
//합은 long형으로 처리해야 함
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static long[] tree;

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		tree = new long[4 * N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			//sum 함수
			if (cmd == 0) {
				int num1 = Integer.parseInt(st.nextToken());
				int num2 = Integer.parseInt(st.nextToken());
				int qleft = Math.min(num1, num2);
				int qright = Math.max(num1, num2);
				sb.append(sum(1, 1, N, qleft, qright) + "\n");
			}//modify함수
			else {
				int idx = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());
				modify(1, 1, N, idx, value);
			}
		}
		System.out.println(sb);
	}

	static long sum(int node, int left, int right, int qleft, int qright) {
		//상관없는 범위의 경우
		if (qleft > right || qright < left) {
			return 0;
		}

		//탐색 범위가 쿼리 범위에 속하는 경우
		if (qleft <= left && qright >= right) {
			return tree[node];
		}

		int mid = (left + right) / 2;
		long leftResult = sum(node * 2, left, mid, qleft, qright);
		long rightResult = sum(node * 2 + 1, mid + 1, right, qleft, qright);

		return leftResult + rightResult;
	}

	static void modify(int node, int left, int right, int idx, int value) {
		//상관없는 범위의 경우
		if (idx < left || idx > right) {
			return;
		}

		//바꿔야 하는 인덱스를 만난 경우
		if (left == right) {
			tree[node] = value;
			return;
		}

		int mid = (left + right) / 2;
		modify(node * 2, left, mid, idx, value);
		modify(node * 2 + 1, mid + 1, right, idx, value);

		tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}
}
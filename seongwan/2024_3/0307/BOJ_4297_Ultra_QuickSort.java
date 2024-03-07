import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//세그먼트 트리를 이용해서 교차점의 개수를 구하면됨
//ans는 long형 사용
public class Main {
	static class State implements Comparable<State> {
		public int index, val;

		public State(int a, int b) {
			index = a;
			val = b;
		}

		@Override
		public int compareTo(State that) {
			return this.val - that.val;
		}

	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] tree;
	static State[] state;

	public static void main(String[] args) throws Exception {
		while (true) {
			int N = Integer.parseInt(br.readLine());

			//종료 조건
			if (N == 0)
				break;

			tree = new int[4 * N];
			long ans = 0;
			state = new State[N];

			for (int i = 1; i <= N; i++) {
				state[i - 1] = new State(i, Integer.parseInt(br.readLine()));
			}

			Arrays.sort(state);

			for (State s : state) {
				ans += query(1, 1, N, s.index + 1);

				update(1, 1, N, s.index);
			}
			sb.append(ans + "\n");
		}
		System.out.println(sb);
	}

	static void update(int node, int left, int right, int idx) {
		//범위와 상관 없는 경우
		if (idx < left || idx > right) {
			return;
		}
		if (left == right) {
			tree[node] = 1;
			return;
		}

		int mid = (left + right) / 2;
		update(node << 1, left, mid, idx);
		update(node << 1 | 1, mid + 1, right, idx);

		tree[node] = tree[node << 1] + tree[node << 1 | 1];
	}

	static int query(int node, int left, int right, int qleft) {
		//범위와 상관 없는 경우
		if (qleft > right) {
			return 0;
		}
		//완전히 범위에 속하는 경우
		if (qleft <= left) {
			return tree[node];
		}

		int mid = (left + right) / 2;
		int lR = query(node << 1, left, mid, qleft);
		int RR = query(node << 1 | 1, mid + 1, right, qleft);

		return lR + RR;
	}
}
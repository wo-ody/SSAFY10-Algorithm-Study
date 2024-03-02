import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//세그먼트 트리를 이용하여 각 노드에 구간 별 가장 큰 값과 가장 작은 값을 저장한다.
//양 끝에 있는 소들은 한 쪽이 0이라 이미 불균형
//양 끝 소를 제외하고 각 소의 왼쪽 구간, 오른쪽 구간에 대해 더 큰 소의 수를 세야 한다.
//세그먼트 트리를 탐색하면서 범위에 대해 먼저 조사한 후
//범위가 유효하다면 큰 값보다 더 크다면 더 큰 소가 없다고 판단 0으로 처리
//가장 작은 값보다 작다면 그 구간은 다 더 큰 소라고 판단 후 범위에 있는 소의 수를 카운트
//중간이라면 다시 구간을 더 쪼개서 탐색
//Li와 Ri를 이렇게 찾은 후 더 적은 값의 2배보다 Ri가 크다면 불균형 판단.
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] tree;
	static State[] state;

	public static void main(String[] args) throws Exception {
		int ans = 2;
		int N = Integer.parseInt(br.readLine());

		tree = new int[4 * N];

		state = new State[N];
		for (int i = 1; i <= N; i++) {
			state[i - 1] = new State(i, Integer.parseInt(br.readLine()));
		}

		Arrays.sort(state);

		for (int i = 0; i < N; i++) {
			State s = state[i];

			//양 끝은 무조건 불균형
			if (s.index != 1 && s.index != N) {
				int Li = query(1, 1, N, s.index - 1);
				int Ri = i - Li;

				if ((Li << 1) < Ri || (Ri << 1) < Li) {
					ans++;
				}
			}
			update(1, 1, N, s.index);
		}
		System.out.println(ans);
	}

	static void update(int node, int left, int right, int idx) {
		if (left > idx || right < idx) {
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

	static int query(int node, int left, int right, int qright) {
		//탐색 범위가 쿼리 범위랑 상관이 없는 경우
		if (qright < left) {
			return 0;
		}

		if (qright >= right) {
			return tree[node];
		}

		int mid = (left + right) / 2;
		int leftResult = query(node << 1, left, mid, qright);
		int rightResult = query(node << 1 | 1, mid + 1, right, qright);

		return leftResult + rightResult;
	}

	static class State implements Comparable<State> {
		public int index, val;

		public State(int a, int b) {
			index = a;
			val = b;
		}

		public int compareTo(State that) {
			return that.val - this.val;
		}
	}
}
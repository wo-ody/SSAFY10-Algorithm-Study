import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//세그먼트 트리를 이용하여 구간의 합을 구한다.
//소들의 정보를 인덱스와 함께 값을 입력 받은 뒤 값을 기준으로 내림차순으로 정렬한다.
//양 끝에 있는 소들은 한 쪽이 0이라 이미 불균형
//양 끝 소를 제외하고 각 소의 왼쪽 구간, 오른쪽 구간에 대해 더 큰 소의 수를 세야 한다.
//정렬된 배열을 통해 각 인덱스까지의 구간 합을 구한 뒤 Li로 이용 Ri는 정렬된 배열의 인덱스(해당 소 보다 큰 소들의 수)에서 Li를 뺀다.
//Li와 Ri를 이렇게 찾은 후 더 적은 값의 2배보다 Ri가 크다면 불균형 판단.
//구간 합을 통해 Li를 구한 뒤 update를 통해 해당 소의 인덱스에 1값을 넣는다.(해당 소보다 더 큰 소들의 정보만 계속해서 트리에 남아있으므로
//구간 합을 구하면 해당 인덱스보다 더 작은 인덱스에 있는 큰 소의 수를 알 수 있다.
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
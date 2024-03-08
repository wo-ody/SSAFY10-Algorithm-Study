import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//세그먼트 트리를 이용하여 작은 값부터 큰 값까지 돌면서
//해당되는 각 정점들의 인덱스 이후의 구간 합을 구하고 해당 인덱스에 1을 update 하는 식으로 진행
//연결된 정점의 인덱스 다음으로 있는 값이 있다면 그 개수만큼 교차개수 형성
//ans는 long형 사용
//같은 값에 대한 처리도 해줘야 함

public class Main {
	static class State implements Comparable<State> {
		public int index, val;

		public State(int a, int b) {
			index = a;
			val = b;
		}

		//값이 같다면 인덱스가 앞인 걸 먼저 처리해서 같은 값에 대한 swap이 안 일어나게 처리
		@Override
		public int compareTo(State o) {
			return this.val == o.val ? this.index - o.index : this.val - o.val;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] tree;
	static State[] state;

	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		long ans = 0;
		tree = new int[4 * N];
		state = new State[N];

		st = new StringTokenizer(br.readLine());
		//순서대로 돌면서 해당 값의 인덱스를 저장
		for (int i = 0; i < N; i++) {
			state[i] = new State(i + 1, Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(state);

		for (State temp : state) {
			ans += query(1, 1, N, temp.index + 1);
			update(1, 1, N, temp.index);
		}

		System.out.println(ans);
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
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//세그먼트 트리를 이용하여 1부터 N까지 돌면서
//해당되는 각 정점들의 인덱스 이후의 구간 합을 구하고 해당 인덱스에 1을 update 하는 식으로 진행
//연결된 정점의 인덱스 다음으로 있는 값이 있다면 그 개수만큼 교차개수 형성
//첫번째 인덱스는 교차할 간선이 없으므로 update만 진행
//ans는 long형 사용

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] tree;
	static int[] idx;

	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		long ans = 0;
		tree = new int[4 * N];
		idx = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		//순서대로 돌면서 해당 값의 인덱스를 저장
		for (int i = 1; i <= N; i++) {
			idx[Integer.parseInt(st.nextToken())] = i;
		}

		for (int i = 1; i <= N; i++) {
			//첫 번째에는 교차점을 구할 수 없음
			if (i != 1) {
				ans += query(1, 1, N, idx[i] + 1);
			}
			update(1, 1, N, idx[i]);
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
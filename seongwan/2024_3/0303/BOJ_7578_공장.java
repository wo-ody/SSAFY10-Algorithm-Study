import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

//세그먼트 트리를 이용하여 A열을 기준으로 차례대로 B열 짝의 인덱스 이후의 구간 합을 구한다.
//각 노드에는 구간 합을 탐색했던 B열의 인덱스에 1을 넣고 구간합을 저장하는 식으로 구현한다.
//A열은 차례대로 진행되므로 다음 A열의 짝의 인덱스가 앞에 나온 수보다 작은 값이면
//그만큼 케이블의 교차점이 늘어나는 식이므로 이렇게 구한 값의 인덱스에 1을 넣고
//구간합을 구하면 해결 가능
//long형 사용
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	//A열의 순서를 유지하면서 번호에 따른 B열의 인덱스 저장
	static LinkedHashMap<Integer, Integer> factory = new LinkedHashMap<>();
	static long[] tree;

	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		long ans = 0;
		tree = new long[4 * N];

		//A열 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			factory.put(Integer.parseInt(st.nextToken()), 0);
		}

		//B열 입력(인덱스는 1부터 입력)
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			factory.put(Integer.parseInt(st.nextToken()), i + 1);
		}

		for (Integer i : factory.keySet()) {
			int idx = factory.get(i);
			//B열의 마지막 인덱스인 경우 체크 필요X
			if (idx != N) {
				ans += query(1, 1, N, idx + 1);
			}
			update(1, 1, N, idx);
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

	static long query(int node, int left, int right, int qleft) {
		//범위와 상관 없는 경우
		if (qleft > right) {
			return 0;
		}
		//완전히 범위에 속하는 경우
		if (qleft <= left) {
			return tree[node];
		}

		int mid = (left + right) / 2;
		long lR = query(node << 1, left, mid, qleft);
		long RR = query(node << 1 | 1, mid + 1, right, qleft);

		return lR + RR;
	}
}
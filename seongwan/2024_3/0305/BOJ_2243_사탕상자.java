import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//세그먼트 트리를 이용해 구간의 합을 저장 후
//왼쪽에서부터의 구간 합이 해당 값이 속할 때 해당 인덱스를 출력
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] input = new int[1_000_001];
	static int[] tree = new int[4_000_000];

	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			//update
			if (cmd == 2) {
				int idx = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());
				update(1, 1, 1000000, idx, value);
			}
			//query
			else {
				int value = Integer.parseInt(st.nextToken());
				int result = query(1, 1, 1000000, value);
				sb.append(result + "\n");
				//해당 순위 사탕의 맛을 출력 후 그 맛의 사탕을 -1처리
				update(1, 1, 1000000, result, -1);
			}
		}
		System.out.println(sb);
	}

	static void init(int node, int left, int right) {
		if (left == right) {
			tree[node] = input[left];
			return;
		}

		int mid = (left + right) / 2;
		init(node << 1, left, mid);
		init(node << 1 | 1, mid + 1, right);

		tree[node] = tree[node << 1] + tree[node << 1 | 1];
	}

	static void update(int node, int left, int right, int idx, int value) {
		if (left > idx || right < idx) {
			return;
		}

		if (left == right) {
			tree[node] += value;
			return;
		}

		int mid = (left + right) / 2;
		update(node << 1, left, mid, idx, value);
		update(node << 1 | 1, mid + 1, right, idx, value);

		tree[node] = tree[node << 1] + tree[node << 1 | 1];
	}

	static int query(int node, int left, int right, long value) {
		//리프 노드에 도달한 경우 인덱스 출력
		if (left == right) {
			return left;
		}

		int lv = tree[node << 1];
		int mid = (left + right) / 2;
		int result;

		//왼쪽으로부터의 구간합을 구하기 위해 왼쪽으로 더 탐색을 해야 할 때
		if (lv >= value) {
			result = query(node << 1, left, mid, value);
		}//왼쪽의 값보다 초과한 값의 인덱스를 구해야하므로 왼쪽 값을 제외한 값을 오른쪽에서 탐색
		else {
			result = query(node << 1 | 1, mid + 1, right, value - lv);
		}

		return result;
	}
}
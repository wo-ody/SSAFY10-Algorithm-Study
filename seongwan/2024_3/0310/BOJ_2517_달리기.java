import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;

//입력을 배열에 받은 뒤 LinkedMap에 순서대로 담는다 (순서 유지)
//그 다음 배열을 실력의 오름차순으로 정렬 후 각 수들을 키로 하고 순위를 LinkedMap에 값으로 저장한다.
//키셋을 돌면서 해당 순위 뒤 범위의 구간합을 구하고 리프 노드에 1을 저장하는 식으로 반복하면서
//해당 수의 실력보다 더 좋은 사람이 앞에 몇 명이 있는지 알아내면 해결 가능하다.
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int[] input;
	static int[] tree;
	static LinkedHashMap<Integer, Integer> rank = new LinkedHashMap<>();

	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());

		input = new int[N + 1];
		tree = new int[4 * N];

		//실력값 정보 입력
		for (int i = 1; i <= N; i++) {
			input[i] = Integer.parseInt(br.readLine());
			rank.put(input[i], 0);
		}

		Arrays.sort(input);

		//실력을 오름차순으로 정렬 후 실력 순서를 저장
		for (int i = 1; i <= N; i++) {
			rank.put(input[i], i);
		}

		//현재 달리기 순위대로 앞에 본인보다 실력이 높은 사람이 지나갔는지를 확인하고
		//본 실력 순위의 리프 노드에 본인 정보 저장
		for (Integer i : rank.keySet()) {
			sb.append(query(1, 1, N, rank.get(i) + 1, N) + 1).append("\n");

			update(1, 1, N, rank.get(i));
		}
		System.out.println(sb);
	}

	static void update(int node, int left, int right, int idx) {
		//상관없는 범위를 탐색하는 경우
		if (idx < left || idx > right)
			return;

		if (left == right) {
			tree[node] = 1;
			return;
		}

		int mid = (left + right) >> 1;
		update(node << 1, left, mid, idx);
		update(node << 1 | 1, mid + 1, right, idx);

		tree[node] = tree[node << 1] + tree[node << 1 | 1];
	}

	static int query(int node, int left, int right, int qleft, int qright) {
		//상관없는 범위를 탐색하는 경우
		if (left > qright || right < qleft)
			return 0;

		//완전히 속하는 범위를 탐색하는 경우
		if (left >= qleft && right <= qright)
			return tree[node];

		int mid = (left + right) >> 1;
		int lr = query(node << 1, left, mid, qleft, qright);
		int rr = query(node << 1 | 1, mid + 1, right, qleft, qright);

		return lr + rr;
	}
}
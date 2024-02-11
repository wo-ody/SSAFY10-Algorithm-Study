import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

	private static int N, result;
	private static int[] population;
	private static boolean[] isSelected;
	private static List<Integer>[] map;
	private static List<Integer> A, B;

	private static void comb(int index) {

		if (index == N) {

			A = new ArrayList<>();
			B = new ArrayList<>();

			for (int i = 1; i <= N; i++) {
				if (isSelected[i])
					A.add(i);
				else
					B.add(i);
			}

			if (A.size() == 0 || B.size() == 0)
				return;

			if (link(A) && link(B)) {
				result = Math.min(result, calc());
			}

			return;
		}

		isSelected[index] = true;
		comb(index + 1);
		isSelected[index] = false;
		comb(index + 1);
	}

	private static boolean link(List<Integer> list) {

		Queue<Integer> q = new ArrayDeque<>();
		boolean[] isVisited = new boolean[N + 1];

		isVisited[list.get(0)] = true;
		q.add(list.get(0));

		int count = 1; // 첫번째 도시는 방문 완료

		while (!q.isEmpty()) {

			int p = q.poll();

			for (int j = 0; j < map[p].size(); j++) {

				if (!isVisited[map[p].get(j)] && list.contains(map[p].get(j))) {
					count++;
					q.add(map[p].get(j));
					isVisited[map[p].get(j)] = true;
				}
			}
		}

		if (count == list.size())
			return true;
		else
			return false;

	}

	private static int calc() {
		int pA = 0, pB = 0;

		for (int a : A) {
			pA += population[a];
		}
		for (int b : B) {
			pB += population[b];
		}

		return Math.abs(pA - pB);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());

		population = new int[N + 1];
		map = new ArrayList[N + 1];
		isSelected = new boolean[N + 1];
		result = Integer.MAX_VALUE;

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
			map[i] = new ArrayList<>();
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());

			for (int j = 0; j < n; j++) {
				map[i].add(Integer.parseInt(st.nextToken()));
			}
		} // 입력 종료

		comb(0);

		if (result == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(result);

	}
}

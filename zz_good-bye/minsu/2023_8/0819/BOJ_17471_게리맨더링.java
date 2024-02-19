package bj.G4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * bfs로 풀면 좀 더 시간이 빠를거같음!! 
 */
public class BOJ_17471_게리맨더링 {
	static int n, ans;
	static int[] num; // 각 구역의 인구 수
	static boolean[] selected; // 부분집합을 만들기 위해 사용
	static boolean[] visited; // 나중에 연결되었는지 확인하기 위해 bfs로 할 때 사용
	static List<Integer> groupA; // a 선거구
	static List<Integer> groupB; // b 선거구
	static List<List<Integer>> list = new ArrayList<>(); // 각 구역별 인구 수

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine()); // 지역의 개수
		StringTokenizer st = new StringTokenizer(br.readLine());
		ans = Integer.MAX_VALUE; // 정답으로 쓸 최댓값
		num = new int[n + 1];
		selected = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			for (int j = 0; j < k; j++) {
				list.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}

		subset(0);
		ans = (ans == Integer.MAX_VALUE) ? -1 : ans;
		System.out.println(ans);

	}

	static void subset(int srcIdx) {
		if (srcIdx == n) {
			groupA = new ArrayList<>();
			groupB = new ArrayList<>();

			for (int i = 1; i <= n; i++) {
				if (selected[i]) {
					groupA.add(i);
				} else {
					groupB.add(i);
				}
			}
			// 한 그룹에만 다 몰리면 안되니깐
			if (groupA.size() == 0 || groupB.size() == 0) {
				return;
			}
			if (check(groupA) && check(groupB)) {
				int sumA = 0;
				int sumB = 0;
//				System.out.println("grupA= " +groupA + "groupB= " + groupB);
				// 둘 다 연결되었는지 확인되었다면 인구 수 세어서 ans에 넣어주기 반복
				for (int a : groupA) {
					sumA += num[a];
				}
				for (int b : groupB) {
					sumB += num[b];
				}
//				System.out.println("sumA= " + sumA);
//				System.out.println("sumB= " + sumB);

				ans = Math.min(ans, Math.abs(sumA - sumB));
			}
			return;
		}
		selected[srcIdx] = true;
		subset(srcIdx + 1);
		selected[srcIdx] = false;
		subset(srcIdx + 1);
	}

	static boolean check(List<Integer> group) {
		Queue<Integer> queue = new ArrayDeque<>();
		visited = new boolean[n + 1];
		visited[group.get(0)] = true;
		queue.offer(group.get(0));

		while (!queue.isEmpty()) {
			Integer p = queue.poll();
			for (int i : list.get(p)) {
				if (!visited[i] && group.contains(i)) {
					visited[i] = true;
					queue.offer(i);
				}
			}
		}

		// 전부 다 방문했다면 연결이 되어있다는거고 안된 지점이 있다는건 연결이 안된다는 점!
		for (int g : group) {
			if (!visited[g]) {
				return false;
			}
		}

		return true;
	}

}

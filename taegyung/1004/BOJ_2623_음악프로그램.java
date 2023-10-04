package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2623_음악프로그램 {

	static ArrayList<ArrayList<Integer>> before;

	static int[] beforeCnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 선행 요소를 정해주고 관계를 기록한다?

		beforeCnt = new int[N + 1];
		before = new ArrayList<>();

		for (int i = 0; i <= N; i++) { // 처음은 없음 인덱스 맞춰주기 위함
			before.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int cntSingers = Integer.parseInt(st.nextToken());

			Queue<Integer> queue = new ArrayDeque<>();

			for (int j = 0; j < cntSingers; j++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			} // 이렇게 넣음

			singers(queue);
		}

		// 입력 완료

		// 이제 beforeCnt가 0인 것들을 찾으면서 출력하기 전에 값을 저장하고, 얘네를 선행해야하는
		// 후행 애들에 beforeCnt -1 해준다.

		int[] result = new int[N];

		boolean[] visited = new boolean[N + 1];

		int index = 0;

		for (int i = 0; i < N; i++) { // 결과를 넣을 위치

			int next = -1;

			for (int j = 1; j <= N; j++) { // 0을 찾음
				if (!visited[j] && beforeCnt[j] == 0) {
					next = j;
				}
			}

			// next가 -1 이다 -> 더 이상 진행하지 않는다.
			if (next == -1) {
				System.out.println(0);
				break;
			}

			visited[next] = true;
			result[i] = next;
			// 다음부터 before들을 바꿔줘야함.

			for (int j = 0; j < before.get(next).size(); j++) {
				beforeCnt[before.get(next).get(j)] -= 1;
			}
		}

		if (result[N - 1] != 0) {
			for (int i = 0; i < N; i++) {
				System.out.println(result[i]);
			}
		}
	}

	public static ArrayList<Integer> singers(Queue<Integer> queue) {
		if (queue.isEmpty()) {
			return new ArrayList<>();
		}

		int c = queue.poll();

		ArrayList<Integer> result = singers(queue);

//		beforeCnt[c] += result.size();

		for (int i = 0; i < result.size(); i++) {
			before.get(c).add(result.get(i));

			beforeCnt[result.get(i)] += 1;
		}

		result.add(c);

		return result;

	}
}

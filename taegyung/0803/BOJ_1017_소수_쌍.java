package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1017_소수_쌍 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] nums;
	static int[] matches;
	static boolean[] done;
	static int N;

	static boolean[] primeNums = new boolean[2001];

	static void makePrimes() {
		Arrays.fill(primeNums, true);
		primeNums[0] = false;
		primeNums[1] = false;
		for (int i = 2; i < 2001; i++) {
			if (primeNums[i]) {
				for (int j = i * 2; j < 2001; j += i) {
					primeNums[j] = false;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		makePrimes();

		N = Integer.parseInt(br.readLine());
		nums = new int[N + 1];
		matches = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		done = new boolean[N + 1];

		for (int i = 1; i <= N; i++) { // 1번째부터 넣음
			nums[i] = Integer.parseInt(st.nextToken());
		}
		boolean done_print = false;

		ArrayList<Integer> answer = new ArrayList<>();

		for (int i = 2; i <= N; i++) {
			if (!primeNums[nums[1] + nums[i]])
				continue; // primeNum이 아니면 볼 필요 없음
//			Arrays.fill(nums, 0);
			Arrays.fill(matches, 0);
			matches[i] = 1; // 첫번째 수를 넣어준다.
			matches[1] = i;
			boolean flag = true;
			for (int j = 1; j <= N; j++) { // 이제 돌아보자
				Arrays.fill(done, false);
				done[i] = true;
				done[1] = true;

				// 각 노드가 소수로 짝지을 수 있으면
				if (matches[j] != 0) // 연결된 놈이 있으면 안봄
					continue;
				if (!dfs(j)) // 자연스레 1과 연결된 놈은 안봄
					flag = false;
//					System.out.print(nums[i] + " ");

				if (!flag)
					break;
			}
			if (flag) {
				answer.add(nums[i]);
//				System.out.print(nums[i] + " ");
//				done_print = true;
			}
		}
		answer.sort((o1, o2) -> o1 - o2);
		if (answer.size() == 0) {
			System.out.println(-1);
		} else {
			for (int i = 0; i < answer.size(); i++) {
				System.out.print(answer.get(i) + " ");
			}
		}
	}

	static boolean dfs(int node) { // 양쪽에다 넣어줘야한다.

		// 근데 현재 돌고있는 node에 대해서 확인해줘야할 필요가 있을까?
		// 필요가 있다면 어떻게 처리할까?
//		if  처리했음
		for (int i = 2; i <= N; i++) { // 여기 들어온건 아직 처리 안된놈임
			if (!primeNums[nums[i] + nums[node]])
				continue;
			if (done[i] || i == node)
				continue;
			done[i] = true;
			if ((matches[i] == 0 || matches[i] != 1 && dfs(matches[i]))) {
				matches[i] = node;
				matches[node] = i;
				done[node] = true;
				return true;
			}
		}
		return false;
	}
}

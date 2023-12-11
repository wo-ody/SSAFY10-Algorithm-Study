/*
 *	08.02 김창희
 *	BOJ_1516_게임개발
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static List<List<Integer>> grpah = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[] dist = new int[n + 1];

		for (int i = 0; i < n + 1; i++)
			grpah.add(new ArrayList<>());

		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			dist[i] = Integer.parseInt(st.nextToken());

			while (true) {
				int b = Integer.parseInt(st.nextToken());
				if (b == -1)
					break;
				grpah.get(b).add(i);
			}

		}

		int[] e = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			for (int j : grpah.get(i))
				e[j]++;
		}

		Queue<Integer> q = new LinkedList<>();
		int[] result = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			if (e[i] == 0) {
				result[i] = dist[i];
				q.offer(i);
			}
		}

		result[q.peek()] = dist[q.peek()];

		// 각 건물을 짓는 최소값을 계속 갱신하면서 더한다.
		while (!q.isEmpty()) {
			int i = q.poll();
			for (int ni : grpah.get(i)) {
				e[ni]--;
                result[ni] = Math.max(result[ni],result[i]+dist[ni]);
				if (e[ni] == 0) {
					//비용이 작은게 먼저 나올수 있으므로 0일때가 아니라 계속해서 최대값을 갱신해 주어야한다.
//					result[ni] = Math.max(result[ni], result[i] + dist[ni]);
					q.offer(ni);
				}
			}
		}

		StringBuilder answer = new StringBuilder();
		for (int i = 1; i < n + 1; i++)
			answer.append(result[i]).append("\n");
		System.out.println(answer);

	}
}

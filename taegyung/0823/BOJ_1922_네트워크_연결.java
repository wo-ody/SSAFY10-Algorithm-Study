package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1922_네트워크_연결 {
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int M = Integer.parseInt(br.readLine());

		ArrayList<int[]> v = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			v.add(new int[] { a, b, c });
		}

		Collections.sort(v, (o1, o2) -> o1[2] - o2[2]);

		int answer = 0;
		int cnt = 0;
		parent = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			parent[i] = i; // 초기화
		}
		for (int i = 0; i < M; i++) {
			int[] tmp = v.get(i);
			int p1 = find_root(tmp[0]);
			int p2 = find_root(tmp[1]);
			if (p1 == p2)
				continue;
			parent[p1] = p2;
			cnt++;
			answer += tmp[2];

			if (cnt == N - 1)
				break;
		}

		System.out.println(answer);
	}

	static int find_root(int node) {
		if (node == parent[node])
			return node;

		return parent[node] = find_root(parent[node]);
	}
}

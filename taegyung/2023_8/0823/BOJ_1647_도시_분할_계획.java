package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1647_도시_분할_계획 {
	// 문제를 잘 읽자
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			parent[i] = i; // 초기화

		}

		ArrayList<int[]> v = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			v.add(new int[] { A, B, C });

		}

		Collections.sort(v, (o1, o2) -> o1[2] - o2[2]);

		long sum = 0;
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			if (cnt == N - 2) // 두개로 분할할거라
				break;
			int[] tmp = v.get(i);

			int p1 = find_root(tmp[0]);
			int p2 = find_root(tmp[1]);

			if (p1 == p2) // 이미 연결돼있음
				continue;

			parent[p1] = p2; // 연결
			sum += tmp[2]; // 유지비만큼 더함
			cnt++;

		}
		System.out.println(sum);
	}

	static int find_root(int node) {
		if (node == parent[node])
			return node;

		return parent[node] = find_root(parent[node]);
	}
}

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20040_사이클_게임 {
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		parent = new int[n];

		for (int i = 0; i < n; i++)
			parent[i] = i;

		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			int p1 = find_root(node1);
			int p2 = find_root(node2);

			if (p1 == p2) {
				System.out.println(i);
				return;
			}
			parent[p1] = p2;

		}
		System.out.println(0);
	}

	static int find_root(int node) {
		if (parent[node] == node)
			return node;

		return parent[node] = find_root(parent[node]);
	}
}

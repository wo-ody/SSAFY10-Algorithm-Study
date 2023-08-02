package algorithm2023.aug.day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G4_BOJ1044_UNION_FIND {

	static int N, M, party[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		party = new int[M + 1][];
		int cnt = M;
		DSU dsu = new DSU(N + 1);
		st = new StringTokenizer(br.readLine(), " ");
		int know = Integer.parseInt(st.nextToken());
		int[] knowP = new int[know];
		for (int i = 0; i < know; i++) {
			knowP[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int size = Integer.parseInt(st.nextToken());
			party[i] = new int[size];
			party[i][0] = Integer.parseInt(st.nextToken());
			for (int j = 0; j < size - 1; j++) {
				party[i][j + 1] = Integer.parseInt(st.nextToken());
				dsu.union(party[i][j], party[i][j + 1]);
			}
			
		}
		for (int i = 1;i<=M;i++) {
			int n = party[i][0];
			for (int k : knowP) {
				if (dsu.find(n) == dsu.find(k)) {
					cnt--;
					break;
				}
			}
		}
		System.out.println(cnt);
	}

	static class DSU {
		int[] parent;

		DSU(int size) {
			parent = new int[size];
			for (int i = 0; i < size; i++) {
				parent[i] = i;
			}
		}

		int find(int n) {
			if (parent[n] == n) {
				return n;
			}
			return find(parent[n]);
		}

		void union(int n, int m) {
			n = find(n);
			m = find(m);
			if (n == m)
				return;
			parent[n] = m;
		}
	}
}

package bj.G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_27945_슬슬가지를먹지않으면죽는다 {
	static int N, M;
	static ArrayList<Info> edge = new ArrayList<>();
	static int[] parent;
	static int D = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			edge.add(new Info(u, v, t));
		}

		Collections.sort(edge, (a, b) -> a.t - b.t);

		for (Info e : edge) {
			if (e.t != D)
				break;
			if (findParent(e.u) != findParent(e.v)) {
				unionGroup(e.u, e.v);
				D++;
			}
		}

		System.out.println(D);
	}
	
	static int findParent(int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = findParent(parent[x]);
	}

	static void unionGroup(int x, int y) {
		int px = findParent(x);
		int py = findParent(y);

		if (px < py) {
			parent[py] = px;
		} else {
			parent[px] = py;
		}
	}
	
	static class Info {
		int u, v, t;

		Info(int u, int v, int t) {
			this.u = u;
			this.v = v;
			this.t = t;
		}
	}
}



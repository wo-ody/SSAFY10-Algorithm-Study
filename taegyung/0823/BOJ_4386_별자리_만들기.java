package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_4386_별자리_만들기 {
	static class Star {
		double x, y;
		double[] distances;

		Star(double x2, double y2) {
			this.x = x2;
			this.y = y2;
		}
	}

	static int[] parent;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		double sum = 0;
//		ArrayList<int[]> stars = new ArrayList<>();

		Star[] stars = new Star[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			stars[i] = new Star(x, y);

		}
		parent = new int[n];

		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}

		ArrayList<double[]> star_distances = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			stars[i].distances = new double[n];

			for (int j = 0; j < n; j++) {
//				stars[i].distances[j] = Math.pow(Math.pow(stars[i].x-stars[j].x,2)+Math.pow(stars[i].y-stars[j].y,2),0.5);
				// 간선의 정보를 저장하면 됨
				if (i != j) {
					star_distances.add(new double[] { i, j, Math
							.pow(Math.pow(stars[i].x - stars[j].x, 2) + Math.pow(stars[i].y - stars[j].y, 2), 0.5) });
				}

			}

		}

		Collections.sort(star_distances, (o1, o2) -> o1[2] > o2[2] ? 1 : -1);

		for (int i = 0; i < star_distances.size(); i++) {
			double[] tmp = star_distances.get(i);

			int s1 = (int) tmp[0];
			int s2 = (int) tmp[1];

			int p1 = find_root(s1);
			int p2 = find_root(s2);

			if (p1 == p2)
				continue;

			sum += tmp[2];
			parent[p1] = p2;

		}
		System.out.printf("%.2f", sum);
	}

	static int find_root(int node) {
		if (node == parent[node])
			return node;

		return parent[node] = find_root(parent[node]);
	}
}

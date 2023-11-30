package bj.S1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1446_지름길 {
	static int N, D;
	static int[] dist;
	static List<Node> map = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		dist = new int[10001]; // 최단거리를 저장할 공ㄱ간
		Arrays.fill(dist, 10001); // 최대로 채워두고

		N = Integer.parseInt(st.nextToken()); // 5
		D = Integer.parseInt(st.nextToken()); // 150

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			// 역주행하는 경우
			if (e > D) {
				continue;
			}
			// 지름길이 아닌경우
			if (e - s <= v) {
				continue;
			}
			map.add(new Node(s, e, v));
		}

		Collections.sort(map, (o1, o2) -> {
			if (o1.start == o2.start)
				return o1.end - o2.end;
			return o1.start - o2.start;
		});
		
		dist[0] = 0; // 시작점은 0부터
		int idx = 0, move = 0;
		
		while (move < D) {
			if (idx < map.size()) {
				Node cur = map.get(idx);
				if (move == cur.start) {
					dist[cur.end] = Math.min(dist[cur.end], dist[move] + cur.value);
					idx++;
				} else {
					dist[move + 1] = Math.min(dist[move + 1], dist[move] + 1);
					move++;
				}
			} else {
				dist[move + 1] = Math.min(dist[move + 1], dist[move] + 1);
				move++;
			}
		}
		System.out.println(dist[D]);
	}

	static class Node {
		int start, end, value;

		public Node(int start, int end, int value) {
			super();
			this.start = start;
			this.end = end;
			this.value = value;
		}

	}
}




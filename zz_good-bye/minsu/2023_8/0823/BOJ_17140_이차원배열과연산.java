package bj.G4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_17140_이차원배열과연산 {
	static int r, c, k, row_length, col_length;
	static int cnt;
	static int ans;
	static int[][] map = new int[101][101];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		row_length = 3;
		col_length = 3;
		int cnt = 0;
		int ans = -1; // 100초가 지나도 안되면 ans는 -1로 출력

		while (cnt <= 100) {
			if (map[r][c] == k) {
				ans = cnt;
				break;
			}

			if (row_length >= col_length) {
				r();
			} else {
				c();
			}
			cnt++;

		}

		System.out.println(ans);

	}

	static void r() {
		int[][] map_copy = new int[101][101];
		int col = 0;

		for (int i = 1; i <= row_length; i++) {
			HashMap<Integer, Integer> hashMap = new HashMap<>();
			// 각 행에 대해 숫자가 몇번 나왔는지 확인해서 hash에 넣어주고
			for (int j = 1; j <= col_length; j++) {
				// 0인 좌표는 그냥 패스하고
				if (map[i][j] == 0) {
					continue;
				}
				// 이미 해당 값이 hash안에 있다면 value +1만 시켜주면 됨
				if (hashMap.containsKey(map[i][j])) {
					hashMap.put(map[i][j], hashMap.get(map[i][j]) + 1);
				} else {
					hashMap.put(map[i][j], 1);
				}
			}
			ArrayList<Node> list = new ArrayList<>();
			for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
//				System.out.println("key= " + entry.getKey());
//				System.out.println("value= " + entry.getValue());
				list.add(new Node(entry.getKey(), entry.getValue()));
			}
			// 최대 길이는 list의 길이 * 2배이기 때문에!
			col = Math.max(col, list.size() * 2);
			Collections.sort(list);

			for (int k = 0; k < list.size(); k++) {
				Node node = list.get(k);
//				System.out.println("node.x" + node.num);
//				System.out.println("node.y" + node.cnt);
				map_copy[i][2 * k + 1] = node.num;
				map_copy[i][2 * k + 2] = node.cnt;
			}
//			System.out.println("===");
		}
		col_length = col;
		map = map_copy;
	}

	static void c() {
		// 새로운 map을 계속 생성해서 열 1개씩 새롭게 만들어주고 최종적으로 그걸 map에 덮어씌우는 식으로!
		int[][] map_copy = new int[101][101];
		int row = 0;

		for (int j = 1; j <= col_length; j++) {
			HashMap<Integer, Integer> hash = new HashMap<>();
			for (int i = 1; i <= row_length; i++) {
				if (map[i][j] == 0)
					continue;
				if (hash.containsKey(map[i][j])) {
					hash.put(map[i][j], hash.get(map[i][j]) + 1);
				} else {
					hash.put(map[i][j], 1);
				}
			}
			ArrayList<Node> list = new ArrayList<>();

			for (Map.Entry<Integer, Integer> entry : hash.entrySet()) {
				list.add(new Node(entry.getKey(), entry.getValue()));
			}

			row = Math.max(row, list.size() * 2);
			Collections.sort(list);

			for (int p = 0; p < list.size(); p++) {
				Node node = list.get(p);
				map_copy[2 * p + 1][j] = node.num;
				map_copy[2 * p + 2][j] = node.cnt;
			}
		}

		row_length = row;
		map = map_copy;
	}

	static class Node implements Comparable<Node> {
		int num;
		int cnt;

		public Node(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Node o) {
			if (this.cnt == o.cnt) {
				return this.num - o.num;
			}
			return this.cnt - o.cnt;
		}

	}
}

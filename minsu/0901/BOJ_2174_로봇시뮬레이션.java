package bj.G5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2174_로봇시뮬레이션 {
	static int A, B, N, M;
	static List<int[]> robot = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken()); // 행의 크기
		B = Integer.parseInt(st.nextToken()); // 열의 크기
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 로봇의 정보
		M = Integer.parseInt(st.nextToken()); // 명령의 정보

		robot.add(new int[] { 0, 0, 0 }); // dummy로 하나 넣어두고

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			String s = st.nextToken();
			int d = 0;
			if (s.equals("N")) {
				d = 0;
			} else if (s.equals("E")) {
				d = 1;
			} else if (s.equals("S")) {
				d = 2;
			} else if (s.equals("W")) {
				d = 3;
			}

			// 이거 위에 이렇게 d 잡고 s에 따라서 d값 바꿔줄려하는데 왜 계속 0이 출력되는거야?
			// 문자열 비교 -> .equals
//			System.out.println(d);

			robot.add(new int[] { a, b, d });

		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()); // 명령을 내릴 로봇의 번호
			String order = st.nextToken(); // 내릴 명령 종류
			int t = Integer.parseInt(st.nextToken()); // 명령 반복 횟수

			for (int j = 0; j < t; j++) {
				if (!sol(r, order)) {
					System.out.println(sb);
					return;
				} // t번만큼 명령 반복하는 도중에 문제가 생기면 그 다음 명령은 수행안하고 그냥 출력만
			}

		}
		sb = new StringBuilder();
		sb.append("OK");
		System.out.println(sb);

	}

	static boolean sol(int r, String o) {
		int[] cur = robot.get(r);

		switch (o) {
		case "L":
			cur[2] = (cur[2] + 3) % 4;
			break;
		case "R":
			cur[2] = (cur[2] + 1) % 4;
			break;
		case "F":
			int nx = 0;
			int ny = 0;
			if (cur[2] == 0) {
				nx = cur[0];
				ny = cur[1] + 1;
			} else if (cur[2] == 1) {
				nx = cur[0] + 1;
				ny = cur[1];
			} else if (cur[2] == 2) {
				nx = cur[0];
				ny = cur[1] - 1;
			} else if (cur[2] == 3) {
				nx = cur[0] - 1;
				ny = cur[1];
			}

			if (nx < 1 || nx > A || ny < 1 || ny > B) {
				sb.append("Robot ").append(r).append(" crashes into the wall");
				return false;
			}

			for (int i = 1; i <= N; i++) {
				if (i == r) {
					continue;
				}

				int[] c = robot.get(i);

				if (nx == c[0] && ny == c[1]) {
					sb.append("Robot ").append(r).append(" crashes into robot ").append(i);
					return false;
				}
			}

			cur[0] = nx;
			cur[1] = ny;
			break;
		}

		return true;
	}

	static class Node {
		int x, y, dir;

		public Node(int x, int y, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
		}

	}
}

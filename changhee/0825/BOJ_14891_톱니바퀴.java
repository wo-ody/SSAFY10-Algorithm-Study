/*
 *  08.25 김창희
 *  BOJ_14891_톱니바퀴
 *
 *  [풀이]
 *  1.하나의 바퀴에 대한 머리(12시방향)에 대한 인덱스만 저장하며 회전할때마다 인덱스를 변경한다.
 *  2.맞닿은 있는 부분을 머리로 부터 2와 6떨어진 값으로 한다.
 *  
 *  [주의]
 *  톱니바퀴가 연쇄적으로 움직이는 것이 아니라 독립적으로 움직인다.. 이 자식.. 너때문에..
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n = 5, m = 8;
	static int[] wheelHead = { 0, 0, 0, 0, 0 };
	static int[][] wheels;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		wheels = new int[n][m];
		for (int i = 1; i < n; i++) {
			String temp = br.readLine();
			for (int j = 0; j < m; j++) {
				wheels[i][j] = temp.charAt(j) - 48;
			}
		}

		int k = Integer.parseInt(br.readLine());

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int wheel = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			
			int[][] init = {{},
					{getLeft(1),getRight(1)},
					{getLeft(2),getRight(2)},
					{getLeft(3),getRight(3)},
					{getLeft(4),getRight(4)},
			};
			switch (wheel) {
			case 1:
				if (init[1][1] == init[2][0]) break;
				rotate(2, dir*-1);
				
				if (init[2][1] == init[3][0]) break;
				rotate(3, dir);
				
				if (init[3][1] != init[4][0]) rotate(4, dir*-1);
				break;
			case 2:
				if (init[2][0] != init[1][1]) rotate(1, dir*-1);
				
				if (init[2][1] == init[3][0]) break;
				rotate(3, dir*-1);
				
				if (init[3][1] != init[4][0]) rotate(4, dir);
				break;
			case 3:
				if (init[3][1] != init[4][0]) rotate(4, dir*-1);
				
				if (init[3][0] == init[2][1]) break;
				rotate(2, dir*-1);
				
				if (init[2][0] != init[1][1]) rotate(1, dir);
				break;
			case 4:
				if (init[4][0] == init[3][1]) break;
				rotate(3, dir*-1);
				
				if (init[3][0] == init[2][1]) break;
				rotate(2, dir);
				
				if (init[2][0] != init[1][1]) rotate(1, dir*-1);
				break;
			}
			rotate(wheel, dir);
		}

		int answer = wheels[1][wheelHead[1]] * 1 + wheels[2][wheelHead[2]] * 2 + wheels[3][wheelHead[3]] * 4
				+ wheels[4][wheelHead[4]] * 8;
		System.out.println(answer);

	}

	public static void rotate(int wheel, int dir) {
		int temp = wheelHead[wheel];
		if (dir == -1) wheelHead[wheel] = temp + 1 >= m ? 0 : temp + 1;
		else wheelHead[wheel] = temp - 1 < 0 ? m - 1 : temp - 1;
	}

	public static int getLeft(int wheel) {
		return wheels[wheel][(wheelHead[wheel] + 6) % m];
	}

	public static int getRight(int wheel) {
		return wheels[wheel][(wheelHead[wheel] + 2) % m];
	}
}

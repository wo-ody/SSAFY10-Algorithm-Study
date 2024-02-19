package bj.S4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_9290_틱택토이기기 {
	static StringBuilder sb = new StringBuilder();
	static int T;
	static char[][] map; // 게임판의 상태
	static char h; // 남규의 말
	static List<int[]> h_map; // o 혹은 x 말이 놓여있는 좌표를 저장할 공간

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

		for (int t = 1; t <= T; t++) {
			sb.append("Case ").append(t).append(":").append("\n");
			map = new char[3][3];
			h_map = new ArrayList<>(); // 무조건 다음에 놓음으로써 이기기 때문에 o든 x든 2개가 놓여져 있을 예정

			for (int i = 0; i < 3; i++) {
				char[] charArray = br.readLine().toCharArray();
				map[i] = charArray;
			}
			h = br.readLine().charAt(0);

			// h값에 따라서 h_map에 해당 값의 좌표를 넣어주고
			// 가로, 세로, 대각 3개 확인해서 빙고가 되는지 확인

			if (h == 'x') {
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if (map[i][j] == 'x') {
							h_map.add(new int[] { i, j });
						}
					}
				}
			} else if (h == 'o') {
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if (map[i][j] == 'o') {
							h_map.add(new int[] { i, j });
						}
					}
				}
			}
			
			// h_map에 들어있는 2가지 좌표를 꺼내서
			// 0번째 인덱스 값이 서로 같으면 가로로 놓여있는거
			int[] a1 = h_map.get(0);
			int[] a2 = h_map.get(1);
			// 가로로 놓여있음
			if (a1[0] == a2[0]) {
				map[a1[0]][3- (a1[1] + a2[1])] = h;
			} else if (a1[1] == a2[1]) {
				map[3 - (a1[0] + a2[0])][a1[1]] = h;
			} else {
				map[3- (a1[0] + a2[0])][3 - (a1[1] + a2[1])] = h;
			}
			
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					sb.append(map[i][j]);
				}	
				sb.append("\n");
			}

		}
		System.out.println(sb);
	}
}







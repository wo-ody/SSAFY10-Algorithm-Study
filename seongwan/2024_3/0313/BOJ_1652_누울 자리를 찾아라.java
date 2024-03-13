import java.io.BufferedReader;
import java.io.InputStreamReader;

//가로, 세로를 기준으로 벽에 닿을 때까지의 연속된 빈 칸의 개수를 센다.
//벽에 닿았을 때 연속된 빈칸의 개수가 2이상이라면 누울 자리를 더해준다.
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static char[][] map;
	static int rans, cans;

	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		map = new char[N][N];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		//가로 기준 연속된 빈 칸 개수
		int rtemp = 0;
		//세로 기준 연속된 빈 칸 개수
		int ctemp = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				//가로 기준 탐색
				//벽을 만났을 때
				if (map[i][j] == 'X') {
					//연속된 빈 칸 수가 2이상이라면
					if (rtemp >= 2) {
						rans++;
					}
					//연속된 빈 칸 수 초기화
					rtemp = 0;
				}
				//벽이 아닐 때
				else {
					//연속 빈 칸 수 증가
					rtemp++;
				}

				//세로 기준 탐색
				if (map[j][i] == 'X') {
					//연속된 빈 칸 수가 2이상이라면
					if (ctemp >= 2) {
						cans++;
					}
					//연속된 빈 칸 수 초기화
					ctemp = 0;
				}
				//벽이 아닐 때
				else {
					//연속 빈 칸 수 증가
					ctemp++;
				}
			}
			if (rtemp >= 2)
				rans++;
			if (ctemp >= 2)
				cans++;

			rtemp = 0;
			ctemp = 0;
		}
		System.out.println(rans + " " + cans);
	}
}
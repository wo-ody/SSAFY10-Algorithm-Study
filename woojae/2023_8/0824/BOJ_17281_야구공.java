import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1번 선수는 상시 4번 타자로 지명

public class Main {
	static int n;
	static int[][] inning;
	static int[] order = new int[9];
	static boolean[] pick = new boolean[9];
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		inning = new int[n][9];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++)
				inning[i][j] = Integer.parseInt(st.nextToken());
		}
		order[3] = 1; pick[3] = true;
		perm(2);  // 1번 선수 다음부터 이뤄나가야 하므로
		System.out.println(answer);
	}
	
	static void perm(int target) {
		if(target == 10) {  // 선발 명단 작성 완료
			int get_score = play(order);
			answer = answer < get_score ? get_score : answer;
			return;
		}
		
		for(int i = 0; i < 9; i++) {  // 단순 모든 경우의 수에 대한 선수 뽑기, 야구는 순서에 영향을 받기 때문에 순열 이용
			if(pick[i])
				continue;
			pick[i] = true;
			order[i] = target;
			perm(target + 1);
			pick[i] = false;

		}
	}
	
	static int play(int[] players) {  // 게임 진행 로직
		int num = 0;  // 선수를 가리킬 변수
		int game_score = 0;  // 해당 게임의 점수를 기록할 변수
		for (int[] now_inning : inning) {  // 각 이닝에 대한 정보를 가져와서
			int out = 0;  // 게임마다 아웃된 선수 초기화
			int base1 = 0, base2 = 0, base3 = 0;  // 게임마다 각 루 초기화 -> 루의 활성 여부가 점수로 이어짐
			while(out < 3) {  // 해당 이닝이 끝나기 전까지 -> out이 3개
				int current_hitter = players[num++] - 1;  // 현재 타자 -> 선수 번호가 이닝의 인덱스에 해당하지만 0번 인덱스부터 저장했으므로 -1을 수행하여 맞춰줌
				if(now_inning[current_hitter] == 0)  // 현재 타자가 아웃되었다면
					out++;
				else if(now_inning[current_hitter] == 1) {  // 현재 타자가 안타라면
					game_score += base3;  // 3루 선수 홈으로 복귀
					base3 = base2; base2 = base1; base1 = 1;  // 홈과 가까운 루 순으로 이동
				}
				else if(now_inning[current_hitter] == 2) {  // 2루타
					game_score += base3 + base2;
					base3 = base1; base2 = 1; base1 = 0;
				}
				else if(now_inning[current_hitter] == 3) {  // 3루타
					game_score += base3 + base2 + base1;
					base3 = 1; base2 = 0; base1 = 0;
				}
				else {  // 홈런
					game_score += base3 + base2 + base1 + 1;  // 각 루에 있는 사람들 및 타자(+1) 복귀
					base3 = 0; base2 = 0; base1 = 0;
				}
				num %= 9;  // 다음 이닝에서 선수의 순서가 이어져야 하므로 -> 1이닝에서 9번선수가 쳤다면 2이닝에선 라인업 상의 9번 선수 다음 선수가 출전함
			}
		}
		return game_score;
	}
}

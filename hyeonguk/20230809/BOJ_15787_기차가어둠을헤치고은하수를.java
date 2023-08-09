import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int N, M, answer;
	static char[][] trains;
	static HashMap<String, Integer> map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		trains = new char[N + 1][22];
		map = new HashMap<>();
		
		// 값 초기화
		for(int i=1; i<= N; i++) {
			trains[i] = "0000000000000000000000".toCharArray();
		}
		
		// 값 입력 받기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			int train = Integer.parseInt(st.nextToken());
			int seat = 0;
			if (command == 1 || command == 2) {
				seat = Integer.parseInt(st.nextToken());
			}

			switch (command) {
			case (1):
				commandOne(train, seat);
				break;
			case (2):
				commandTwo(train, seat);
				break;
			case (3):
				commandThree(train);
				break;
			case (4):
				commandFour(train);
				break;
			}
		}
		countTrains();
		System.out.println(answer);

	}

	static void commandOne(int i, int x) {
		// 이미 사람이 타고 있으면 아무 행동을 하지 않는다.
		if (trains[i][x] == '1')
			return;

		// 자리가 비어있으면 i번째 기차에 x번 좌석에 사람을 태운다.
		trains[i][x] = '1';
	}

	static void commandTwo(int i, int x) {
		// 아무도 i번 기차의 x번에 앉아 있지 않았으면 아무 행동을 하지 않는다.
		if (trains[i][x] == '0')
			return;

		// i번째 기차의 x번 좌석에 앉아 있는 사람은 하차한다.
		trains[i][x] = '0';
	}

	static void commandThree(int i) {
		// i번째에 앉아있는 승객은 모두 한칸씩 뒤로 간다.
		trains[i][0] = '0';
		for (int j = 20; j >= 0; j--) {
			trains[i][j + 1] = trains[i][j];
		}
		trains[i][21] = '0';
	}

	static void commandFour(int i) {
		// i번째 기차에 앉아있는 승객들이 모두 한칸씩 앞으로 간다.
		trains[i][21] = '0';
		for (int j = 1; j <= 21; j++) {
			trains[i][j - 1] = trains[i][j];
		}
		trains[i][0] = '0';
	}
	
	static void countTrains() {
		for(int i=1; i<=N; i++) {
			String key = String.copyValueOf(trains[i]);
			// 이미 해당 문자열이 있으면 skip
			if(map.containsKey(key)) continue;
			
			// 맵에 문자열이 없으면 문자열 추가.
			map.put(key, 1);
		}
		answer = map.size();
	}
}

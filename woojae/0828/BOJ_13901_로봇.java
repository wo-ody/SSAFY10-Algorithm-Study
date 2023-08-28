import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int r, c;
	static int k;
	static int br, bc;
	static int sr, sc;
	static int[][] maps;
	static int[] direction_code = new int[4];
	static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static Robot robot;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		maps = new int[r][c];
		k = Integer.parseInt(in.readLine());
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(in.readLine());
			br = Integer.parseInt(st.nextToken());
			bc = Integer.parseInt(st.nextToken());
			maps[br][bc] = -1;
		}
		st = new StringTokenizer(in.readLine());
		sr = Integer.parseInt(st.nextToken());
		sc = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < 4; i++)
			direction_code[i] = Integer.parseInt(st.nextToken()) - 1;  // 방향 벡터 인덱스와 맞추기 위해
		
		robot = new Robot(sr, sc);
		search();
	}
	
	static void search() {
		int i = 0;
		while(check()) {  // 로봇이 움직일 수 없을 경우 동작을 멈춘다. 
			int code = (direction_code[i]);  // 로봇은 사용자가 지정한 방향을 일직선으로 움직인다.
			int[] d = direction[code];  // 사용자가 지정한 다음 방향이 없다면 맨 처음 방향으로 돌아가서
			int my = robot.y + d[0];
			int mx = robot.x + d[1];
			if(0 <= my && my < r && 0 <= mx && mx < c && maps[my][mx] == 0) {  // 이동 중 벽이나 방문한 지역, 장애물을 만날 경우
				maps[robot.y][robot.x] = -1;
				robot.y = my;
				robot.x = mx;
				continue;  // 갈 수 없는 상황이 아니라면 동일한 방향으로 지속해서 나아가야 함
			}
			i = (i + 1) % 4;  // 더 이상 갈 수 없다면 로봇은 사용자가 지정한 다음 방향으로 움직인다. 또한 마지막 명령 기준 더 이상 진행할 명령이 없다면 처음 명령으로 돌아간다.
		}
		System.out.println(robot.y + " " + robot.x);
	}
	
	static boolean check() {
		int y = robot.y;
		int x = robot.x;
		int available_way = 4;
		
		for (int i : direction_code) {  // 주어진 방향에 맞춰
			int my = y + direction[i][0];
			int mx = x + direction[i][1];
			boolean cond = 0 <= my && my < r && 0 <= mx && mx < c && maps[my][mx] == 0;  // 갈 수 있는 곳이 있는지 없는지 판단
			if(!cond)
				available_way--;
		}
		return available_way == 0 ? false : true;  // 갈 수 있는 곳이 하나도 없다면 false 아니고 하나라도 있다면
	}
	
	static class Robot {
		int y, x;
		Robot(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}

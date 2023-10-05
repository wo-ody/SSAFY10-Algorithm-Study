import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
//	1. 섬에서 탐색하다가 다른 섬을 만났는지 어떻게 확인하는지? -> 입력받을 때 값이 1이면 방문처리 해놓자
//  2. 그럼 애초에 탐색 불가 -> 그럼 가장 자리들을 남겨두고 방문처리 하는 것은? 
//	3. 마찬가지로 탐색하다가 같은 섬의 다른 가장자리 만나면 어떻게 할껀데 -> 그리고 애초에 가장 자리만 할껀데
//	4. 다 기각 -> 그냥 섬을 다른 숫자로 구분하자
	static int n;
	static int[][] maps;
	static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};  // 탐색 방향
	static int label = -1;  // 초기 섬 레이블
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		maps = new int[n][n];

		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++)
				maps[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				if(maps[i][j] == 1)  // 아직 섬이 레이블링 되어있지 않다면
					bfs(i, j, "labeling");
		
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				if(maps[i][j] < 0)  // 섬들을 중심으로, 섬들을 음수로 레이블링 함
					bfs(i, j, "search");
		
		System.out.println(answer);
	}
	
	static void bfs(int y, int x, String cmd) {
		int bridge_length = 0;  // 어떤 값인지 확인하기 위한 변수
		Queue<int []> q = new ArrayDeque<int[]>(Arrays.asList(new int[] {y, x, bridge_length}));  // 해당 좌표와 초기 다리의 길이를 저장
		boolean[][] visited = new boolean[n][n];
		int location = maps[y][x];  // 다리를 만들 때 다른 섬인지 확인하기 위한 비교용 변수
		
		while(!q.isEmpty()) {  // 탐색할 위치가 남아있다면
			int[] dq = q.poll();
			int sy = dq[0], sx = dq[1];
			if(!visited[sy][sx]) {  // 해당 좌표를 아직 방문하지 않았다면
				visited[sy][sx] = true;
				if(cmd.equals("labeling")) maps[sy][sx] = label;  // 만약 레이블링 중이었다면 해당 섬 레이블링
				for (int[] d : direction) {  // 각 방향 벡터에 맞춰
					int my = sy + d[0];  // 이동할 방향 갱신
					int mx = sx + d[1];
					if((0 <= my && my < n && 0 <= mx && mx < n) && !visited[my][mx] && maps[my][mx] == 1 && cmd.equals("labeling"))
						q.offer(new int[] {my, mx});  // 레이블링 중이며 유효 범위이고 아직 방문하지 않았으며 레이블링 되지 않은 섬이라면
					else if((0 <= my && my < n && 0 <= mx && mx < n) && !visited[my][mx] && maps[my][mx] != location && cmd.equals("search")) {  // 현재 섬과 다른 곳을 탐색 중이라면
						if(maps[my][mx] == 0) {  // 그곳이 바다라면
							q.offer(new int[] {my, mx, dq[2] + 1});  // 현재 시점에서 다리 길이를 갱신해서 다음 위치로 탐색하기 위해 좌표 저장
							// 현재 시점의 다리를 넘겨주지 않고 무작정 다리 길이를 갱신했더니 바다인 모든 부분을 다 기록해버림 -> 이 부분에서 계속 해맸음
						}
						else {  // 다른 섬을 만났다면
							answer = dq[2] < answer ? dq[2] : answer;  // 현재 시점의 다리 길이가 최소일 때 갱신
						}
					}
				}
			}
		}
		label--;  // 레이블링 중일 때 해당 섬에 대한 레이블링이 종료되면 다음 섬의 레이블링을 위해 다음 레이블로 변경
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int r, c;
	static char[][] maps;
	static boolean[][] visit;
	static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int[] res = new int[2];
	static int v, o;
	static int alive_wolf = 0, alive_sheep = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		maps = new char[r][c];
		visit = new boolean[r][c];
		
		for(int i = 0; i < r; i++) {
			maps[i] = br.readLine().toCharArray();
			for(int j = 0; j < c; j++)
				if(maps[i][j] == '#')  // 울타리의 경우 처음부터 탐색 범위에서 제외시키기 위해 true처리
					visit[i][j] = true;
		}
		
		for(int i = 0; i < r; i++)
			for(int j = 0; j < c; j++) {
				if(!visit[i][j]) {  // 아직 탐색하지 않은 곳이라면
					res = bfs(i, j);
					v = res[0];  // 해당 탐색에서 발견한 늑대의 수
					o = res[1];  // 해당 탐색에서 발견한 양의 수
					if(o > v)  // 해당 탐색에서 양이 늑대보다 많이 발견되었다면 -> 같거나 많은 것이 아닌 무조건 많아야 함
						alive_sheep += o;  // 살아남은 양의 수에 해당 탐색에서 발견한 양의 수 추가
					else  // 늑대가 양보다 많거나 같다면
						alive_wolf += v;  // 살아남은 늑대의 수에 해당 탐색에서 발견한 늑대의 수 추가
				}
			}
		System.out.println(alive_sheep + " " + alive_wolf);
	}
	
	static int[] bfs(int sy, int sx) {
		Queue<int[]> q = new ArrayDeque<int[]>(Arrays.asList(new int[] {sy, sx}));
		int wolf = 0;  // 탐색에서 발견한 늑대 및 양의 수
		int sheep = 0;
		
		while(!q.isEmpty()) {
			int[] pos = q.poll();  // 탐색할 곳의 좌표
			int y = pos[0];
			int x = pos[1];
			if(!visit[y][x]) {  // 아직 방문하지 않았다면 -> 처음 큐의 시작은 무조건 방문하지 않은 곳이지만 해당 탐색에서 발견한 좌표가 방문한 곳인지 아닌지는 알 수 없음
				visit[y][x] = true;
				if(maps[y][x] == 'v')  // 해당 좌표가 늑대나 양을 가리키고 있다면 발견 수 + 1
					wolf++;
				if(maps[y][x] == 'o')
					sheep++;
				for (int[] d : direction) {  // 주변 탐색
					int my = y + d[0];
					int mx = x + d[1];
					if(0 <= my && my < r && 0 <= mx && mx < c) {  // 유효 범위라면
						q.add(new int[] {my, mx});  // 일단 큐에 추가
					}
				}
			}
		}
		return new int[] {wolf, sheep};  // 발견한 늑대 및 양의 수 반환
	}
}

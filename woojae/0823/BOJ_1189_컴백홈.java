import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int r, c, k;
	static int answer = 0;
	static char[][] maps;
	static boolean[][] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		maps = new char[r][c];
		visit = new boolean[r][c];
		
		for(int i = 0; i < r; i++)
			maps[i] = br.readLine().toCharArray();
		
		dfs(r-1, 0, 1);
		System.out.println(answer);
	}
	
	static void dfs(int y, int x, int distance) {
		if(y == 0 && x == c - 1) {  // 기저 조건은 항상 인덱스가 목표 지점에 도달했는지를 체크할 것
			if(distance == k)  // 목적지에 도달했을 때 주어진 거리만큼 움직였다면
				answer++;
			return;
		}
		if((0 <= y && y < r && 0 <= x && x < c) && maps[y][x] != 'T' && !visit[y][x]) {
			visit[y][x] = true;
			dfs(y - 1, x, distance + 1);
			dfs(y + 1, x, distance + 1);
			dfs(y, x - 1, distance + 1);
			dfs(y, x + 1, distance + 1);
			visit[y][x] = false;
		}
		return;
	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] map;
	static int[][] visited;
	
	static int result;
	
	static int[] dx = {-1,-1,1,1};
	static int[] dy = {-1,1,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		int ans = 0;
//		for (int i = 0; i < 2; i++) {
//			result = 0;
//			combination(0, i, 0);
//			ans += result;
//		}
		
		System.out.println(combination(0,0,0) + combination(0,1,0));
		
	}
	
	static void isB(int x,int y,int value) {
		visited[x][y] += value; // 비숍 놓기
		for (int k = 0; k < 4; k++) {
			int cx = x;
			int cy = y;
			while(true) {
				cx += dx[k];
				cy += dy[k];
				if(cx < 0 || cx >= N || cy < 0 || cy >= N) break;
				visited[cx][cy] += value;
			}
		}
	}
	
	static int combination(int sx, int sy, int cnt) {
		int max = -1;
		
		int j;
		for (int i = sx; i < N; i++) {
			for (j = sy; j < N; j+=2) {
				if(visited[i][j] != 0 || map[i][j] == 0) continue; // 비숍 놓을 수 있는 자리가 아님
				// 비숍 놓고
				isB(i,j,1);
				max = Math.max(max, combination(i,j,cnt + 1));
				// 비숍 제거
				isB(i,j,-1);
			}
			if(j % 2 == 0) sy = 1;
			else sy = 0;
		}
		
//		result = Math.max(cnt, result);
		return Math.max(max, cnt);
	}

}

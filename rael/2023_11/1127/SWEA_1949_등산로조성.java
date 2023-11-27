package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// DFS
public class SW_등산로조성 {

	static int T, N, K, ans;
	static int[][] map;
	static boolean[][] visit;
	static boolean useK; // dfs 로 방문을 이어가면서 현재까지 K 를 사용했는지 여부
	
	// 출발지
	static ArrayList<int[]> maxList = new ArrayList<>();
	
	static int[] dy = {-1, 1, 0, 0 };
	static int[] dx = { 0, 0,-1, 1 };
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			visit = new boolean[N][N];
			maxList.clear();
			ans = 0;
			
			// 입력을 받으면서 최대값을 확인
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int n = Integer.parseInt(st.nextToken());
					map[i][j] = n;
					max = Math.max(max, n);
				}
			}
			
			// max 값을 가지는 (출발지) 의 좌표를 자료구조 maxList 에 담는다.
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if( map[i][j] == max ) maxList.add(new int[] {i, j});
				}
			}
			
			// maxList 의 출발지 각각에서 따져본다.
			for (int i = 0; i < maxList.size(); i++) {
				int sy = maxList.get(i)[0];
				int sx = maxList.get(i)[1];
				
				// 출발
				useK = false;
				visit[sy][sx] = true; // 현 시작점 visit check
				
				int cnt = dfs(sy, sx); // 현 시작점에서 출발해서 갈 수 있는 최대 길이
				ans = Math.max(ans, cnt); // 현 테케의 최대길이 갱신
				
				visit[sy][sx] = false; // 탐색을 마친 현 시작점 visit unckeck
				
			}
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

	static int dfs(int y, int x ) {
		int maxCnt = 0;
		
		// 사방탐색, K 사용 등을 고려한 재귀호출 결과를 통해서 maxCnt 갱신
		// 현 좌표에서 가능한 모든 경우를 고려해서 재귀호출을 진행
		// 그 각각의 재귀호출의 리턴 결과는 그 경우로 갔을 때 갈 수 있는 가장 긴 길이
		// 그 값들 중 최대값을 선택
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			
			if( ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx] ) continue;
			
			// k 를 사용하지 않는 경우(항상 고려)
			if( map[ny][nx] < map[y][x] ) {
				visit[ny][nx] = true;
				maxCnt = Math.max(maxCnt, dfs(ny, nx));
				visit[ny][nx] = false;
			}
			// k 를 사용하는 경우
			if(!useK) {
				useK = true;
				// K 만큼 for 반복
				for (int k = 1; k <= K; k++) {
					map[ny][nx] -= k;
					visit[ny][nx] = true;
					
					if( map[ny][nx] < map[y][x] ) {
						maxCnt = Math.max(maxCnt, dfs(ny, nx));
					}
					
					map[ny][nx] += k;
					visit[ny][nx] = false;
				}
				
				useK = false;
			}
		}
		
		return maxCnt + 1;
		
	}
}

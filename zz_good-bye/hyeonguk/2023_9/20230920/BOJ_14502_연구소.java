import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	// 동, 남, 서, 북
	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {1, 0, -1, 0};
	static int N, M, answer, listZeroLength;
	static boolean[][] visited;
	static int[][] srcMap, map, tgt;
	
	static List<int[]> listZero = new ArrayList<>();
	static List<int[]> listTwo = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		srcMap = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				srcMap[i][j] = Integer.parseInt(st.nextToken());
				if(srcMap[i][j] == 0) listZero.add(new int[] {i, j});
				if(srcMap[i][j] == 2) listTwo.add(new int[] {i, j});
			}
		}
		
		// 0. map을 내용을 복사하여 map_copy를 만든다, visited를 새로 만든다. answer값 초기화.
		copy(); // map 내용 복사
		listZeroLength = listZero.size();
		answer = Integer.MIN_VALUE;
		visited = new boolean[N][M];
		tgt = new int[3][2];
		
		// 1. map_copy의 비어있는 곳 중에서 3곳을 골라 1로 채운다. 새로운 위치마다 반복(64C3)
		fillWall(0, 0);
		
		// 최대값을 출력한다.
		System.out.println(answer);
		
	}
	
	static void copy() {
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = srcMap[i][j];
			}
		}
	}
	
	static void bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		for(int[] two : listTwo) {
			visited[two[0]][two[1]] = true;
			queue.offer(two);
		}
		
		while(!queue.isEmpty()) {
			int[] items = queue.poll();
			int y = items[0];
			int x = items[1];
			
			for(int d=0; d<4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				
				if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
				
				if(!visited[ny][nx] && map[ny][nx] == 0) {
					visited[ny][nx] = true;
					map[ny][nx] = 2;
					queue.offer(new int[] {ny, nx});
				}
			}
		}
	}
	
	static void fillWall(int tgtIdx, int srcIdx) {
		// 조합이 완성되면
		if(tgtIdx == tgt.length) {
			// 1. 해당 위치들을 1로 채운다.
			for(int[] item : tgt) {
				map[item[0]][item[1]] = 1;
			}
			
			// 2. bfs를 실행한다.
			bfs();
			
			
			// 3. 0의 개수를 세어 본다.
			int cnt = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j]==0) cnt++;
				}
			}
			
			// 4. answer 값의 최댓값을 갱신한다.
			answer = Math.max(answer, cnt);
			
			// 5. 사용했던 변수들을 초기화 한다.
			copy();
			visited = new boolean[N][M];
			return;
		}
		
		if(srcIdx == listZeroLength) return;
		
		int[] item = listZero.get(srcIdx);
		tgt[tgtIdx][0] = item[0];
		tgt[tgtIdx][1] = item[1];
		
		// 다음 위치에 다음 값 고려
		fillWall(tgtIdx+1, srcIdx+1);
		
		// 현재 위치에 다음 값 고려
		fillWall(tgtIdx, srcIdx+1);
	}
}

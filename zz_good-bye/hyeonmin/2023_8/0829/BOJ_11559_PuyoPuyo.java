
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

// 1s, 256MB
public class BOJ_11559_PuyoPuyo {

	static char[][] field;
	static boolean[][] visit;
	static boolean[][] targetPop;
	static int combo;
	static boolean playing;
	
	//					상   하    좌    우
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	//상대방의 필드가 주어졌을 때, 연쇄가 몇 번 연속으로 일어날지 계산하여 남규를 도와주자!
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		field = new char[12][6];
		playing = true;
		combo = 0;
		
		for (int i = 0; i < 12; i++) {
			field[i] = br.readLine().toCharArray();
		}
		while(playing) {
			visit = new boolean[12][6];
			targetPop = new boolean[12][6];
			int sumPop = 0;
			// bfs로 4개 이상 뿌요 찾아서 targetPop에 check 하기
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if(field[i][j] == '.' || visit[i][j]) continue;

					// 탐색할 때마다 새로운 공격좌표 만들어주기
					targetPop = new boolean[12][6];
					if( bfs(i, j)>=4 ) {
						sumPop++;
						// targetPop에서 check한 뿌요 뿌시러 가기
						popPuyo();
					}
				}
			}
			if(sumPop>0) combo++;
			
			// 밑에서부터 탐색해서, 빈 자리에 뿌요 내리기
			for (int i = 11; i >= 0; i--) {
				for (int j = 5; j >= 0; j--) {
					if(field[i][j] == '.') continue;
					fall(i, j);
				}
			}
			
			
			// 게임 더 진행할 수 있는지 확인해서 playing 다시 true로 만들기
			visit = new boolean[12][6];
			playing = false;
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if(field[i][j] == '.') continue;
					
					// 4개 이상인 뿌요를 한번이라도 찾으면 게임을 계속 진행할 수 있게 true로 만든다.
					if(bfs(i, j)>=4) {
						playing = true;
					}
				}
			}
			
		}
		
		System.out.println(combo);
//		for (int i = 0; i < 12; i++) {
//			for (int j = 0; j < 6; j++) {
//				System.out.print(field[i][j]);
//			}
//			System.out.println();
//		}
		
		
	}
	
	static int bfs(int y, int x) {
		
		Queue<int[]> queue = new ArrayDeque<>();
		visit[y][x] = true;
		targetPop[y][x] = true;
		queue.offer(new int[] {y,x});
		int puyoCnt = 0;
		char equalChar = field[y][x];
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			targetPop[cur[0]][cur[1]] = true;
			puyoCnt++;
			
			for (int i = 0; i < 4; i++) {
				int ny = cur[0] + dy[i];
				int nx = cur[1] + dx[i];
				if( isOutRange(ny, nx) || visit[ny][nx]) continue;
				if( field[ny][nx] != equalChar ) continue;
				visit[ny][nx] = true;
				queue.offer(new int[] {ny, nx});
			}
		}
		
		return puyoCnt;
	}
	
	static void popPuyo() {
		// targetPop에서 체크된거 모두 터뜨리기(제거)
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 6; j++) {
				if(targetPop[i][j]) field[i][j] = '.';
			}
		}
	}
	
	static void fall(int y, int x) {
		int ny = y+dy[1]; // down
		int nx = x+dx[1]; // down
		if( isOutRange(ny, nx) ) return;
		if(field[ny][nx] == '.') {
			field[ny][nx] = field[y][x];
			field[y][x]='.';
			fall(ny,nx);
			return;
		} else {
			return;
		}
	}
	
	
	static boolean isOutRange(int y, int x) {
		return y < 0 || y >= 12 || x < 0 || x >= 6;
	}
	
}

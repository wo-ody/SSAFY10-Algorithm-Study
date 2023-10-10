package alone;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502_연구소 {
	static int N,M,max;
	static int[][] lab;
	static int[][] copyLab;
	static boolean[][] visit;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	//조합
	static int[] tgt = new int[3];
	static int[][] wall = new int[3][2];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		lab = new int[N][M];
		copyLab = new int[N][M];
		visit = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());
				copyLab[i][j] = lab[i][j];
			}
		}
		
		comb(0,0); 
		System.out.println(max);
	}

	static void comb(int srcIdx, int tgtIdx) {
		if(tgtIdx == 3) {
			for(int i=0; i<3; i++) {
				wall[i][0] = tgt[i]/M; //y좌표
				wall[i][1] = tgt[i]%M; //x좌표 
			}
			if(setLab()) { // lab에 벽 세우기
				//-> 바이러스도 아니고 기존 벽도 아닌 곳에 벽을 세우면 true
				virus(); //바이러스 퍼트리기
				max = Math.max(countSafe(), max);
			} 
			return;
		}
		
		if(srcIdx == N*M) return;
		
		tgt[tgtIdx] = srcIdx;
		comb(srcIdx+1, tgtIdx+1);
		comb(srcIdx+1, tgtIdx);
	}

	private static boolean setLab() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				lab[i][j] = copyLab[i][j]; //초기화 후
				for(int k=0; k<3; k++) { //벽세우기
					if(wall[k][0] == i && wall[k][1] == j) {
						if(lab[i][j] == 2 || lab[i][j] == 1) return false; 
						//벽세울곳이 바이러스이거나 이미 벽이 있다면 false
						lab[i][j] = 1;
						break;
					}
				}
			}
		}
		//벽이 다 세워졌다면 return true;
		//방문도 초기화
		visit = new boolean[N][M];
		return true;
	}

	private static void virus() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(lab[i][j] == 2) {
					bfs(i,j);//바이러스이면 bfs
				}
			}
		}
		
	}
	
	private static void bfs(int i, int j) {
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(i,j));
		visit[i][j] = true;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			int y = node.y;
			int x = node.x;
			
			for(int d=0; d<4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				
				if(ny<0 || nx<0 || ny>=N || nx>=M || visit[ny][nx] 
						|| lab[ny][nx]==1 ) continue;
				
				visit[ny][nx] = true;
				lab[ny][nx] = 2;
				q.add(new Node(ny,nx));
			}
		}
		
	}
	
	static int countSafe() {
		int count = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(lab[i][j] == 0) {
					count++;
				}
			}
		}
		return count;
	}

	static class Node{
		int y,x;
		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
}

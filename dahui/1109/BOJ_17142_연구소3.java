package alone;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17142_연구소3 {
	static int N,M,time,blankCnt;
	static ArrayList<Node> virus = new ArrayList<>(); //바이러스 좌표 넣기 
 	static int[] tgt;
 	static boolean[][] visit; //방문배열만 초기화해주면 0인곳을 2로바꿀필요 없다.
	static int[][] map;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		visit = new boolean[N][N];
		tgt = new int[M]; // 처음에 활성화시킬 바이러스의 arrayList index가 들어있다. 
		time = INF;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==2) virus.add(new Node(i,j)); //바이러스 위치 넣어주기 
				if(map[i][j]==0) blankCnt++;
			}
		}
		
		comb(0,0);
		
		System.out.println(time==INF? -1 : time);
	}
	
	public static void comb(int srcIdx, int tgtIdx) {
		//기저조건
		if(tgtIdx == tgt.length) {
			visit = new boolean[N][N];
			int t = simulation();
			time = Math.min(time, t);
			return;
		}
		//파라미터로 전해진 srcIdx부터 src에서 따지면 된다. srcIdx 이전 src는 이미 사용되었다.
		for(int i=srcIdx; i<virus.size(); i++) {
			tgt[tgtIdx] = i;
			comb(i+1, tgtIdx+1);
		}
	}
	
	public static int simulation() { //걸린 시간 반환하기 
		//현재 tgt에 바이러스의 arraylist index가 넣어져 있음. 
		Queue<Node> q = new ArrayDeque<>();
		int time = 0;
		int blank = blankCnt;
		
		for(int i=0; i<M; i++) {
			q.add(new Node(virus.get(tgt[i]).y,virus.get(tgt[i]).x));
		}
		
		while(!q.isEmpty()) {
			
			if(blank == 0) return time;
			
			int size = q.size();
			
			for(int i=0 ;i<size; i++) {
				Node n = q.poll();
				int y = n.y;
				int x = n.x;

				for(int d=0; d<4; d++) {
					int ny = y + dy[d];
					int nx = x + dx[d];
					//이번 시간에 퍼뜨리기 전인 copyMap을 확인하면서 퍼트리기
					if(ny<0 || nx<0 || ny>=N || nx>=N || map[ny][nx] == 1 || visit[ny][nx]) continue;
					
					if(map[ny][nx]==0) blank--;
					q.add(new Node(ny, nx));
					visit[ny][nx] = true;
				}
			}
			time++;
		}
		return INF; //다 퍼뜨릴 수 없다면 
	}

	
	public static class Node {
		int y,x;
		public Node(int y, int x) {
			this.y=y;
			this.x=x;
		}
	}

}

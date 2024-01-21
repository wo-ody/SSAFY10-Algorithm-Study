import java.io.*;
import java.util.*;


public class Main {

	static final int dx[] = {0,0,1,-1};
	static final int dy[] = {1,-1,0,0};
	static ArrayList<Pair> unionXY = new ArrayList<>();
	static boolean visit[][];
	static int map[][];
	static int n,l,r,cnt;
	static boolean isMove = false;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		move();
		
		System.out.println(cnt);
        
	}
	static void move() {
		
		while(true) {
			isMove = false;
			visit = new boolean[n][n]; //새로 BFS 시작할때마다 방문 초기화
			
			for(int i=0; i<n; i++) {
				for(int j=0;j<n; j++) {
					if(!visit[i][j]){
						 bfs(i,j);    //방문하지 않은상태면 BFS 시작
					}				
				}
			}
												
			if(!isMove) break; //국경이동이 없으면 종료.
			else cnt++; //국경이동이 있었다면 일수 추가.
		}
			
	}
	
	static void bfs(int x, int y) {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(x,y));
		visit[x][y] = true;
		unionXY.add(new Pair(x,y));
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			x = p.x;
			y = p.y;
			
			for(int k=0; k<4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				
				if(0<=nx && nx<n && 0<=ny && ny<n) {
					if(!visit[nx][ny] && l <= Math.abs(map[x][y] - map[nx][ny]) &&  Math.abs(map[x][y] - map[nx][ny]) <= r) {
						isMove = true;
						visit[nx][ny] = true;
						unionXY.add(new Pair(nx,ny));
						q.add(new Pair(nx,ny));
					}
				}	
			}				
		}	
		
		//BFS 가 끝나면 인구이동 결과 맵에 집어넣기
		int sum = 0;
		for(int i=0; i<unionXY.size(); i++) {
			Pair p = unionXY.get(i);
			 sum += map[p.x][p.y];
		}
		
		for(int i=0; i<unionXY.size(); i++) {
			Pair p = unionXY.get(i);
			map[p.x][p.y] = sum / unionXY.size();
		}
		unionXY.removeAll(unionXY);
	}

class Pair{
	int x;
	int y;
	
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}
}

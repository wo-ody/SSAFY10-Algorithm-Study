package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//0: 청소 안된 빈칸, 1: 벽
//청소된 빈칸 2로!
public class BOJ_14503_로봇청소기 {
	static int N,M;
	static Node robot;
	static int[][] room;
	static int[] dy = {-1, 0, 1, 0}; //북, 서, 남 ,동
	static int[] dx = {0, -1, 0, 1};
	static int ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		room = new int[N][M];
		
		//청소기 입력
		robot = new Node(0,0,0);
		st = new StringTokenizer(br.readLine());
		robot.y = Integer.parseInt(st.nextToken());
		robot.x = Integer.parseInt(st.nextToken());
		robot.d = Integer.parseInt(st.nextToken());
		
		if(robot.d == 1) robot.d = 3;
		else if(robot.d == 3) robot.d = 1;
		
		//방 입력 
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		simulation();

		System.out.println(ans);
	}
	
	static void simulation() {
		
		while(true) {
			int y = robot.y;
			int x = robot.x;
			int d = robot.d;
			if(room[y][x] != 2) {
				room[y][x] = 2;
				ans++;

			}else { //현재 방이 청소 되지 않았다
				int ny = robot.y;
				int nx = robot.x;
				int nd = robot.d;

	
				//4방향 돌기 청소할 곳 있는지 확인하
				int cnt = 0;
				for(int i=0; i<4; i++) {

					ny = y + dy[(nd+i)%4];
					nx = x + dx[(nd+i)%4];
						
					if(ny < 0 || nx < 0 || ny >= N || nx >= M || room[ny][nx] == 1 || room[ny][nx] == 2) {
						//맵 밖이거나 벽이거나 청소되었다면  
						cnt++;
					}
				}
				
				if(cnt != 4) {
				 //청소할 곳이 있다면  왼쪽으로 회전하면서 

					for(int j=1; j<5; j++) { //90도 돌고 시작하
						int cy = y + dy[(d+j)%4];
						int cx = x + dx[(d+j)%4];
						if(cy < 0 || cx < 0 || cy >= N || cx >= M || room[cy][cx] == 1 || room[cy][cx] ==2 )
						continue;
							
						robot.y = cy;
						robot.x = cx;
						robot.d = (d+j)%4;
						break;
					}
					
				}else{//방향을 다 돌았는데 청소할 곳이 없다면  
					ny = y + dy[(d+2)%4];
					nx = x + dx[(d+2)%4]; //후진
					
					if(ny < 0 || nx < 0 || ny >= N || nx >= M || room[ny][nx] == 1) {
						return; //후진했는데 벽이면 종료하기  
					}
					//후진 후 청소기 x,y
					robot.y = ny;
					robot.x = nx;
				}
			}
		}
	}
	
	static class Node {
		int y,x,d; //좌표,현재 보는 방향,현재 칸에서 몇번 회전했는지 
		
		public Node(int y, int x, int d) {
			this.y = y;
			this.x = x;
			this.d = d;
		}
	}
}

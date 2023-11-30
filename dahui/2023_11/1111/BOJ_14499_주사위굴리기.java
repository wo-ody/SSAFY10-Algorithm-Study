package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//이동한 칸에 쓰여있는 수가 0 이면 주사위의 바닥면에 쓰여 있는 수가 칸에 복사
//0이 아니면 칸에 쓰여있는 수가 주사위의 바닥면으로 복사 , 칸의 수는 0으로 
//0 : 위  / 1: 아래 / 2 : 북 / 3 : 남 / 4 : 서 / 5 : 동 
		// 0 1 2 3 4 5
//동으로 굴리면 4 5 2 3 1 0 
//서로    굴리면 5 4 2 3 0 1
//남으로 굴리면 2 3 1 0 4 5
//북으로 굴리면 3 2 0 1 4 5
public class BOJ_14499_주사위굴리기 {
	static int[] dice = new int[6];
	static int[][] map;
	static int N,M,K;
	static StringBuilder sb = new StringBuilder();
	static int[] dy = {0,0,0,-1,1}; //동 서 북 남 -> 1,2,3,4
	static int[] dx = {0,1,-1,0,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken()); //명령 개수
		
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<K; i++) {
			int command = Integer.parseInt(st.nextToken());
			
			int ny = y + dy[command];
			int nx = x + dx[command];
			
			if(ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
			
			y = ny;
			x = nx;
			
			//주사위 값들 위치 옮겨주기
			if(command == 1) East();
			else if(command == 2) West();
			else if(command == 4) South();
			else North();
			
			if(map[y][x] == 0) { //바닥이 0 이면
				map[y][x] = dice[1];
				sb.append(dice[0]).append("\n");
			}else { //바닥이 0이 아니면
				dice[1] = map[y][x];
				map[y][x] = 0;
				sb.append(dice[0]).append("\n");
			}
		}
		
		System.out.println(sb);
		
	}

	static void East()	{
		int top = dice[0];
		dice[0] = dice[4];
		dice[4] = dice[1];
		dice[1] = dice[5];
		dice[5] = top;
	}
	
	static void West()	{
		int top = dice[0];
		dice[0] = dice[5];
		dice[5] = dice[1];
		dice[1] = dice[4];
		dice[4] = top;
	}

	static void South()	{
		int top = dice[0];
		dice[0] = dice[2];
		dice[2] = dice[1];
		dice[1] = dice[3];
		dice[3] = top;
	}

	static void North()	{
		int top = dice[0];
		dice[0] = dice[3];
		dice[3] = dice[1];
		dice[1] = dice[2];
		dice[2] = top;
	}
}

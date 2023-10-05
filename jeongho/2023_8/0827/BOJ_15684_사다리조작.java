package algorithm2023.aug.day27;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15684_사다리조작 {
	static int N, M, H, ladder[][];
	static int min = Integer.MAX_VALUE;

	// 내려가는 경우와 가로선이 존재해서 좌우로 가는 경우
	static int[] dy = { 1, 0, 0 };
	static int[] dx = { 0, 1, -1 };

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		ladder = new int[H+1][N+1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			ladder[a][b] = 1;
			ladder[a][b+1] = 2;
		}
		makeLine(1,1,0);
		
		System.out.println(min==Integer.MAX_VALUE?-1:min);
		
	}
	
	//사다리 가로선 만드는 함수
	static void makeLine(int c, int r, int cnt) {
		//가로선 개수가 3개를 넘으면 탐색 ㄴㄴ
		if(cnt>3)return;
		
		//오른쪽 끝에 도달하면 한 층 아래로 탐색
		if(c>=N) {
			makeLine(1,r+1,cnt);
			return;
		}
		//마지막층까지 탐색 완료한 경우
		if(r==H+1) {
			//i번째 사다리가 모두 i에 도착한다면 최소값 갱신
			if(isValid()) {
				min = Math.min(min, cnt);
			}
			return;
		}
		
		//해당 사다리의 해당 층에 아직 선이 연결되어있지 않다면 연결하고 탐색
		if(ladder[r][c]==0&&ladder[r][c+1]==0) {
			ladder[r][c]=1;
			ladder[r][c+1]=2;
			makeLine(c+2,r,cnt+1);
			//탐색후에는 지워줌
			ladder[r][c] = 0;
			ladder[r][c+1]=0;
		}
		//연결하지 않은 경우 탐색
		makeLine(c+1,r,cnt);
	}
	
	//i번째 사다리가 모두 i에 도착하는지 확인하기 위한 함수
	static boolean isValid() {
		for(int i=1 ;i<=N;i++) {
			int x = i;
			int y = 1;
			while(y<=H) {
				int d = ladder[y][x];
				int ny = y+1;
				int nx = x+dx[d];
				x=nx;
				y=ny;
			}
			if(x!=i){
					return false;
			}
			
		}
		return true;
	}
}

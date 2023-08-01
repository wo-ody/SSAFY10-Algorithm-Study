package BOJ2468;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int N;
	static int[][] city;
	static int[][] check;
	
	//x,y 지점을 기준으로 주변을 탐색하는 재귀함수
	public static void find_DFS(int x, int y, int h) {
		for(int m=0; m<4; m++) {
			int nx = x + dx[m];
			int ny = y + dy[m];
			
			//건너갈 nx, ny 좌표에 대한 유효성을 먼저 검증
			if(0 <= nx && nx < N && 0 <= ny && ny < N
			   && check[nx][ny] != 1 && city[nx][ny]>h) {
				//유효성이 검증된 좌표에 한해서 재귀함수를 호출.
				check[nx][ny] = 1;
				//실질적으로 재귀함수가 하는 역할은 check 배열의 true, false 관리
				find_DFS(nx, ny, h);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		N = Integer.parseInt(br.readLine());
		city = new int[N][N];
		check = new int[N][N];
		int ans = 1;
		
		//입력 받기
		int max = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
				//최댓값도 업데이트
				if(city[i][j] > max) max = city[i][j];
			}
		}
		
		for(int k=0; k<max; k++) {
			//visit check도 초기화
			for(int x=0; x<N; x++) {
				Arrays.fill(check[x], 0);
			}
			int cnt = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(city[i][j] > k && check[i][j] != 1) {
						cnt++;
						check[i][j] = 1;
						find_DFS(i, j, k);
					}
				}
			}
			ans = (ans > cnt) ? ans : cnt;
		}
		
		System.out.println(ans);
	}
}

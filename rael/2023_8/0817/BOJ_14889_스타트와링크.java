package BOJ14889;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
	static int N;
	static int[][] map;
	static boolean[] visit;
	
	static int Min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N];
 
 
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
 
		comb(0, 0);
		System.out.println(Min);
	}
 
	static void comb(int idx, int depth) {
		//기저조건
		if(depth == N / 2) {
			solve();
			return;
		}
 
		for(int i = idx; i < N; i++) {
			if(!visit[i]) {
				visit[i] = true;	
				comb(i+1, depth+1);	
				visit[i] = false;
			}
		}
	}
	
	//두 팀의 차 구하기
	static void solve() {
		int team_start = 0;
		int team_link = 0;
 
		for (int i=0; i<N-1; i++) {
			for (int j=i+1; j<N; j++) {
				// 스타트팀 승
				if (visit[i] == true && visit[j] == true) {
					team_start += map[i][j];
					team_start += map[j][i];
				}
				// 링크팀 승
				else if (visit[i] == false && visit[j] == false) {
					team_link += map[i][j];
					team_link += map[j][i];
				}
			}
		}
		int val = Math.abs(team_start - team_link);
		
		//가지치기 - 이미 최소
		if (val == 0) {
			System.out.println(val);
			System.exit(0);
		}
		
		Min = Math.min(val, Min);
	}
}
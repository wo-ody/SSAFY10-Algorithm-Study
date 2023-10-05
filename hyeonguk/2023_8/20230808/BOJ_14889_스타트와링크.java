import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static int N, answer;
	static boolean[] visited;
	static int[][] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 초기화
		N = Integer.parseInt(br.readLine());
		// 팀의 능력치 차이의 최대는 2000
		answer = 2001;
		visited = new boolean[N+1];
		graph = new int[N+1][N+1];
		
		// graph 값 입력 받기.
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		comb(1, 0);
		System.out.println(answer);
		
	}
	
	// N 명중에 N/2명 고르는 메서드
	// N == 20 -> 20C10으로 대략 150만개 경우의 수
	static void comb(int srcIdx, int tgtIdx) {
		// 팀원이 10명이 되면
		if(tgtIdx == N/2) {
			sum();
			return;
			// 능력치 차이 계산 메서드 호출
		}
		
		for(int i=srcIdx; i<= N; i++) {
			visited[i] = true;
			comb(i+1, tgtIdx + 1);
			visited[i] = false;
		}
	}
	
	// 각팀 능력치 차이 계산하는 메서드
	static void sum() {
		int teamOne = 0;
		int teamTwo = 0;
		for(int i=1; i<=N; i++) {
			// 첫번째 팀인 경우 능력치 계산
			if(visited[i]) {
				for(int j=i; j<=N; j++) {
					if(visited[j]) teamOne += (graph[i][j]+graph[j][i]);
				}
			// 두번째 팀인 경우 능력치 계산
			}else {
				for(int j=i; j<=N; j++) {
					if(!visited[j]) teamTwo += (graph[i][j]+graph[j][i]);
				}
			}
		}
		
		// answer == 각팀 능력치 차이 중 작은 값으로 계속 갱신
		answer = Math.min(answer, (int)Math.abs(teamOne-teamTwo));
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int INF = 20000001;
	static int N, M, answer;
	static int[][] computers;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		computers = new int[N+1][N+1];
		
        // 각 컴퓨터 간의 연결거리 무한대로 초기화
        // 자기 자신과 연결되는 경우는 없으므로 continue => 0
		for(int i=0; i<=N; i++) {
			for(int j=0; j<=N; j++) {
				if(i==j) continue;
				computers[i][j] = INF;
			}
		}
		
        // 각 컴퓨터 간의 연결거리 입력 받기
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			computers[start][end] = Math.min(computers[start][end], weight);
			computers[end][start] = Math.min(computers[end][start], weight);
		}
		
		// 플로이드 워셜 알고리즘
        // 컴퓨터 a와 b가 연결될 거리와 다른 컴퓨터 k 를 통해 a와 b가 연결될 거리 중 짧은 거리를 선택. 
		for(int k=1; k<=N; k++) {
			for(int a=1; a<=N; a++) {
				for(int b=1; b<=N; b++) {
					computers[a][b] = Math.min(computers[a][b], computers[a][k]+computers[k][b]);
				}
			}
		}
		
        // 각 컴퓨터 연결비용이 최소가 되는 시작 컴퓨터를 찾음.
        // 문제에서 평균비용이라 하였지만,
        // 결국 각 컴퓨터에서 다른컴퓨터까지의 거리의 합이 최소가 되는 경우를 찾는다.
		answer = 0;
		int sum = INF;
		for(int i=1; i<=N; i++) {
			int tmpSum = 0;
			for(int j=1; j<=N; j++) {
				tmpSum += computers[i][j];
			}
			if(tmpSum < sum) {
				answer = i;
				sum = tmpSum;
			}
		}
		
        // 정답 출력
		System.out.println(answer);

	}
}

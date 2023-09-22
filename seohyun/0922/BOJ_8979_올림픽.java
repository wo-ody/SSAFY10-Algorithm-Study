import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_8979_올림픽 {
	static int N,K;
	static int[][] graph;
	
	static int result = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		graph = new int[N][4];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		simulation();
	}
	
	static void simulation() {
		int gold = 0;
		int silver = 0;
		int bronze = 0;
		for (int i = 0; i < N; i++) {
			if(graph[i][0] == K) {
				gold = graph[i][1];
				silver = graph[i][2];
				bronze = graph[i][3];
			}
		}
		
		
		for (int i = 0; i < N; i++) {
			if(graph[i][0] == K) continue;
			//
			if(graph[i][1] > gold) result++;
			else if(graph[i][1] == gold && graph[i][2] > silver) result++;
			else if(graph[i][1] == gold && graph[i][2] == silver && graph[i][3] > bronze) result++;
		}
		
		System.out.println(result+1);
	}

}

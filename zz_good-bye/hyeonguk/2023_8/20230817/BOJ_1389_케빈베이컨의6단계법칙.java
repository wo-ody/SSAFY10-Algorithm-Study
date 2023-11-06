import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, min, answer;
	static int[] distance;
	static boolean[][] persons;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		persons = new boolean[N+1][N+1];
		distance = new int[N+1];
		min = Integer.MAX_VALUE;
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			persons[start][end] = persons[end][start] = true;
		}
		
		for(int i=N; i>0; i--) {
			bfs(i);
		}
		
		System.out.println(answer);
	}
	
	static void bfs(int x) {
		Queue<Integer> queue = new ArrayDeque<>();
		
        persons[x][0] = true;
		queue.offer(x);
		
		while(!queue.isEmpty()) {
			Integer v = queue.poll();
			
			for(int i=1; i<=N; i++) {
				if(!persons[i][0] && persons[v][i]) {
					persons[i][0] = true;
					distance[i] = distance[v]+1;
					queue.offer(i);
				}
			}
		}
		
		// answer 갱신
		int sum = 0;
		for(int i=1; i<=N; i++) {
			sum += distance[i];
		}
		if(sum <= min) {
			min = sum;
			answer = x;
		}
		
		// persons[i][0] 초기화
		for(int i=1; i<=N; i++) {
			persons[i][0] = false;
			distance[i] = 0;
		}
	}
}

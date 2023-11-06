import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, answer;
	static int[] visited = new int[101];
	static int[] board = new int[101];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<=100; i++) {
			board[i] = i;
		}
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			board[x] = y;
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			board[x]=y;
		}
		
		bfs(1);
		answer = visited[100];
		System.out.println(answer);
	}
	
	static void bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(start);
		
		while(!queue.isEmpty()) {
			int num = queue.poll();
			
			for(int i=1; i<=6; i++) {
				int next = num + i;
				
				if(next > 100) continue;
				
				if(visited[board[next]] == 0) {
					queue.offer(board[next]);
					visited[board[next]] = visited[num] + 1;
				}
				
				if(board[next] == 100) return;
			}
		}
	}
}

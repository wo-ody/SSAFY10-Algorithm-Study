import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final int length = 100_000;
	static int N, K, answer;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		visited = new boolean[length+1];
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		answer = Integer.MAX_VALUE;
		Queue<int[]> queue = new ArrayDeque<>();
		visited[N] = true;
		queue.offer(new int[] {N, 0});
		while(!queue.isEmpty()) {
			int[] items = queue.poll();
			int now = items[0];
			int cnt = items[1];
			
			if(now == K) {
				answer =  Math.min(answer, cnt);
			}
            
            if(now*2 <= length && !visited[now*2]) {
				visited[now*2] = true;
				queue.offer(new int[] {now*2, cnt});
			}
            
            if(now-1 >= 0 && !visited[now-1]) {
				visited[now-1] = true;
				queue.offer(new int[] {now-1, cnt+1});
			}
            
            if(now+1 <= length && !visited[now+1]) {
            	visited[now+1] = true;
            	queue.offer(new int[] {now+1, cnt+1});
            }	
		}
		
		System.out.println(answer);

	}
}

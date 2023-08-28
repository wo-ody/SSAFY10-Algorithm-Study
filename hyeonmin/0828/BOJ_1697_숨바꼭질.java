import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697_숨바꼭질 {

	static int N, K;
	static int[] check = new int[100001];
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if(N == K) System.out.println(0);
		else System.out.println( bfs(N) );
	}
	
	static int bfs(int depth) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(depth);
		check[depth] = 1;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for (int i = 0; i < 3; i++) {
				int next = cal(i, cur);
				if(next == K) return check[cur];
				if(next < 0 || next >= 100001) continue;
				if(check[next] != 0) continue;
				queue.offer(next);
				check[next] = check[cur]+1;
			}
		}
		return 0;
	}
	
	static int cal(int n, int x) {
		if(n == 0) return x+1;
		else if(n == 1) return x-1;
		else return x*2;
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static Deque<int[]> queue;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		
		queue = new ArrayDeque<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			queue.offer(new int[] {i, Integer.parseInt(st.nextToken())});
		}
		
		sb.append("1 ");
		
		int move = queue.poll()[1];
		
		while(!queue.isEmpty()) {
			if(move > 0) {
				for(int i=1; i<move; i++) {
					queue.offer(queue.poll());
				}
				int[] item = queue.poll();
				move = item[1];
				sb.append(item[0]+" ");
			}else {
				move = Math.abs(move);
				for(int i=1; i<move; i++) {
					queue.addFirst(queue.pollLast());
				}
				
				int[] item = queue.pollLast();
				move = item[1];
				sb.append(item[0]+" ");
			}
		}
		
		System.out.println(sb);
	}
}

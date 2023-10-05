import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1966_프린터큐 {
	
	static int T, N, M;
	
	static LinkedList<Docs> queue = new LinkedList<>(); 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		while(T-->0) {
			
			queue.clear();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int count = 0;
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int doc = Integer.parseInt(st.nextToken());
				queue.offer(new Docs(i,doc));
			}
			
			while(!queue.isEmpty()) {
				
				Docs d = queue.poll();
				boolean isPrint = true;
				
				for (int i = 0; i < queue.size(); i++) {
					if(d.seq < queue.get(i).seq) {
						queue.offer(d);
						// 순서 리셋
						for (int j = 0; j < i; j++) {
							queue.offer(queue.poll());
						}
						
						isPrint = false;
						break;
					}
				}
				
				if(!isPrint) continue;
				
				count++;
				if(d.num == M) {
					break;
				}
				
			}
			System.out.println(count);
			
		}
	}
	
	static class Docs {
		int num;
		int seq;
		
		public Docs(int num, int seq) {
			this.num = num;
			this.seq = seq;
		}
	}
}

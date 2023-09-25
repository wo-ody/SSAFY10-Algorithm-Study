import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, R;
	static int[] answer;
	static boolean[] visited;
	static PriorityQueue<Integer>[] list;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		answer = new int[N+1];
		visited = new boolean[N+1];
		
		list = new PriorityQueue[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new PriorityQueue<>((o1, o2) ->{return o2-o1;});
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list[start].add(end);
			list[end].add(start);
		}
		
		Queue<Integer> queue = new ArrayDeque<>();
		
		int cnt = 1;
		answer[R] = cnt++;
		visited[R] = true;
		queue.offer(R);
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			while(!list[now].isEmpty()){
				int next = list[now].poll();
				if(!visited[next]) {
					visited[next] = true;
					answer[next] = cnt++;
					queue.offer(next);
				}
			}
		}
		
		for(int i=1; i<=N; i++) {
			System.out.println(answer[i]);
		}
	}
}

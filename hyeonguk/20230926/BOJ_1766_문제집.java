import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] indegree;
	static List<Integer>[] list;
	static PriorityQueue<Integer> pq;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		indegree = new int[N+1];
		list = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int problemA = Integer.parseInt(st.nextToken());
			int problemB = Integer.parseInt(st.nextToken());
			list[problemA].add(problemB);
			indegree[problemB]++;
		}
		
		pq = new PriorityQueue<>((o1, o2)->{return o1-o2;});
		
		for(int i=1; i<=N; i++) {
			if(indegree[i]==0) pq.offer(i);
		}
		
		while(!pq.isEmpty()) {
			int now = pq.poll();
			sb.append(now).append(" ");
			
			int size = list[now].size();
			for(int i=0; i<size; i++) {
				int next = list[now].get(i);
				indegree[next]--;
				if(indegree[next]==0) {
					pq.add(next);
				}
			}
		}
		System.out.println(sb);
	}
}

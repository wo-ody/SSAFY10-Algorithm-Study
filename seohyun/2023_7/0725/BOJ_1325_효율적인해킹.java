import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1325_효율적인해킹 {
	static class Point {
		int cnt,index;
		Point(int cnt, int index){
			this.cnt = cnt;
			this.index = index;
		}
	}
	static int N,M;
	//static LinkedList<Integer>[] graph;
	static List<Integer>[] graph;
	static Queue<Point> result_arr = new PriorityQueue<>(new Comparator<Point>() {
		@Override
		public int compare(Point o1, Point o2) {
			if(o1.cnt == o2.cnt) return o1.index - o2.index;
			return o2.cnt - o1.cnt;
		}
	});
	
	public static void BFS(int start) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N];
		
		q.add(start);
		visited[start] = true;
		int cnt = 1;
		
		while(!q.isEmpty()) {
			int cx = q.poll();
			for(int nx : graph[cx]) {
				if(visited[nx]) continue;
				q.add(nx);
				visited[nx] = true;
				cnt += 1;
			}
		}
		
		result_arr.add(new Point(cnt,start+1));
		
	
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N];
		for (int i = 0; i < N; i++) graph[i] = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int to = Integer.parseInt(st.nextToken()) - 1;
			int from = Integer.parseInt(st.nextToken()) - 1;
			graph[from].add(to);
		}
		
		for(int i=0;i<N;i++) {
			BFS(i);
		}
		
		int result = result_arr.peek().cnt;
		while(!result_arr.isEmpty()) {
		
			Point p = result_arr.poll();
			if(p.cnt == result)
				System.out.printf(p.index + " ");
			else break;
		}
	}
	
	
	

}

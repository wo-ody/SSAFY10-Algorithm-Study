
import java.io.*;
import java.util.*;

public class swea_1238_contact {
	static int N,start;
	static ArrayList<Integer>[] graph = new ArrayList[110];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			for (int i = 0; i< 110; i++) graph[i] = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				graph[from].add(to);
			}
			
			System.out.println("#"+tc+" "+bfs());
		}

	}
	
	static int bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[110];
		int result = 0;
		
		q.add(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			ArrayList<Integer> depth = new ArrayList<>();
			for (int i = 0; i < size ; i++) {
				int num = q.poll();
				
				for (Integer nxt : graph[num]) {
					if(visited[nxt]) continue;
					q.add(nxt);
					visited[nxt] = true;
					depth.add(nxt);
				}
			}
			if(!depth.isEmpty()) {
				Collections.sort(depth);
				result = depth.get(depth.size() - 1); // 맨 뒤에것 가져오기
			}
		}
		
		return result;
	}

}

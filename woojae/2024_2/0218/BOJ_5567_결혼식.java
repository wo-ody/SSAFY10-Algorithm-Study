package practice.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_5567 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static int[] depth;
	static int answer = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		depth = new int[n+1];
		
		for (int i = 0; i < n+1; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);  // 양방향으로 구현하지 않으면 (1, 2), (3, 2)라는 입력에서 1, 3만 2와 친구라는 형태가 이상한 형태가 만족됨
			graph.get(b).add(a);
		}
		System.out.println(graph);
		bfs();
		for(int i = 2; i <= n; i++) {
			if(0 < depth[i] && depth[i] < 3)
				answer++;
		}
		System.out.println(answer);
	}
	
	static void bfs() {
		Queue<Integer> q = new ArrayDeque<Integer>();
		boolean[] visit = new boolean[n+1];
		q.add(1);
		visit[1] = true;
		
		while(!q.isEmpty()) {
			int node = q.poll();
			
			for (int i : graph.get(node)) {
				if(!visit[i]) {
					visit[i] = true;
					q.add(i);
					depth[i] = depth[node]+1;  // 1번 노드와 거리 계산
				}
			}
		}
	}
}

package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ_1058_친구 {
	static int N,ans;
	static char[][] adjArr;
	static boolean[] visit;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		adjArr = new char[N][N];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
			adjArr[i][j] = str.charAt(j);
			}
		}
		
		for(int i=0; i<N; i++) {
			visit = new boolean[N];
			int friend = bfs(i);
			ans = Math.max(ans, friend);
		}
		
		System.out.println(ans);

	}
	
	public static int bfs(int person) {
		Queue<Node> q = new ArrayDeque<>();
		visit[person] = true;
		q.add(new Node(person, 0));
		int cnt = 0;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			if(node.d >= 2) continue;
			
			for(int i=0; i<N; i++) {
				if(adjArr[node.n][i] == 'Y' && !visit[i]) {
					visit[i] = true;
					cnt++;
					q.add(new Node(i, node.d+1));
				}
			}
		}
		
		return cnt;
	}
	
	public static class Node{
		int n,d;
		public Node(int n, int d) {
			this.n = n;
			this.d = d;
		}
	}

}

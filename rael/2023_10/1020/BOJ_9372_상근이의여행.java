package Krusckal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9372_상근이의여행 {
	static int T, N, M;
	static int parent[];		//서로소
	static StringBuilder sb = new StringBuilder();
	
	static void makeSet() {
		for(int i=1; i<N; i++) {
			parent[i] = i;
		}
	}
	
	static int find(int x) {
		if(parent[x] == x) return x;
		else return parent[x] = find(parent[x]);
	}
	
	static boolean union(int x, int y) {
		int px = find(x);
		int py = find(y);
		
		//사이클 체크
		if(px == py) return false;
		
		if(px < py) parent[py] = px;
		else parent[px] = py;
		return true;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			//서로소 초기화
			parent = new int[N+1];
			makeSet();
			
			int cnt = 0;
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				
				if(union(v1, v2)) cnt++;
			}
			
			sb.append(cnt+"\n");
		}
		System.out.println(sb);
	}
}

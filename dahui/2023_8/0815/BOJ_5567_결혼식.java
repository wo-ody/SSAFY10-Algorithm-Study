package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_5567_결혼식 {
	static int N,M,ans;
	static boolean[] check; 
	static List<Integer>[] friend ; //양방향 인접리스
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		friend = new ArrayList[N+1];
		check = new boolean[N+1]; //상근이가 1
		for(int i=0; i<=N; i++) {
			friend[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			friend[a].add(b);
			friend[b].add(a);
		}
		
		check[1] = true; //상근이 
		dfs(1, 0);
		
		for(int i=2; i<check.length; i++) { //상근이 빼기 
			if(check[i]) ans++;
		}
		
		System.out.println(ans); 
	}
	
	static void dfs(int start, int depth) {
		//기저조건  
		if(depth == 2) {
			return;
		} //상근이0, 친구1, 친구2
		
		for(int i=0; i<friend[start].size(); i++) { //상근이의 친구들 
			check[friend[start].get(i)] = true; //해당 친구들 true
			dfs(friend[start].get(i), depth+1); //친구들의 리스트 돌기 
		}
	}

}

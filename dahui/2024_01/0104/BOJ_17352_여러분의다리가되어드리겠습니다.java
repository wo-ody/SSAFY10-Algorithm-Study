package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17352_여러분의다리가되어드리겠습니다 {
	static int N;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visit = new boolean[N+1];
		
		for(int i=0; i<=N; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i=0; i<N-2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			list.get(from).add(to);
			list.get(to).add(from);
		}
		if(N==2) sb.append("1 2");
		else {
			simulation();
			int where = 0;
			for(int i=1; i<=N; i++) {
				if(!visit[i]) {
					where = i;
					break;
				}
			}
			if(where == 1) {
				sb.append("1 2");
			}else {
				sb.append("1 ").append(where);
			}
			
		}
		
		System.out.println(sb);


	}
	
	public static void simulation() {
		Queue<Integer> q = new ArrayDeque<>();
		
		int idx = 1;
		while(true) {
			if(list.get(idx).size() != 0) {
				for(int i=0; i<list.get(idx).size(); i++) {
					visit[idx] = true;
					visit[list.get(idx).get(i)] = true;
					q.add(list.get(idx).get(i));
				}
				break;
			}
			idx++;
		}
		
		while(!q.isEmpty()) {
			int from = q.poll();
			
			for(int i=0; i<list.get(from).size(); i++) {
				int to = list.get(from).get(i);
				
				if(!visit[to]) {
					visit[to] = true;
					q.add(to);
				}
			}
		}
	}

}

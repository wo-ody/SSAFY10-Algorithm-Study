/*
 *	08.11 김창희
 *	BOJ_1766_문제집
 *
 *	[풀이]
 *  1. 위상정렬 + 우선순위 큐
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static List<List<Integer>> grpah =new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder answer = new StringBuilder();
		
		st =new StringTokenizer(br.readLine());
		int n =Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		for(int i =0; i<n+1; i++) grpah.add(new ArrayList<>());
		for(int i =0; i<m; i++) {
			st =new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			grpah.get(u).add(v);
		}
		
		int[] e= new int[n+1];
		
		for(int i =0; i<grpah.size(); i++) {
			for(int j : grpah.get(i)) e[j]++;
		}
		
		PriorityQueue<Integer> q= new PriorityQueue<>();
		for(int i =1; i<n+1; i++) {
			if(e[i]==0) {
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			int x = q.poll();
			answer.append(x).append(" ");
			for(int nx : grpah.get(x)) {
				e[nx]--;
				if(e[nx]==0)q.offer(nx);
			}
		}
		
		System.out.println(answer);
	}
}


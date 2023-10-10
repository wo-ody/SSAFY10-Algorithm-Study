package algorithm2023.oct.day09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1135_뉴스전하기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, cost[];
	static ArrayList<ArrayList<Integer>> graph;

	public static void main(String[] args) throws Exception {

		// 직원의 수 N
		N = Integer.parseInt(br.readLine());

		graph = new ArrayList<>();
		cost = new int[N];
		
		for(int i =0;i<=N;i++) {
			graph.add(new ArrayList<>());
		}
		

		st = new StringTokenizer(br.readLine());

		st.nextToken();

		for (int i = 1; i < N; i++) {
			int boss = Integer.parseInt(st.nextToken());
			graph.get(boss).add(i);
		}
		
		System.out.println(getMin(0));
		
		
		
	}
	
	static int getMin(int n) {
		int s = graph.get(n).size();
		int[] child = new int[s];
		int max = 0;
		int i =0;
		for(int next : graph.get(n)) {
			child[i++] = getMin(next);
		}
		
		Arrays.sort(child);
		for(i= 1;i<=s;i++) {
			max = Math.max(max, child[s-i]+i);
		}
		
		return max;
	}
}

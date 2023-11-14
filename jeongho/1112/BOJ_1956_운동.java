package algorithm2023.nov.day12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1956_운동 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	
	static int V, E, min=100_000_000;
	static boolean v[][];
	static int[][] graph;
	
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		graph = new int[V+1][V+1];
		for(int i = 1;i<=V;i++) {
			Arrays.fill(graph[i], 100_000_000);
		}
		
		for(int i = 0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			graph[s][e] = d;
		}
		
		for(int i = 1;i<=V;i++) {
			for(int j = 1;j<=V;j++) {
				for(int k = 1;k<=V;k++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j]);
				}
			}
		}
		
		for(int i =1;i<=V;i++) {
			min = Math.min(graph[i][i], min);
		}
		
		//최솟값 출력, 만약 아직  Integer.MAX_VALUE라면 -1 출력
		System.out.println(min==100_000_000?-1:min);
		
	}
	
}	

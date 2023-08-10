package algorithm2023.aug.day10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1766_문제집 {
	static int N, M, input[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		LinkedList<Integer>[] graph = new LinkedList[N];
		for(int i= 0;i<N;i++) {
			graph[i] = new LinkedList<>();
		}
		input = new int[N];
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i= 0;i<M;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			graph[a].add(b);
			input[b]++;
		}
		for(int i= 0;i<N;i++) {
			if(input[i]==0) {
				pq.add(i);
			}
		}
		for(int i=0;i<N;i++) {
			int cur= pq.poll();
			sb.append(cur+1).append(" ");
			for(int j : graph[cur]) {
				if(--input[j]==0)pq.offer(j);
			}
		}
		System.out.println(sb);
	}
}
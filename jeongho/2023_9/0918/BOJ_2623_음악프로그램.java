package algorithm2023.sep.day17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2623_음악프로그램 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	//가수의 수 N과 보조 PD의 수 M, 선행조건의 수를 나타내는 indegree배열
	static int N, M, indegree[];
	//가수들의 우선순위를 나타내는 order
	static ArrayList<ArrayList<Integer>> order = new ArrayList<>();
	
	
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		//가수가 N명이므로 N+1개의 arraylist를 만들어줌.
		for(int i =0 ;i<=N;i++) {
			order.add(new ArrayList<>());
		}
		//가수의 수 + 1 만큼 indegree 초기화
		indegree = new int[N+1];
		
		for(int i= 0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			//a가수 뒤에 b 가수가 오도록 하기 위해 a를 먼저 입력받고 반복
			int a = Integer.parseInt(st.nextToken());
			for(int j= 1;j<n;j++) {
				int b = Integer.parseInt(st.nextToken());
				order.get(a).add(b);
				indegree[b]++;
				//다음 순서를 위해 선행 가수를 갱신
				a = b;
			}
		}
		//위상 정렬을 위한 큐 생성
		ArrayDeque<Integer> q = new ArrayDeque<>();
		
		//선행 조건이 없는 가수를 먼저 큐에 삽입
		for(int i =1 ;i<=N;i++) {
			if(indegree[i]==0) {
				q.add(i);
			}
		}
		
		//답을 저장하기 위한 큐
		ArrayDeque<Integer> ans = new ArrayDeque<>();
		loop:
		while(!q.isEmpty()) {
			//큐를 돌면서 위상정렬.
			int cur = q.poll();
			ans.add(cur);
			for(int i =0;i<order.get(cur).size();i++) {
				int next = order.get(cur).get(i);
				indegree[next]--;
				if(indegree[next] == 0) {
					q.add(next);
				}
			}
		}
		
		//전체 가수가 모두 담겼다면 -> 순서를 정하는 것이 가능한 경우이므로 모두 출력
		if(ans.size()==N) {
			while(!ans.isEmpty()) {
				sb.append(ans.poll()).append("\n");
			}
		//아니라면 순서를 정할 수 없는 경우이므로 0 출력
		}else {
			sb.append("0");
		}
		System.out.println(sb);
	}
}

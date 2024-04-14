package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1005_ACM_Craft {
	// 테스트 케이스, 정점, 간선, 최종 목적지
	static int T, vertex, edge, dest;
	static int[] times, inDegrees, dp;
	static Queue<Integer> queue;
	static ArrayList<ArrayList<Integer>> lst;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t = 0; t < T; t++){
			st = new StringTokenizer(br.readLine());
			vertex = Integer.parseInt(st.nextToken());
			edge = Integer.parseInt(st.nextToken());
			times = new int[vertex+1];
			inDegrees = new int[vertex+1];
			dp = new int[vertex+1];

			lst = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for(int v = 1; v <= vertex; v++) times[v] = Integer.parseInt(st.nextToken());
			for(int v = 0; v <= vertex; v++) lst.add(new ArrayList<>());

			for(int e = 0; e < edge; e++){
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				lst.get(from).add(to);
				inDegrees[to]++;
			}
			dest = Integer.parseInt(br.readLine());
			topologySorting();
			System.out.println(dp[dest]);
		}
	}
	static void topologySorting(){
		queue  = new ArrayDeque<>();
		for(int v = 1; v <= vertex; v++) {
			if (inDegrees[v] == 0) {
				dp[v] = times[v];
				queue.add(v);
			}
		}
		while(!queue.isEmpty()){
			// 인접차수가 0인 정점
			int v = queue.poll();

			// elem은 v 정점에서 갈 수 있는 정점을 의미
			for(int elem: lst.get(v)) {
				// 이전에 들어온 값과 비교했을 때 들어온 값이 더 클때 변경해줌
				// 이전의 값이 모두 완료되어야 건설이 가능하기 때문
				dp[elem] = Math.max(dp[elem], dp[v] + times[elem]);
				inDegrees[elem] -= 1;
				if(inDegrees[elem] == 0) queue.add(elem);
			}
		}
	}
}

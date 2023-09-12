package practice.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2056 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static List<List<Integer>> graph = new ArrayList<List<Integer>>();
	static Queue<Integer> q = new ArrayDeque<Integer>();
	static int[] indgree;
	static int[] time_table;
	static int[] cost;
	static int time;
	static int work_num;
	static int answer = 0;
	static int current;
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		graph.add(new ArrayList<Integer>());
		indgree = new int[n + 1];
		time_table = new int[n + 1];
		for(int i = 1; i <= n; i++) {
			graph.add(new ArrayList<Integer>());
			st = new StringTokenizer(br.readLine());
			time = Integer.parseInt(st.nextToken());
			work_num = Integer.parseInt(st.nextToken());
			time_table[i] = time;
			for(int j = 0; j < work_num; j++) {
				current = Integer.parseInt(st.nextToken());
				graph.get(current).add(i);
				indgree[i]++;
			}
		}
		cost = time_table.clone();
		tp_sort();
		System.out.println(answer);
	}
	
	static void tp_sort() {
		for(int i = 1; i <= n; i++)
			if(indgree[i] == 0)
				q.offer(i);
		
		while(!q.isEmpty()) {
			current = q.poll();
			for (Integer next : graph.get(current)) {
				indgree[next]--;
				cost[next] = Integer.max(cost[next], time_table[next] + cost[current]);
				if(indgree[next] == 0) {
					q.offer(next);
				}
			}
		}
		
		for (int i : cost)
			answer = answer < i ? i : answer;
	}
}

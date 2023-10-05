package algorithm2023.sep.day15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2056_작업 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, time[], indegree[];
	static ArrayList<ArrayList<Integer>> prior = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		time = new int[N + 1];
		indegree = new int[N + 1];

		for(int i = 0;i<=N;i++) {
			prior.add(new ArrayList<>());
		}
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			time[i] = t;
			int n = Integer.parseInt(st.nextToken());
			indegree[i]=n;
			for (int j = 0; j < n; j++) {
				int cond = Integer.parseInt(st.nextToken());
				prior.get(cond).add(i);
			}
		}

		int sum = 0;

		ArrayDeque<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				q.add(i);
			}
		}
		
		int ans[] = new int[N+1];
		for(int i =1;i<=N;i++) {
			ans[i] = time[i];
		}
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int cur = q.poll();
				for(int j = 0;j<prior.get(cur).size();j++) {
					ans[prior.get(cur).get(j)] = Math.max(ans[prior.get(cur).get(j)], ans[cur]+time[prior.get(cur).get(j)]);
					if(--indegree[prior.get(cur).get(j)]==0) {
						q.add(prior.get(cur).get(j));
					}
				}
			}

		}
		System.out.println(Arrays.toString(ans));
		Arrays.sort(ans);
		System.out.println(ans[N]);
	}
}

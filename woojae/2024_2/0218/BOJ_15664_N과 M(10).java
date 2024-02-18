package practice.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_15664 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int n, m;
	static int[] arr, answer;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		answer = new int[m];
		visit = new boolean[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		dfs(0, 0);
		System.out.println(sb);
	}
	static void dfs(int start, int depth) {
		if(depth == m) {
			for (int i : answer)
				sb.append(i).append(" ");
			sb.append("\n");
			return;
		}
		int before = 0;
		for(int i = start; i < n; i++) {
			if(visit[i] || before == arr[i])  // 중복된 수 회피
				continue;
			visit[i] = true;
			before = arr[i];
			answer[depth] = arr[i];
			dfs(i+1, depth+1);
			visit[i] = false;
		}
	}
}

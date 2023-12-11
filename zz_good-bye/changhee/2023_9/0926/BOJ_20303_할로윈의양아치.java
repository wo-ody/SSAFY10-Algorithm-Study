
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		parent = new int[n + 1];
		int[] v = new int[n + 1];
		int[] w = new int[n + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n + 1; i++) {
			parent[i] = i;
			v[i] = Integer.parseInt(st.nextToken());
			w[i] = 1;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			union(x, y);
		}

		for (int i = 1; i < n + 1; i++) {
			if(i==parent[i]) continue;
			int p = findParent(i);
			v[p] += v[i];
			w[p] += w[i];
		}

		List<Node> unionList = new ArrayList<>();

		for (int i = 1; i < n + 1; i++) {
			if(i==parent[i]) unionList.add(new Node(v[i],w[i]));
		}

		long[][] dp = new long[unionList.size()+1][k];
		for (int i = 1; i < unionList.size()+1; i++) {
			long candy = unionList.get(i-1).v;
			int friend = unionList.get(i-1).w;

			for (int j = 0; j < k; j++) {
				if (j < friend) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - friend] + candy);
				}
			}
		}

		System.out.println(dp[unionList.size()][k - 1]);

	}

	public static void union(int x, int y) {
		x = findParent(x);
		y = findParent(y);

		if (x > y)
			parent[x] = y;
		if (x < y)
			parent[y] = x;
	}

	public static int findParent(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = findParent(parent[x]);
	}
	
	static class Node{
		long v;
		int w;
		public Node(long v, int w) {
			this.v = v;
			this.w = w;
		}
		
		
	}

}

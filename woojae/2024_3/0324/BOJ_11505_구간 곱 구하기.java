package practice.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11505 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int n, m, k;
	static int a, b;
	static long c;
	static long[] arr;
	static long[] seg_tree;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new long[n];
		seg_tree = new long[4*n];
		
		for(int i = 0; i < n; i++)
			arr[i] = Long.parseLong(br.readLine());

		build(1, 0, n-1);
		for(int i = 0; i < m+k; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Long.parseLong(st.nextToken());
			if(a == 1)
				update(1, 0, n-1, b-1, c);
			else
				sb.append(query(1, 0, n-1, b-1, c-1)).append("\n");
		}
		System.out.println(sb);
	}
	
	static void build(int node, int nodeLeft, int nodeRight) {
		if(nodeLeft == nodeRight) {
			seg_tree[node] = arr[nodeLeft];
			return;
		}
		
		int mid = (nodeLeft + nodeRight) / 2;
		build(node*2, nodeLeft, mid);
		build(node*2+1, mid+1, nodeRight);
		
		seg_tree[node] = (seg_tree[node*2] * seg_tree[node*2+1]) % 1000000007;
	}
	
	static long query(int node, int nodeLeft, int nodeRight, int queryLeft, long queryRight) {
		if(queryRight < nodeLeft || nodeRight < queryLeft)
			return 1;
		
		if(queryLeft <= nodeLeft && nodeRight <= queryRight)
			return seg_tree[node];
		
		int mid = (nodeLeft + nodeRight) / 2;
		long leftSum = query(node*2, nodeLeft, mid, queryLeft, queryRight);
		long rightSum = query(node*2+1, mid+1, nodeRight, queryLeft, queryRight);
		
		return (leftSum * rightSum) % 1000000007;
	}
	
	static void update(int node, int nodeLeft, int nodeRight, int queryIdx, long val) {
		if(queryIdx < nodeLeft || nodeRight < queryIdx)
			return;
		
		if(nodeLeft == nodeRight) {
			seg_tree[node] = val;
			return;
		}
		
		int mid = (nodeLeft + nodeRight) / 2;
		update(node*2, nodeLeft, mid, queryIdx, val);
		update(node*2+1, mid+1, nodeRight, queryIdx, val);
		
		seg_tree[node] = (seg_tree[node*2] * seg_tree[node*2+1]) % 1000000007;
	}

}

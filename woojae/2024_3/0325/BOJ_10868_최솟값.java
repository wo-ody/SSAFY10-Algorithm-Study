import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int n, m;
	static long a, b;
	static long[] arr;
	static long[] seg_tree;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new long[n];
		seg_tree = new long[4 * n];
		
		for(int i = 0; i < n; i++)
			arr[i] = Long.parseLong(br.readLine());
		
		build(1, 0, n-1);
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Long.parseLong(st.nextToken());
			b = Long.parseLong(st.nextToken());
			sb.append(query(1, 0, n-1, a-1, b-1)).append("\n");
		}
		System.out.println(sb);
	}
	
	static void build(int node, int left, int right) {
		if(left == right) {
			seg_tree[node] = arr[left];
			return;
		}
		
		int mid = (left + right) / 2;
		build(node*2, left, mid);
		build(node*2+1, mid+1, right);
		
		seg_tree[node] = Math.min(seg_tree[node*2], seg_tree[node*2+1]);
	}
	
	static long query(int node, int left, int right, long queryLeft, long queryRight) {
		if(queryRight < left || right < queryLeft)
			return Integer.MAX_VALUE;
		
		if(queryLeft <= left && right <= queryRight)
			return seg_tree[node];
		
		int mid = (left + right) / 2;
		long minLeft = query(node*2, left, mid, queryLeft, queryRight);
		long minRight = query(node*2+1, mid+1, right, queryLeft, queryRight);
		
		return Math.min(minLeft, minRight);
	}
}

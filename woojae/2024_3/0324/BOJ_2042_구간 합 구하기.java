import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int n, m, k;
	static int a, b;
	static long c;
	static long[] arr;
	static long[] segment_tree;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new long[n];
		segment_tree = new long[4*n];
		
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
	
	static void build(int node, int left, int right) {
		if(left==right) {
			segment_tree[node] = arr[left];
			return;
		}
		
		int mid = (left + right) / 2;
		build(node*2, left, mid);
		build(node*2+1, mid+1, right);
		
		segment_tree[node] = segment_tree[node*2] + segment_tree[node*2+1];
	}
	
	static long query(int node, int left, int right, int queryLeft, long queryRight) {
		if(queryRight < left || right < queryLeft)
			return 0; // 합에 대한 항등원
		
		if(queryLeft <= left && right <= queryRight)
			return segment_tree[node];
		
		int mid = (left + right) / 2;
		long leftSum = query(node*2, left, mid, queryLeft, queryRight);
		long rightSum = query(node*2+1, mid+1, right, queryLeft, queryRight);
		
		return leftSum + rightSum;
	}
	
	static void update(int node, int left, int right, int queryIdx, long value) {  // 사실상 build랑 동일
		if(queryIdx < left || right < queryIdx)
			return;
		
		if(left == right) {
			segment_tree[node] = value;
			return;
		}
		
		int mid = (left + right) / 2;
		update(node*2, left, mid, queryIdx, value);
		update(node*2+1, mid+1, right, queryIdx, value);
		
		segment_tree[node] = segment_tree[node*2] + segment_tree[node*2+1];
	}

}

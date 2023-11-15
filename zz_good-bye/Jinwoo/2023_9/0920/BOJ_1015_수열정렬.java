import java.io.*;
import java.util.*;
public class BOJ_1015_수열정렬 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Node[] arr = new Node[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) arr[i] = new Node(Integer.parseInt(st.nextToken()),i,0);
		Arrays.sort(arr,(n1, n2)->n1.val-n2.val);
		for (int i=0; i<n; i++) arr[i].sidx = i;
		Arrays.sort(arr,(n1, n2)->n1.fidx-n2.fidx);
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<n; i++) sb.append(arr[i].sidx).append(" ");
		System.out.println(sb);
	}

	static class Node {
		int val, fidx, sidx;
		public Node(int val, int fidx, int sidx) {
			this.val = val; this.fidx = fidx; this.sidx = sidx;
		}
	}
}

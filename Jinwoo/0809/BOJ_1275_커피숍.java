/*
seg tree 맵다.

*/
import java.io.*;
import java.util.*;
public class Main {
	static long[] tree;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		int n=Integer.parseInt(st[0]);
		int q=Integer.parseInt(st[1]);
		st = br.readLine().split(" ");
		arr = new int[n+1];
		for (int i=1;i<=n; i++) arr[i] = Integer.parseInt(st[i-1]);
		int h =(int) Math.ceil(Math.log(n)/Math.log(2));
		int size = 2<<h;
		tree = new long[size+1];
		init(1,1,n);
		StringBuilder sb = new StringBuilder();
		for (int ee=0; ee<q; ee++){
			st = br.readLine().split(" ");
			int a=Integer.parseInt(st[0]);
			int b=Integer.parseInt(st[1]);
			int t=Integer.parseInt(st[2]);
			int v=Integer.parseInt(st[3]);
			sb.append(query(1,1,n,Math.min(a,b),Math.max(a,b))).append("\n");
			update(1,1,n, t, v);
		}
		System.out.println(sb);
	}
	public static void init(int node, int s, int e){
		if (s==e) tree[node] = arr[s];
		else{
			init(node*2, s, (s+e)/2);
			init(node*2+1, (s+e)/2+1, e);
			tree[node] = tree[node*2]+tree[node*2+1];
		}
	}
	public static long query(int node, int s, int e, int l, int r){
		if (r<s || e<l) return 0;
		if (l<=s && e<=r) return tree[node];
		return query(node*2, s, (s+e)/2, l, r) + query(node*2+1, (s+e)/2+1,e,l,r);
	}
	
	public static void update(int node, int s, int e, int t, int v){
		if (t<s || e<t) return;
		if (s==t && e==t){tree[node]=v; return;}
		update(node*2, s, (s+e)/2, t, v);
		update(node*2+1, (s+e)/2+1, e, t, v);
		tree[node] = tree[node*2]+tree[node*2+1];
	}
}

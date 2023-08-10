/*
세그먼트 트리 실습하기 좋은 문제
query i, j에서 i<j가 보장되지 않음에 유의해야한다.
*/
import java.io.*;
import java.util.*;
public class Main {
	static long[] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		int n=Integer.parseInt(st[0]);
		int m=Integer.parseInt(st[1]);
		int h = (int) Math.ceil(Math.log(n)/Math.log(2));
		int size = (2<<h);
		tree = new long[size+1];
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<m; i++){
			st = br.readLine().split(" ");
			int a = Integer.parseInt(st[0]);
			int b = Integer.parseInt(st[1]);
			int c = Integer.parseInt(st[2]);
			if (a==0){
				sb.append(query(1,1,n,Math.min(b, c),Math.max(b, c))).append("\n");
			}else update(1,1,n,b,c);
		}
		System.out.println(sb);
	}
	
	public static void update(int node, int s, int e, int t, int v){
		if (e<t || t<s) return;
		if (s==e && s==t) {tree[node] = v; return;}
		update(node<<1, s, (s+e)>>1, t, v);
		update(node*2+1, (s+e)/2+1, e, t, v);
		tree[node] = tree[node<<1] + tree[node*2+1];
	}
	
	public static long query(int node, int s, int e, int l, int r){
		if (r<s || e<l) return 0;
		if (l<=s && e<=r) return tree[node];
		return query(node<<1, s, (s+e)>>1, l,r) + query(node*2+1, (s+e)/2+1, e, l, r);
	}
}

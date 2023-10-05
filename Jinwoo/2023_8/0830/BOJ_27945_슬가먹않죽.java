import java.io.*;
import java.util.*;
public class BOJ_27945_슬가먹않죽 {
	static int[] root;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] route = new int[n+1][2];
		
		int s, e, a, cnt=0;
		boolean flag = false;
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			if (flag) continue;
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			if (a>n) continue;
			route[a][0]=s; route[a][1]=e;
			cnt++;
			if (cnt==n) flag=true;
		}
		init(n);
		
		int x, y;
		for (int i=1; i<=n; i++) {
			x = route[i][0]; y = route[i][1];
			x = find(x); y = find(y);
			if (x==y) {System.out.println(i);break;}
			root[x] = y;
		}
	}

	static void init(int n) {
		root = new int[n+1];
		for (int i=1; i<=n; i++) root[i] = i;
	}
	static int find(int x) {
		return root[x]==x ? x:(root[x]=find(root[x]));
	}
}

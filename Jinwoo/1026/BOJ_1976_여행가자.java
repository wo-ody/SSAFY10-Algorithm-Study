import java.io.*;
import java.util.*;

public class Main {
	static int[] root;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[][] g = new int[n][n];
		root = new int[n];
		for (int i=0; i<n; i++) root[i] = i;
		
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<n; j++) g[i][j] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine()); // 입력
		
		int a, b;
		for (int i=0; i<n; i++) {
			for (int j=i+1; j<n; j++) {
				if (g[i][j]==1) {
					a = find(i); b = find(j);
					if (a==b) continue;
					root[b] = a;
				}
			}
		}
		String ans = "YES";
		int t = find(Integer.parseInt(st.nextToken())-1);
		for (int i=1; i<m; i++) {
			if (t != find(Integer.parseInt(st.nextToken())-1)) {
				ans = "NO";
				break;
			}
		}
		System.out.println(ans);
	}
	
	static int find(int x) {
		return x==root[x] ? x:(root[x]=find(root[x]));
	}
}

import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1];
		for (int i=1; i<=n; i++) arr[i] = i;
		
		int c, a, b;
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			c = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			if (c==0) {
				a = find(a); b= find(b);
				if (a<b) arr[b] = a;
				else arr[a] = b;
			}else {
				if (find(a)==find(b)) sb.append("YES").append("\n");
				else sb.append("NO").append("\n");
			}
		}
		System.out.println(sb);
	}
	
	static int find(int x) {
		return arr[x]==x? x:(arr[x]=find(arr[x]));
	}
}

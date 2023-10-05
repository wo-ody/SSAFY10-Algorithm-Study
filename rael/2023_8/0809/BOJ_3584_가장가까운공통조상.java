package BOJ3584;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int T, N;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t=0; t<T; t++) {
			N = Integer.parseInt(br.readLine());
			int[] parent = new int[N+1];
			
			for(int i=1; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				
				parent[b] = a;
			}
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			
			boolean[] isParent = new boolean[N+1];
			while(a!=0) {
				isParent[a] = true;
				a = parent[a];
			}
			
			while(true) {
				if(isParent[b]) {
					sb.append(b).append("\n");
					break;
				}
				
				b = parent[b];
			}
		}
		System.out.println(sb.toString().trim());
	}
}

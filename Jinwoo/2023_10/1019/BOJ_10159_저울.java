import java.util.*;
import java.io.*;
public class BOJ_10159_저울{
	static char[][] map;
	static boolean[][][] check = new boolean[9][9][10];
	static Deque<int[]> stack = new ArrayDeque<>();
	static boolean flag;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int s, e;
		boolean map[][] = new boolean[n+1][n+1];
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			map[s][e] = true;
		}
		
		for (int b=1; b<=n; b++) {
			for (int a=1; a<=n; a++) {
				if (a==b || !map[a][b]) continue;
				for (int c=1; c<=n; c++) {
					if (a==c || b==c || !map[b][c]) continue;
					map[a][c] = true;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		int ans;
		for (int i=1; i<=n; i++) {
			ans=-1;
			for (int j=1; j<=n; j++) {if (!map[i][j] && !map[j][i]) ans++;}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}//main
}

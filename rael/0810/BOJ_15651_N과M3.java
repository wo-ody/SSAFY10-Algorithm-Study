import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class BOJ_15651_N과M3 {
	
	public static int[] num;
	public static int N, M;
	public static StringBuilder sb = new StringBuilder();
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		StringTokenizer st = new StringTokenizer(br.readLine());
 
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
 
		num = new int[M];
		dfs(0);
		System.out.println(sb);
	}
 
	public static void dfs(int depth) {
 
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(num[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
 
		for (int i = 1; i <= N; i++) {
			num[depth] = i;
			dfs(depth + 1);
		}
	}
 
}
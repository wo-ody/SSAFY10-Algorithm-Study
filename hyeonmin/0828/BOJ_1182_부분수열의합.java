import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1182_부분수열의합 {

	static int N, S, count; // n은 양수이며 11보다 작다.
	
	static int[] src, tgt;
	static boolean[] select;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		src = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			src[i] = Integer.parseInt(st.nextToken());
		}
		dfs(0,0);
		if(S == 0) count-=1;
		System.out.println(count);
	}
	static void dfs(int depth, int sum) {
		if(depth == N) {
			if(sum == S) count++;
			return;
		}
		
		dfs(depth+1, sum+src[depth]);
		dfs(depth+1, sum);
	}

}

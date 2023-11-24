import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10974_모든순열 {

	static int N;
	static int[] src;
	static int[] tgt;
	static boolean[] select;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		src = new int[N];
		tgt = new int[N];
		select = new boolean[N];

		for (int i = 0; i < N; i++) {
			src[i] = i+1;
		}
		
		perm(0);
		System.out.println(sb);
	}
	
	static void perm(int cnt) {
		if(cnt == N) {
			for (int i = 0; i < tgt.length; i++) {
				sb.append(src[tgt[i]]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(select[i]) continue;
			tgt[cnt] = i;
			select[i] = true;
			perm(cnt+1);
			select[i] = false;
		}
		
	}

}

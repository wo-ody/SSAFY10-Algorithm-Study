import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14889_스타트와링크 {
	
	static int N, ans;
	static int[][] map;
	static boolean[] select;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		select = new boolean[N];
		ans = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		comb(0, 0);
		System.out.println(ans);
	}
	
	static void comb(int idx, int cnt) {
		if(cnt == N/2) {
			go();
			return;
		}
		
		for (int i = idx; i < N; i++) {
			if(select[i]) continue;
			select[i] = true;
			comb(i+1, cnt+1);
			select[i] = false;
		}
	}
	
	static void go() {
		int a = 0;
		int b = 0;
		
		for (int i = 0; i < N - 1; i++) {
			for (int j = i+1; j < N; j++) {
				if( select[i] && select[j] ) {
					a += map[i][j] + map[j][i];
				} else if( !select[i] && !select[j] ) {
					b += map[i][j] + map[j][i];
				}
			}
		}
		int diff = Math.abs(a-b);
		if(diff == 0) {
			System.out.println(diff);
			System.exit(0);
		}
		ans = Math.min(diff, ans);
	}
}

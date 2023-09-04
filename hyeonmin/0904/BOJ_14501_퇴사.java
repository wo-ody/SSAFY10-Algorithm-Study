import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14501_퇴사 {

	static int N, ans;
	static int[][] table;
	static int[] src;
	static boolean[] select;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ans = Integer.MIN_VALUE;
		StringTokenizer st;
		table = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			table[i][0] = Integer.parseInt(st.nextToken());
			table[i][1] = Integer.parseInt(st.nextToken());
		}
		
		src = new int[N];
		select = new boolean[N];
		
		subset(0);
		System.out.println(ans);
		
	}
	
	static void subset(int cnt) {
		if(cnt == N) {
			for (int i = 0; i < N; i++) {
				// 뽑힌 원소들을 모두 확인한다.
				if(!select[i]) continue;
				// 가능한 조합인지 확인한다 : 걸리는 기간 T 확인해보기
				int t = table[i][0];
				for (int j = 1; j < t; j++) {
					// 날이 겹치거나, N일 이후에 상담을 계속 해야하면 return
					if(i+j >= N) return;
					if(select[i+j]) return;
				}
			}
			
			// 가능한 조합이면 다시 돌면서 합을 구해본다.
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if(!select[i]) continue;
				sum += table[i][1];
			}
			// 최댓값을 구한다
			ans = Math.max(sum, ans);
			return;
		}
		
		select[cnt] = true;
		subset(cnt+1);
		select[cnt] = false;
		subset(cnt+1);
	}

}

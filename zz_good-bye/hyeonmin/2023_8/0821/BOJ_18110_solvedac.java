import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_18110_solvedac {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		// 위 아래 15% 제외
		int trim = (int) Math.round( (double) n * (double) 3 / (double) 20 );
		int[] score = new int[n];
		int ans = 0;
		
		
		for (int i = 0; i < n; i++) {
			score[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(score);
		for (int i = trim; i < n-trim; i++) {
			ans += score[i];
		}
		ans = (int) Math.round( (double) ans / ( n - (double) trim * 2.0 ) );
		System.out.println(ans);
		
	}

}

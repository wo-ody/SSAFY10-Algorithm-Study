package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1065_한수 {
	
	static int N, ans;
	static int[] numbers;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		numbers= new int[3];
		ans = 0;
		
		for (int i = 1; i <= N; i++) {
			Arrays.fill(numbers, 0);
			int n = i;
			
			
			// 100보다 작으면 무조건 count
			if(n < 100) {
				ans++;
				continue;
			}
			
			// 100부터 각 자릿수 배열에 저장
			for (int j = 0; j < 3; j++) {
				numbers[j] = n%10;
				if(n < 10) break;
				n/=10;
			}
			
			
			if(numbers[1] - numbers[0] == numbers[2] - numbers[1]) {
				ans++;
			}
			
		}
		if(N == 1000) ans--;
		System.out.println(ans);
		
	}
}

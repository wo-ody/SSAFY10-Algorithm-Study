import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] str1 = br.readLine().toCharArray();
		char[] str2 = br.readLine().toCharArray();
		
		int length_1 = str1.length;
		int length_2 = str2.length;
		
		// 공집합 표현을 위해 인덱스가 한 줄씩 추가 됨 
		int[][] dp = new int[length_1 + 1][length_2 + 1];
		
		// 1부터 시작 (index 0 은 공집합이므로 0의 값을 갖고있음) 
		for(int i = 1; i <= length_1; i++) {
			for(int j = 1; j <= length_2; j++) {
				
				// (i-1)과 (j-1) 번째 문자가 서로 같다면  
				if(str1[i - 1] == str2[j - 1]) {
					// 대각선 위 (i-1, j-1)의 dp에 +1 한 값으로 갱신 
					dp[i][j] = dp[i - 1][j - 1] + 1;	
				}
				
				// 같지 않다면 이전 열(i-1)과 이전 행(j-1)의 값 중 큰 것으로 갱신  
				else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		System.out.println(dp[length_1][length_2]);
		
	}
 
}

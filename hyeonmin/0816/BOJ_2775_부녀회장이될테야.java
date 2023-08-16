import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2775_부녀회장이될테야 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		/*
		 * a층의 b호에 살려면 a-1층의 1~b 까지 사람들의 수의 합 만큼 데려와 살아야 한다.
		 * 0층 i호 에는 i명이 산다.
		 * 0/1-> 1명
		 * 0/2-> 2명
		 * 0/3-> 3명
		 * 0/4-> 4명
		 * 
		 * 1/1-> 0/1-> 1명
		 * 1/2-> 0/1+0/2-> 3명
		 * 1/3-> 0/1+0/2+0/3-> 6명
		 * 1/4-> 
		 * 
		 * k층 n호에는 몇명이 사는가?
		 * 
		 * 1 2 3 4 5
		 * 1 3 6 10 15
		 * 1 4 
		 * 1    2   S[i-1]+A[i]     4
		 * A1   A2     A3    A4
		 * s0+a1  s1+a2  s2+a3
		 */
		
		for (int i = 0; i < T; i++) {
			int k  = Integer.parseInt(br.readLine());
			int n  = Integer.parseInt(br.readLine());
			int answer = 0;
			int[] A = new int[n+1];
			int[] S = new int[n+1];
			for (int j = 1; j <= n; j++) {
				A[j] = j;
			}
			for (int j = 1; j <= k; j++) {
				for (int j2 = 1; j2 <= n; j2++) {
					A[j2] += A[j2-1];
				}
			}
			System.out.println(A[n]);
			
		}
	}

}

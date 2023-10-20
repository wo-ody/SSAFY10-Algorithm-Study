package report;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11054_가장긴바이토닉부분수열 {
	static int N, max;
	static int[] input;
	static int[] dpUp, dpDown,dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		dpUp = new int[N]; // 각 수까지의 가장 긴 증하는 부분수열의 길이를 담음 
		dpDown = new int[N]; // 뒤에서부터 가장 긴 증가하는 부분수열의 길이를 담음 
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
			dpUp[i] = 1;  
			dpDown[i] = 1;  
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<i; j++) {
				if(input[j] < input[i] && dpUp[j] + 1 > dpUp[i]) {
					dpUp[i] = dpUp[j] + 1;
				}
			}
		}
		
		for(int i=N-1; i>=0; i--) {
			for(int j=N-1; j>i; j--) {
				if(input[j] < input[i] && dpDown[j] + 1 > dpDown[i]) {
					dpDown[i] = dpDown[j] + 1;
				}
			}
		}
		
		for(int i = 0; i<N; i++) {
			max = Math.max(dpUp[i]+dpDown[i], max);
		}
		
		
		System.out.println(max-1);
	}

}

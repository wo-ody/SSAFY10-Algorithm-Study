import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		

		int n = Integer.parseInt( bf.readLine() ); // 테스트 케이스 수
		int[] cnt_fibo_1 = new int[41]; // i가 1을 몇 번 호출하는지 저장할 함수
		int[] cnt_fibo_0 = new int[41]; // i가 0을 몇 번 호출하는지 저장할 함수
		
		cnt_fibo_1[0] = 0;
		cnt_fibo_1[1] = 1;
		
		cnt_fibo_0[0] = 1;
		cnt_fibo_0[1] = 0;
		// 초기값 저장, 0은 0이 1개 1이 0개이고, 1은 0이 0개 1이 1개.
    
		for(int i = 2; i <= 40; i++) { // 2부터 40까지 미리 계산하기
			cnt_fibo_1[i] = cnt_fibo_1[i-1] + cnt_fibo_1[i-2]; 
            // i번째의 1 호출 횟수 = i-1의 1 호출 횟수 + i-2의 1 호출 횟수
			cnt_fibo_0[i] = cnt_fibo_0[i-1] + cnt_fibo_0[i-2]; 
            // i번째의 0 호출 횟수 = i-1의 0 호출 횟수 + i-2의 0 호출 횟수
		}
		
		for(int t = 0; t < n; t++) {
			int temp = Integer.parseInt( bf.readLine() ); // n번째 피보나치 수
			bw.write(cnt_fibo_0[temp] + " " + cnt_fibo_1[temp] + "\n"); 
            // 0의 호출 횟수, 1의 호출 횟수 순으로 출력
		}
		
		bw.flush();
		bw.close();

	}
}

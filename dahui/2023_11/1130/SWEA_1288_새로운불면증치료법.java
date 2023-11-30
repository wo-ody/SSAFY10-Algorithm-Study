package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_1288_새로운불면증치료법 {
	static int T,N,ans;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static final int S = (int) (Math.pow(2,10)-1);
	public static void main(String[] args) throws Exception{
		T = Integer.parseInt(br.readLine());

		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			ans = 0;
			int num = 0;
			
			while(true) {
				if(num == S) break; 
				
				ans++; //개수 올리기
				int test = N*ans;
				
				while(test>0) {
					num = (1<<(test%10))|num; //각 자리수를 or 연산으로 num에 체크
					test /= 10;
				}
			}
			
			sb.append("#").append(t).append(" ").append(N*ans).append("\n");
		}

		System.out.println(sb);
	}

}

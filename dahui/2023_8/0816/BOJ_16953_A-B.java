package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16953_A화살표B {
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		cnt = 1;
		simulation(a,b);
		System.out.println(cnt);
	}
	static void simulation(int a, int b) {
		
		while(b != a) {
			if(b < a) {
				cnt = -1;
				return;
			}
			
			if(b % 2 != 0 && (b-1)%10 != 0) {
				cnt = -1;
				return;
			}
			
			if(b % 2 == 0) {
				b /= 2;
			}else {
				b = (b-1)/10;
			}
			
			cnt++;
		}
		
	}
}

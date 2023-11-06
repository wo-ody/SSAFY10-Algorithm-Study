package bj.S5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1094_막대기 {
	static int X;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		X = Integer.parseInt(br.readLine());
		
		int stick = 64;
		int cnt = 0;
		
		while (X > 0) {
			if (stick > X) {
				stick /= 2;
			} else {
				cnt++;
				X -= stick;
			}
		}
		
		System.out.println(cnt);
		
	}
}

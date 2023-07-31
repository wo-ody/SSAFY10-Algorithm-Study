package swea;

import java.util.Scanner;

public class SWEA_1289_원재의_메모리_복구하기{
	// 0과 1이 얼마나 반복되어있는가를 물어보는 문제
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int i = 1 ; i <= T ; i ++) {
			String s = sc.next();
			boolean flag = false; // false == 0, true == 1
			int cnt = 0;
			for (int j = 0 ; j < s.length(); j ++) {
				if (flag == false && s.charAt(j) == '0' || flag == true && s.charAt(j) == '1') {
					continue;
				}
				else {
					flag = !flag;
					cnt += 1;
				}
			}
			System.out.println("#"+i+ " "+cnt);
		}
	
	}
}

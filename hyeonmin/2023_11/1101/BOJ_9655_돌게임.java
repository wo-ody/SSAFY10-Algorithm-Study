package month11.day01;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9655_돌게임 {

	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		/*
		 * 게임을 이기기 위해서는 상대방이 1개 또는 3개를 남길 수밖에 없게 만들면 된다.
		 * 5
		 * 상근 1개 > 4
		 * 창영 1개 > 3
		 * 상근 3개 끝
		 * 
		 * 7
		 * 상근 1개 > 6개
		 * 창영 3개 > 3개
		 * 창영 1개 > 6개
		 * 
		 */
		
		// 홀수이면 무조건 상근이가 이긴다.
		// 짝수이면 무조건 창영이가 이긴다.
		if(N%2 == 0) System.out.println("CY");
		else System.out.println("SK");
		
	}

}

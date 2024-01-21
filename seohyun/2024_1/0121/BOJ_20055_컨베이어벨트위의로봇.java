package 구현;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] belt = new int[N*2];
		boolean[] robot = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N*2; i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		}
		
		int level = 0;
		
		while(true) {
			level++;
			
			// 1단계
			int tmp = belt[N*2-1];
			for (int i = N*2-1; i > 0; i--) {
				belt[i] = belt[i-1];
			}
			belt[0] = tmp;

			for (int i = N-1; i > 0; i--) {
				robot[i] = robot[i-1];
			}
			
			robot[0] = false;
			robot[N-1] = false;
			
			// 2단계
			for (int i = N-1; i > 0; i--) {
				if(robot[i-1] && !robot[i] && belt[i]>0) {
					robot[i-1] = false;
					robot[i] = true;
					belt[i]--;
					robot[N-1] = false;
				}
			}
			
			// 3단계
			if(belt[0]>0) {
				robot[0] = true;
				belt[0]--;
			}
			
			// 4단계
			int cnt = 0;
			for (int i = 0; i < N*2; i++) {
				if(belt[i] == 0) cnt++;
			}
			if(cnt>=K) break;

		}
		
		System.out.println(level);
	}
	
}

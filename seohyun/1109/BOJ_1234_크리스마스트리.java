package BOJ;

import java.io.*;
import java.util.*;

public class boj_1234_크리스마스트리 {
	static int N;
	static int[] color = new int[3];
	static int[] fac = new int[11];
	
	static long result;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		for (int i = 0; i < 3; i++) {
			color[i] = Integer.parseInt(st.nextToken());
		}
		
		// 
		simulation();
	}
	
	static void cal_fac() {
		fac[0] = 1;
		for (int i = 1; i <= 10; i++) {
			fac[i] = fac[i-1] * i;
		}
	}
	
	
	static void dfs(int level, long sum) {
		if(level == N + 1) {
			result += sum;
			return;
		}
		
		
		
		for (int c = 1; c <= level; c++) { // 갯수
			int bundle = level / c; // 몇묶음
			int remainder = level % c;
			if(remainder != 0) continue;
			// 1묵음일때 
			if(bundle == 1) {
				for (int i = 0; i < 3; i++) {
					if(color[i] >= c) {
						color[i] -= c;
						dfs(level + 1, sum);
						color[i] += c;
					}
				}
			}
			// 2묶음
			if(bundle == 2) {
				for (int i = 0; i < 3; i++) {
					for (int j = i + 1; j < 3; j++) {
						if(color[i] >= c && color[j] >= c) {
							color[i] -= c;
							color[j] -= c;
							dfs(level + 1,  (long) (sum * (fac[level] / Math.pow(fac[c] ,bundle))));
							color[i] += c;
							color[j] += c;
						}
					}
				}
			}
			
			// 3묶음
			if(bundle == 3) {
				if(color[0] >= c && color[1] >= c && color[2] >= c) {
					color[0] -= c;
					color[1] -= c;
					color[2] -= c;
					dfs(level + 1,  (long) (sum * (fac[level] / Math.pow(fac[c] ,bundle))));
					color[0] += c;
					color[1] += c;
					color[2] += c;
				}
			}
			
		}
		
	}
	
	static void simulation() {
		// 팩토리얼 계산
		cal_fac();
		
		// dfs 
		dfs(1,1);
		
		if(N == 0) System.out.println(0);
		else System.out.println(result);
	}
	


}

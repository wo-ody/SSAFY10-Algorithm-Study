package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2096_내려가기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[][] origin = new int[T][3];
		int[][] dpMin = new int[T][3];
		int[][] dpMax = new int[T][3];
		
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			origin[t][0] = a;
			origin[t][1] = b;
			origin[t][2] = c;
		}
		dpMax[0][0] = origin[0][0];
		dpMax[0][1] = origin[0][1];
		dpMax[0][2] = origin[0][2];
		
		dpMin[0][0] = origin[0][0];
		dpMin[0][1] = origin[0][1];
		dpMin[0][2] = origin[0][2];
		
		for(int t = 1; t < T; t++) {
			// 최소값 dp
			dpMin[t][0] = Math.min(dpMin[t-1][0] + origin[t][0], dpMin[t-1][1] + origin[t][0]);
			dpMin[t][1] = Math.min( 
					Math.min(dpMin[t-1][0] + origin[t][1], dpMin[t-1][1] + origin[t][1])
					,Math.min(dpMin[t-1][1] + origin[t][1], dpMin[t-1][2] + origin[t][1])
					);
			dpMin[t][2] = Math.min(dpMin[t-1][1] + origin[t][2], dpMin[t-1][2] + origin[t][2]);	
			
			
			// 최대값 dp
			dpMax[t][0] = Math.max(dpMax[t-1][0] + origin[t][0], dpMax[t-1][1] + origin[t][0]);
			dpMax[t][1] = Math.max( 
					Math.max(dpMax[t-1][0] + origin[t][1], dpMax[t-1][1] + origin[t][1])
					,Math.max(dpMax[t-1][1] + origin[t][1], dpMax[t-1][2] + origin[t][1])
					);
			dpMax[t][2] = Math.max(dpMax[t-1][1] + origin[t][2], dpMax[t-1][2] + origin[t][2]);
		}
		int MIN = Integer.MAX_VALUE;
		int MAX = Integer.MIN_VALUE;
		
		for(int i = 0; i < 3; i++) {
			MIN = Math.min(dpMin[T-1][i], MIN);
			MAX = Math.max(dpMax[T-1][i], MAX);
		}
		System.out.println(MAX + " " + MIN);
	}

}

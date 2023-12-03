package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2890_카약 {
	static int R,C;
	static int[] idx = new int[10]; //각 카약이 시작된 index 클수록 결승선에 가까움
	static Integer[] sortIdx = new Integer[10];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				char c = str.charAt(j);
				if(Character.isDigit(c)) { //숫자라면
					idx[c-'0'] = j; //카약이 시작된 인덱스 저장하기 
					sortIdx[c-'0'] = j;
					break;
				}
			}
		}
		
		sortIdx[0] = 0;
		
		//내림차순 정렬 
		Arrays.sort(sortIdx, Collections.reverseOrder());
		
		int[] rank = new int[10];
		
		int r = 1;
		int Index = sortIdx[0];
		
		for(int i=0; i<10; i++) {
			if(Index == sortIdx[i]) {
				for(int j=0; j<10; j++) {
					if(idx[j] == sortIdx[i]) {
						rank[j] = r;
					}
				}
			}else {
				r++;
				Index = sortIdx[i];
				for(int j=0; j<10; j++) {
					if(idx[j] == sortIdx[i]) {
						rank[j] = r;
					}
				}
			}
		}
		
		for(int i=1; i<10; i++) {
			sb.append(rank[i]).append("\n");
		}
		
		
		
		System.out.println(sb);
	}
	

}

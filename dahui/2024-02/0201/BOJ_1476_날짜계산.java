package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1476_날짜계산 {
	static int E,S,M,day;
	static final int e = 15;
	static final int s = 28;
	static final int m = 19;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		E = Integer.parseInt(st.nextToken())-1;
		S = Integer.parseInt(st.nextToken())-1;
		M = Integer.parseInt(st.nextToken())-1;
	
		day = 0;
		while(true) {
			if(day % e == E && day % s == S && day % m == M) break;
			day++; 
		}
		
		System.out.println(day+1);
	}

}

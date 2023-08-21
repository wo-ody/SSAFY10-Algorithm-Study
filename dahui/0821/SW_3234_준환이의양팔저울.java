package test;

import java.io.*;
import java.util.*;

public class SW_3234_준환이의양팔저울 {
	static int N, ans;
	static int[] weight;
	static int[] tgt;
	static boolean[] select;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1 ; t<=T ; t++) {
			N = Integer.parseInt(br.readLine());
			
			weight = new int[N];
			tgt = new int[N];
			select = new boolean[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i =0 ; i < N ; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
			}
			
			ans = 0;
			
			perm(0);
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
	
	//순서 정하기  -> 순열
	static void perm(int cnt) {
		if(cnt == N) {		//기저조건
			sub(0,0,0);//다 정해지고 나면 왼쪽 오른쪽 부분집합 돌리기  
		}
		//순열 만들기
		for(int i = 0 ; i < N ; i++) {
			if(select[i]) continue;
			
			tgt[cnt] = weight[i];	
			
			select[i] = true;	
			perm(cnt+1);	
			select[i] = false;
		}
	}
	
	//양팔 저울 왼쪽 오른쪽 정하기 , 각 추를 왼쪽에 몇 개를 두는가 -> 부분집합  
	static void sub(int cnt, int left, int right) { //추 수/ 왼쪽 무게/ 오른쪽 무게 
		if(left<right) return; //왼쪽보다 오른쪽이  더 클 경우  
		
		//기저조건 - N개를 다 올렸을 때  
		if(cnt == N) {		
			ans++;		//경우의 수 증가
			return;
		}
		sub(cnt+1, left, right+tgt[cnt]);		//오른쪽에 두기, 무게 더해주기 
		sub(cnt+1, left+tgt[cnt], right);		//왼쪽에 두기 
	}
}

package baekjoon.Advanced;

import java.util.*;
import java.io.*;

public class BOJ_16987_계란으로_계란치기 {
	static StringBuilder sb = new StringBuilder();
	static Egg[] eggs;
	static int MAX = Integer.MIN_VALUE, T;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		eggs = new Egg[T];
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int durability = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			// 각 계란의 내구도는 상대 계란의 무게만큼 깎인다.
			eggs[t] = new Egg(durability, weight);			
		}
		breakEgg(eggs, 0, 0);
		System.out.println(MAX);
	}
	static void breakEgg(Egg[] breaks, int start, int cnt) {
		if(cnt == T - 1 ) {
			MAX = Math.max(countZero(breaks), MAX);
			return;
		}
		
		for(int i = start; i < T; i++) {
			if( i == cnt || breaks[i].durability <= 0) continue;
			breaks[cnt].durability -= breaks[i].weight;
			breaks[i].durability -= breaks[cnt].weight;
			if(breaks[cnt].durability <= 0) cnt++;
			if(breaks[i].durability <= 0) cnt++;
			
			breakEgg(breaks, start + 1, cnt);
			
			breaks[cnt].durability += breaks[i].weight;
			breaks[i].durability += breaks[cnt].weight;
		}
	}
	static int countZero(Egg[] eggs) {
		int result = 0;
		for(int i = 0; i < eggs.length; i++) if(eggs[i].durability <= 0) result++; 
		return result;
	}
	static class Egg{
		int durability, weight;

		public Egg(int durability, int weight) {
			super();
			this.durability = durability;
			this.weight = weight;
		}

	}
}

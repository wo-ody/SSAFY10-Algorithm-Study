package algorithm2023.nov.day10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_18110_솔브닥 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int n, opinion[], cut;
	
	public static void main(String[] args) throws Exception{
		n = Integer.parseInt(br.readLine());
		opinion = new int[n];
		
		cut = (int)Math.round((double)n*0.15);
		System.out.println(cut);
		
		for(int i =0;i<n;i++) {
			opinion[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(opinion);
		
		int sum = 0;
		for(int i = cut;i<n-cut;i++) {
			sum+=opinion[i];
		}
		int ans = (int)Math.round((double)sum/(n-cut*2));
		System.out.println(ans);
	}
}	

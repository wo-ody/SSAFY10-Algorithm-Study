package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class BOJ_5568_카드놓기 {

	static int n,k;
	static int[] card,arr;
	static boolean[] visit;
	static HashSet<String> set=new HashSet<>(); 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		card = new int[n];
		visit = new boolean[n];
		arr = new int[n];
		
		for(int i=0;i<n;i++) {
			card[i] = Integer.parseInt(br.readLine());
		}
		
		dfs(0);
		System.out.println(set.size()); 
	}
	
	static void dfs(int depth) {
		if(depth==k) {
			String str="";
			for(int i=0;i<arr.length;i++)
				str+=arr[i];
			
			set.add(str);
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(visit[i]==false) {
				visit[i]=true;
				arr[depth]=card[i];
				dfs(depth+1);
				visit[i]=false;
			}
		}
	}

}

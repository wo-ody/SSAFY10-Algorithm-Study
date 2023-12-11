/*
 *  08.16 김창희
 *  BOJ_6443_애너그램
 *
 *  [풀이]
 *  1. next Permutation으로 모든 순열을 순차적으로 탐색
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static char[] arr;
	static int n;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder answer = new StringBuilder();
		
		n =Integer.parseInt(br.readLine());
		
		for(int i =0; i<n; i++) {
			arr =br.readLine().toCharArray();
			Arrays.sort(arr);
			do {
				for(char c : arr) answer.append(c);
				answer.append("\n");
			}while(np());
		}
		
		System.out.println(answer);
		
		
	}
	public static boolean np() {
		int len = arr.length;
		int x=len-1,y=len-1, l=len-1;
		
		while(x>0 && arr[x]<=arr[x-1]) x--;
		
		if(x==0) return false;
		
		while(arr[y]<=arr[x-1]) y--;
		
		swap(x-1,y);
		
		while(x<l) swap(x++, l--);
		return true;
	}
	
	public static void swap(int x,int y) {
		char temp = arr[x];
		arr[x] = arr[y];
		arr[y]=temp;
	
	}

}

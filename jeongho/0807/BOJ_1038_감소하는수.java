package algorithm2023.aug.day04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_1038_감소하는수 {
	static int N, cnt;
	static ArrayList<Long> arr = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		if(N>1022) {
			System.out.println(-1);
		}else {
			for (int i = 0; i < 10; i++) {
				subSet(0, i);
				Collections.sort(arr);
			}
			System.out.println(arr.get(N));
		}
		
		
	}
	
	static void subSet(long num, int last) {
		if(num*10+last>9876543210L)return;
		if(last>9)return;
		arr.add(num*10+last);
		for(int i= 0;i<10;i++) {
			if(last>i) {
				subSet(num*10+last, i);
			}
		}
	}
}

package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class BOJ_2751_수정렬하기2 {
	static int N;
	static HashSet<Integer> set = new HashSet<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			set.add(num);
		}
		
		ArrayList<Integer> list = new ArrayList<>(set);
		Collections.sort(list);
		
		for(int i=0; i<list.size(); i++) {
			sb.append(list.get(i)).append("\n");
		}
		
		System.out.println(sb);
		
	}
}

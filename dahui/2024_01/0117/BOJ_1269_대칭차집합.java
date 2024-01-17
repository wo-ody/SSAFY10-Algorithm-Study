package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_1269_대칭차집합 {
	static int A,B,all,diff,ans;
	static HashSet<Integer> set = new HashSet<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<A; i++) {
			int num = Integer.parseInt(st.nextToken());
				set.add(num);
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<B; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(set.contains(num)) {
				diff++;
			}else {
				set.add(num);
			}
		}
		
		System.out.println(set.size()-diff);
	}

}

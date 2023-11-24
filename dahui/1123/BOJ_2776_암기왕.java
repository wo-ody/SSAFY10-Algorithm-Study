package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_2776_암기왕 {
	static int N,M,T;
	static StringBuilder sb = new StringBuilder();
	static HashSet<Integer> set;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			N = Integer.parseInt(br.readLine());
			set = new HashSet<>();
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				set.add(Integer.parseInt(st.nextToken()));
			}
			M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				sb.append(set.contains(Integer.parseInt(st.nextToken()))
						?1:0).append("\n");
			}
		}
		
		System.out.println(sb);

	}

}

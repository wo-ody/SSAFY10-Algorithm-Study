package month10.day31;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1049_기타줄 {
	
	static int N, M, min;
	static int[] set, single;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		set = new int[M];
		single = new int[M];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			set[i] = Integer.parseInt(st.nextToken());
			single[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(set);
		Arrays.sort(single);
		
		min = Math.min( ( (N/6)+1 ) * set[0], N * single[0] );    
		min = Math.min( min, (N/6) * set[0] + (N%6) * single[0] );
		
		System.out.println(min);
	}
	
}

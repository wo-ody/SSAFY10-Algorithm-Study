package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10431_줄세우기 {
	static int T;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int cnt = 0;
			arr = new int[20];
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			for(int i=0; i<20; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0; i<20; i++) {
				for(int j=0; j<i; j++) {
					if(arr[i] < arr[j]) {
						cnt++;
					}
				}
			}
			
			sb.append(t).append(" ").append(cnt).append("\n");
		}
		
		System.out.println(sb);
	}

}

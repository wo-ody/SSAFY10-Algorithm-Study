package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_1388_바닥장식 {
	static int N,M;
	static char[][] arr;
	static boolean[][] check;
	static int cnt;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new char[N][M];
		check = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		simulation();
		
		System.out.println(cnt);
	}
		
		static void simulation() {
			Deque<Character> stack = new ArrayDeque<>();
			
			for(int i=0;i<N;i++) {
				for(int j=0; j<M; j++) {
					if(arr[i][j] == '-') {
						stack.add('-');
					}else {
						if(!stack.isEmpty()) {
							stack.clear();
							cnt++;
						}
					}
				}
				if(!stack.isEmpty()) {
					stack.clear();
					cnt++;
				}
				
			}
			
			for(int i=0;i<M;i++) {
				for(int j=0; j<N; j++) {
					if(arr[j][i] == '|') {
						stack.add('|');
					}else {
						if(!stack.isEmpty()) {
							stack.clear();
							cnt++;
						}
					}
				}
				if(!stack.isEmpty()) {
					stack.clear();
					cnt++;
				}
			}
		}
}

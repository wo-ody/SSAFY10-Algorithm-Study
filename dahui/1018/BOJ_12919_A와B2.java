package report;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//T -> S 로 줄이기 
public class BOJ_A와B2 {
	static String S,T;
	static boolean ans; 
	static StringBuilder sb;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine();
		T = br.readLine();
		
		dfs(T);
		
		if(ans) System.out.println(1);
		else System.out.println(0);

	}
	
	static void dfs(String T) {
		if(S.equals(T)) {
			ans = true;
			return;
		}
		
		if(T.length() == 0) return;
		
		if(T.charAt(T.length()-1) == 'A') {
			dfs(T.substring(0, T.length()-1));
		}
		
		if(T.charAt(0) == 'B') {
			sb = new StringBuilder(T);
			String T2 = sb.reverse().toString();
			dfs(T2.substring(0, T2.length()-1));
		}
	}

}

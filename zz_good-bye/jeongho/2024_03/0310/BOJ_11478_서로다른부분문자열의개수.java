package algorithm2024.mar.day10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_11478_서로다른부분문자열의개수 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		String S = br.readLine();
		Set<String> set = new HashSet<>();
		int cnt = 0;
		for (int i = 1; i <= S.length(); i++) {
			for (int j = 0; j < S.length() - i+1; j++) {
				String subStr = S.substring(j,j+i);
				if(!set.contains(subStr)){
					set.add(subStr);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}

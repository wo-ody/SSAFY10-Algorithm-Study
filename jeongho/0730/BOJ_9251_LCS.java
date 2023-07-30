package algorithm2023.jul.day30;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class G5_BOJ9251 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		
		int[][] LCS = new int[s1.length()+1][s2.length()+1];
		for(int i = 1;i<=s1.length();i++) {
			char a = s1.charAt(i-1);
			for(int j= 1;j<=s2.length();j++) {
				char b = s2.charAt(j-1);
				if(a!=b) {
					LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
				}else {
					LCS[i][j] = LCS[i-1][j-1]+1;
				}
			}
		}
		System.out.println(LCS[s1.length()][s2.length()]);
	}
}

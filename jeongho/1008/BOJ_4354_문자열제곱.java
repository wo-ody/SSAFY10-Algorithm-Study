package algorithm2023.oct.day07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_4354_문자열제곱_2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static String str;
	static int[] pi;
	static int ans = 0;

	public static void main(String[] args) throws Exception {
		str = br.readLine();
		while (str.charAt(0) != '.') {
			int l = str.length();
			int j = 0;
			ans = 1;
			pi = new int[l];
			looop: for (int i = 1; i < l; i++) {
				while (j > 0 && str.charAt(i) != str.charAt(j))
					j = pi[j - 1];
				if (str.charAt(i) == str.charAt(j)) {
					pi[i] = ++j;
				}
			}
			
			int sl = l-j;
			if(l%sl==0) {
				sb.append(l/sl);
			}else {
				sb.append(1);
			}
			
			sb.append("\n");
			str = br.readLine();
		}
		System.out.println(sb);
	}

}

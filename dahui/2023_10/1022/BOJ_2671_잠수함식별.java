package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class BOJ_2671_잠수함식별 {
	static int T;
	private static final Pattern P = Pattern.compile("(100+1+|01)+");
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		if(P.matcher(str).matches()) sb.append("SUBMARINE").append("\n");
		else sb.append("NOISE").append("\n");
		
		System.out.println(sb);

	}


}

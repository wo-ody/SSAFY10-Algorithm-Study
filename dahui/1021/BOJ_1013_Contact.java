package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class BOJ_1013_Contact {
	static int T;
	private static final Pattern P = Pattern.compile("(100+1+|01)+");
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			String str = br.readLine();
			if(P.matcher(str).matches()) sb.append("YES").append("\n");
			else sb.append("NO").append("\n");
		}
		
		System.out.println(sb);

	}


}

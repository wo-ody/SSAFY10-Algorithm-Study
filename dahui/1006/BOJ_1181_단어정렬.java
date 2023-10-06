package alone;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ_1181_단어정렬 {
	static int N;
	static String[] str;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		str = new String[N];
		
		for(int i=0; i<N; i++) {
			str[i] = br.readLine();
		}

		Arrays.sort(str, (s1, s2)-> {
			if(s1.length() == s2.length()) {
				return s1.compareTo(s2); //문자열을 사전순으로 정렬해준다.
			} else {
				return s1.length() - s2.length();
			}
		});
		
		sb.append(str[0]).append("\n");
		for(int i=1; i<N; i++) {
			if(!str[i].equals(str[i-1])) {
				sb.append(str[i]).append("\n");
			}
		}
		
		System.out.println(sb);
	}

}

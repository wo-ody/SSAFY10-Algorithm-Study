package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1316_그룹단어체커 {
	static boolean[] alphabet; //알파벳 사용 여부
	static int N, ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			alphabet = new boolean[26];
			char pre = str.charAt(0);
			alphabet[pre - 'a'] = true;
			if(str.length() == 1 ) ans++;
			for(int j=1; j<str.length(); j++) {
				if(pre != str.charAt(j) &&
						alphabet[str.charAt(j) - 'a'] == true) {
					break;
				}
				if(j == str.length()-1) ans++;
				alphabet[str.charAt(j) - 'a'] = true;
				pre = str.charAt(j);
			}
		}
		
		System.out.println(ans);

	}

}

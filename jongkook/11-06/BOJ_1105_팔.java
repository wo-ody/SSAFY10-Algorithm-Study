package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1105_팔 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String small = st.nextToken();
		String big = st.nextToken();
		
		int result = 0;
		
		if(small.equals(big)) {
			for(int i = 0; i < big.length(); i++) {
				if(small.charAt(i) == '8' && big.charAt(i) == '8') {
					result++;
				}
			}
			System.out.println(result);
			return;
		}
		
		if(small.length() == big.length()) {
			for(int i = 0; i < big.length(); i++) {
				if(small.charAt(i) == big.charAt(i)) {
					if(small.charAt(i) == '8' && big.charAt(i) == '8') {
						result++;
					}
				}
				else break;
			}
											
		}
		
		System.out.println(result);
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class UnknownSentence_1099 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int N = Integer.parseInt(br.readLine());
		String[] w = new String[N];
		for (int i = 0 ; i<N ; i++) {
			w[i]=br.readLine();
		}
		int[] dp = new int[s.length()+1];
		Arrays.fill(dp, 1000000);
		dp[0]=0;
		for (int i = 1 ; i<s.length()+1; i++) {
			for (int j = 0 ; j<i; j++) {
				String temp = s.substring(j,i);
				for (int k = 0 ; k<N ; k++) {
					if (judge(w[k],temp)) {
						dp[i]=Math.min(dp[i], dp[j]+calCost(w[k],temp));
					}
				}
			}
		}
		System.out.println((dp[s.length()]==1000000)?-1:dp[s.length()]);

	}
	static int calCost(String a, String b) {
		int ans = 0;
		char[] temp1 = a.toCharArray();
		char[] temp2 = b.toCharArray();
		for (int i = 0; i<a.length(); i++) {
			if (temp1[i]!=temp2[i]) {
				ans++;
			}
		}
		return ans;
	}
	static boolean judge(String a, String b) {
		if (a.length()==b.length()) {
			char[] temp1 = a.toCharArray();
			char[] temp2 = b.toCharArray();
			int[] alpha = new int[26];
			for (int i = 0 ; i<a.length(); i++) {
				alpha[temp1[i]-'a']++;
				alpha[temp2[i]-'a']--;
			}
			for (int i = 0 ; i<26; i++) {
				if(alpha[i]!=0) return false;
			}
			return true;
		} else {
			return false;
		}
	}
}

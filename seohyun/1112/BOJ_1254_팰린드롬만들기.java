import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj1254_펠린드롬만들기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = in.readLine();
		int ans = s.length();
		for(int i = 0; i < s.length(); i++) {
			if(isPalind(s.substring(i))) {
				break;
			}
			ans++;
		}
		System.out.println(ans);
	}

	static boolean isPalind(String s) {
		int start = 0;
		int last = s.length()-1;
		while(start <= last) {
			if(s.charAt(start) != s.charAt(last))
				return false;
			start++;
			last--;
		}
		return true;
	}
}

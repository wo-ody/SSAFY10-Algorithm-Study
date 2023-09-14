import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1316_그룹단어체커 {

	static int N, ans;
	static boolean[] visit;
	static char[] word;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N =Integer.parseInt(br.readLine());
		ans = 0;
		
		for (int i = 0; i < N; i++) {
			visit = new boolean[26]; // default = false;
			word = br.readLine().toCharArray();
			boolean isGroup = true;
			
			for (int j = 1; j < word.length ; j++) {
				if(visit[ word[j]-'a' ] == true) {
					isGroup = false;
					break;
				}
				if(word[j-1] != word[j]) {
					visit[ word[j-1]-'a' ] = true;
				}
			}
			
			if(isGroup) ans++;
		}
		
		System.out.println(ans);
		
	}

}

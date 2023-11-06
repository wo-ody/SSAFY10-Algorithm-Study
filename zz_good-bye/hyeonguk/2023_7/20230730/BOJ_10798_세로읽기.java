import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] character = new char[5][15];
		int maxNum = 0;
		int length = character.length;
		for (int i = 0; i < length; i++) {
			String str = br.readLine();
			if(maxNum < str.length()) maxNum = str.length();
			
			for (int j = 0; j < str.length(); j++) {
				character[i][j] = str.charAt(j);
				}
			}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < maxNum; i++) {
			for (int j = 0; j < 5; j++) {
				if(character[j][i] == '\0') continue;
				sb.append(character[j][i]);
				}
			}
		System.out.println(sb);
   }
}

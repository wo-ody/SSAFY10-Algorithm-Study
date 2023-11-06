import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] word = sc.next().toUpperCase().toCharArray();
		int [] alphabet = new int[26];
		
		int wordLen = word.length;
		for(int i=0; i<wordLen; i++) {
			alphabet[word[i]-'A']++;
		}
		
		int maxNum = 0;
		int idx = 0;
		for(int i=0; i<26; i++) {
			if (maxNum < alphabet[i]) {
				maxNum = alphabet[i];
				idx = i;
			}
		}
		
		int cnt = 0;
		for(int i=0; i<26; i++) {
			if (maxNum == alphabet[i]) {
				cnt++;
			}
		}
		
		if(cnt > 1) {
			System.out.println("?");
		}else {
			System.out.println((char)(idx+'A'));
		}
		sc.close();
	}
}

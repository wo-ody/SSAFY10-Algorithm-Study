import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] words = new int[26];
		for(int i=0; i<26; i++) {
			words[i] = -1;
		}
		String S = sc.next();
		int sLength = S.length();
		
		for(int i=0; i<sLength; i++) {
			char word = S.charAt(i);
			if (words[word-'a'] == -1) {
				words[word-'a'] = i;
			}
		}
		
		for(int num : words) {
			System.out.print(num+" ");
		}
		sc.close();
	}

}

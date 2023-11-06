import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			boolean[] used = new boolean[26];
			boolean check = false;
			
			char[] word = sc.next().toCharArray();
			int wordLen = word.length;
			for(int j=0; j<wordLen; j++) {
				if(used[word[j]-'a']) {
					if(word[j] != word[j-1]) {
						check = true;
						break;
					}
				}else {
					used[word[j]-'a'] = true;
				}
			}
			if(!check) {
				cnt += 1;
			}
		}
		System.out.println(cnt);
		sc.close();
	}
}

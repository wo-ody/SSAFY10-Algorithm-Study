import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N, answer;
	static String[] words;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		words = new String[N];
		
		for(int i=0; i<N; i++) {
			words[i] = br.readLine();
		}
		
		Arrays.sort(words);
	
		int cnt = 0;
		for(int i=0; i<N; i++) {
			if(amIprefix(i)) cnt++;
		}
		answer = N - cnt;
		
		System.out.println(answer);
	}
	
	static boolean amIprefix(int idx) {
		String word = words[idx];
		int length = word.length();
		for(int i = idx+1; i<N; i++) {
			if(words[i].length() >= length && words[i].substring(0, length).equals(word)) {
				return true;
			}
		}
		return false;
	}
}

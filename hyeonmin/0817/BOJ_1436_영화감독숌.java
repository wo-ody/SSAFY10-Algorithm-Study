import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1436_영화감독숌 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// N은 1~10000
		int N = Integer.parseInt(br.readLine());
		
		
		int answer = 666;
		for (int i = 1; i < N; i++) {
			answer++;
			while(Integer.toString(answer).indexOf("666") < 0) {
				answer++;
			}
		}
		
		System.out.println(answer);
	}

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2231_분해합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		int strLen = str.length();

		int N = Integer.parseInt(str);
		int answer = 0;

		for (int i = (N - (strLen * 9)); i < N; i++) {
			int number = i;
			int sum = 0; 

			while (number != 0) {
				sum += number % 10; 
				number /= 10;
			}

			if (sum + i == N) {
				answer = i;
				break;
			}

		}

		System.out.println(answer);
	}

}
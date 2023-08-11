import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1978_소수찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int count = N;
		for (int i = 0; i < N; i++) {
			int prime = Integer.parseInt(st.nextToken());
			if (prime == 1)
				count--;
			for (int j = 2; j < prime; j++) {
				if (prime % j == 0) {
					count--;
					break;
				}
			}
		}
		System.out.println(count);

	}

}

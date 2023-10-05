import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		int divisor = 5;

		while (divisor <= N) {
			cnt += N / divisor;
			divisor *= 5;
		}
		System.out.println(cnt);
	}

}

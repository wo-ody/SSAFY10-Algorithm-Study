import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15829_Hashing {

	static final int prime = 1234567891;
	static int L;
	static long answer, r;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		L = Integer.parseInt(br.readLine());
		r = 1;
		answer = 0;
		
		String str = br.readLine();
		for (int i = 0; i < L; i++) {
			int a = str.charAt(i) - 96;
			answer += (a * r) % prime;
			r = (r * 31) % prime;
		}
		System.out.println(answer % prime);

	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[] primes = {1, 2, 3, 5, 7, 9};
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		perm(0, 0);
		System.out.println(sb);
		
	}
	
	static void perm(int n, int num) {
		if(n == N) {
			sb.append(num).append("\n");
			return;
		}
		for(int i=0; i<6; i++) {
			int prime = num * 10 + primes[i];
			if(check(prime)) {
				perm(n+1, prime);
			}
		}
		
	}
	
	// 소수인지 판별
	static boolean check(int number) {
		if(number<2) return false;
		
		for(int i=2; i<=(int)Math.sqrt(number); i++) {
			if(number%i == 0) return false;
		}
		return true;
	}

}

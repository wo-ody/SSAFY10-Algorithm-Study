import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11050_이항계수1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
//		n! / (n-r)! * r!
//		pascal's triangle : nCr = (n-1)C(r-1) + (n-1)Cr
//		nCn = 1, nC0 = 1
		System.out.println(pascal(N,K));
		
	}
	static int pascal(int n, int k) {
		if(k == 0 || k == n) return 1;
		
		return pascal(n-1, k-1) + pascal(n-1, k);
	}

}

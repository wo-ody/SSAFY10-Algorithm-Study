import java.io.BufferedReader;
import java.io.InputStreamReader;

//A와 B의 개수를 따로 관리하면서 K번 눌렀을 때의 개수를 파악
//A[i]=B[i-1] B[i]=A[i-1]+B[i-1];
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int K;
	static int[] A, B;

	public static void main(String[] args) throws Exception {
		K = Integer.parseInt(br.readLine());

		A = new int[K];
		B = new int[K];

		A[0] = 0;
		B[0] = 1;

		for (int i = 1; i < K; i++) {
			A[i] = B[i - 1];
			B[i] = A[i - 1] + B[i - 1];
		}

		System.out.print(A[K - 1] + " " + B[K - 1]);
	}
}
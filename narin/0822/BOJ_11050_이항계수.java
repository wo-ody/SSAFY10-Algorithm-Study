import java.util.Scanner;

public class Main {
	private static int N, K;

	private static int comb(int n, int r) {
		if (n == r || r == 0)
			return 1;
		else
			return comb(n - 1, r - 1) + comb(n - 1, r);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		System.out.println(comb(N, K));
	}
}

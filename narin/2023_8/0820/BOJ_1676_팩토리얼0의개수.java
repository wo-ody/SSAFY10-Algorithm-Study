import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	private static BigInteger fact(int n) {
		if (n <= 1)
			return BigInteger.ONE;
		else
			return fact(n - 1).multiply(new BigInteger("" + n));
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String temp = String.valueOf(fact(N));
		int count = 0;

		for (int i = temp.length() - 1; i >= 0; i--) {
			if (temp.charAt(i) != '0')
				break;
			else
				count++;
		}

		System.out.println(count);
	}
}

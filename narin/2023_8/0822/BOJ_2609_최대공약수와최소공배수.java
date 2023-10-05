import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();

		int gcd = 1, lcm = a * b;

		int max = Math.max(a, b);
		for (int i = 1; i <= max; i++) {
			if (a % i == 0 && b % i == 0) {
				gcd = i;
			}
		}

		for (int i = 1; i <= a * b; i++) {
			if (i % a == 0 && i % b == 0) {
				if (lcm > i) {
					lcm = i;
				}
			}
		}

		System.out.println(gcd);
		System.out.println(lcm);
	}
}
